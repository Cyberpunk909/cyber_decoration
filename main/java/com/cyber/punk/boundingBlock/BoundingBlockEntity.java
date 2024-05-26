package com.cyber.punk.boundingBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.cyber.punk.Cyber;
import com.cyber.punk.Entites;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.LazyOptional;

public class BoundingBlockEntity extends TileEntity {
    private BlockPos mainPos;
    public boolean receivedCoords;
    private int currentRedstoneLevel;
    private VoxelShape customShape;

    public BoundingBlockEntity() {
        super(Entites.BOUNDING_BLOCK.get());
        this.mainPos = BlockPos.ZERO;
    }
    public void setCustomShape(VoxelShape shape) {
        this.customShape = shape;
        BlockState state = level.getBlockState(getBlockPos());
        level.sendBlockUpdated(getBlockPos(), state, state, 3);
    }

    public VoxelShape getCustomShape() {
        return this.customShape;
    }

    public void setMainLocation(BlockPos pos) {
        receivedCoords = pos != null;
        if (!this.level.isClientSide()) {
            mainPos = pos;
            BlockState state = getBlockState();
            level.sendBlockUpdated(getBlockPos(), state, state, Constants.BlockFlags.DEFAULT);
            this.setChanged();
        }
    }

    public BlockPos getMainPos() {
        if (this.mainPos == null) {
            this.mainPos = BlockPos.ZERO;
        }
        return this.mainPos;
    }

    @Nullable
    public TileEntity getMainTile() {
        return this.receivedCoords ? this.level.getBlockEntity(this.getMainPos()) : null;
    }

    @Nullable
    private IBoundingBlockEntity getMain() {
        TileEntity tile = this.getMainTile();
        if (tile != null && !(tile instanceof IBoundingBlockEntity)) {
            Cyber.LOGGER.error("Found tile {} instead of an IBoundingBlock, at {}. Multiblock cannot function", tile, this.getMainPos());
            return null;
        } else {
            return (IBoundingBlockEntity)tile;
        }
    }

    @Nonnull
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> capability, @Nullable Direction side) {
        IBoundingBlockEntity main = this.getMain();
        return main == null ? super.getCapability(capability, side) : main.getOffsetCapability(capability, side, worldPosition.subtract(getMainPos()));
    }

    public void onNeighborChange(Block block, BlockPos neighborPos) {
        if (!this.level.isClientSide) {
            int power = level.getBestNeighborSignal(getBlockPos());
            if (this.currentRedstoneLevel != power) {
                IBoundingBlockEntity main = this.getMain();
                if (main != null) {
                    main.onBoundingBlockPowerChange(worldPosition, currentRedstoneLevel, power);
                }
                this.currentRedstoneLevel = power;
            }
        }
    }

    public int getComparatorSignal() {
        IBoundingBlockEntity main = this.getMain();
        return main != null && main.supportsComparator() ? main.getBoundingComparatorSignal(worldPosition.subtract(getMainPos())) : 0;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        mainPos = NBTUtil.readBlockPos(nbt.getCompound("mainPos"));
        this.currentRedstoneLevel = nbt.getInt("redstone");
        this.receivedCoords = nbt.getBoolean("receivedCoords");
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.put("mainPos", NBTUtil.writeBlockPos(mainPos));
        nbt.putInt("redstone", this.currentRedstoneLevel);
        nbt.putBoolean("receivedCoords", this.receivedCoords);
        return nbt;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), 0, getUpdateTag());
    }

    @Nonnull
    @Override
    public CompoundNBT getUpdateTag() {
        return save(new CompoundNBT());
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        load(state, tag);
    }

    @Override
    public void onDataPacket(NetworkManager manager, @Nonnull SUpdateTileEntityPacket packet) {
        handleUpdateTag(getBlockState(), packet.getTag());
    }
}
