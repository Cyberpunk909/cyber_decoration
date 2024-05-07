package com.Cyber.punk.BoundingBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.Cyber.punk.Cyber;
import com.Cyber.punk.item.Entites;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
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
            this.setChanged();
            this.level.sendBlockUpdated(pos, this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE | Constants.BlockFlags.NOTIFY_NEIGHBORS);
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
    public CompoundNBT getUpdateTag() {
        CompoundNBT updateTag = super.getUpdateTag();
        updateTag.put("main", NBTUtil.writeBlockPos(this.getMainPos()));
        updateTag.putInt("redstone", this.currentRedstoneLevel);
        updateTag.putBoolean("receivedCoords", this.receivedCoords);
        return updateTag;
    }

    public void handleUpdateTag(BlockState state, @Nonnull CompoundNBT tag) {
        super.handleUpdateTag(state, tag);
        if (tag.contains("main")) {
            this.mainPos = NBTUtil.readBlockPos(tag.getCompound("main"));
        }

        this.currentRedstoneLevel = tag.getInt("redstone");
        this.receivedCoords = tag.getBoolean("receivedCoords");
    }
}
