package com.cyber.punk.util;

import com.cyber.punk.bounding_block.ICustomShapeProvider;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public abstract class AbstractCustomBlock extends HorizontalBlock implements ICustomShapeProvider {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public AbstractCustomBlock(AbstractBlock.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public abstract TileEntity createTileEntity(BlockState state, IBlockReader world);

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        BlockPos pos = context.getClickedPos();
        World world = context.getLevel();
        if (!canPlaceBlockAt(world, pos, facing)) {
            return null;
        }
        return this.defaultBlockState().setValue(FACING, facing);
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!canPlaceBlockAt(world, pos, state.getValue(FACING))) {
            return ActionResultType.FAIL;
        }
        return super.use(state, world, pos, player, hand, hit);
    }

    @Override
    public void onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide && !oldState.is(state.getBlock())) {
            placeBoundingBlocks(world, pos, state.getValue(FACING));
        }
    }

    protected abstract boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing);

    protected abstract void placeBoundingBlocks(World world, BlockPos pos, Direction facing);

    protected abstract void removeBoundingBlocks(World world, BlockPos pos, BlockState blockState, Direction facing);

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            removeBoundingBlocks(world, pos, state, state.getValue(FACING));
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClientSide) {
            if (!player.isCreative()) {
                removeBoundingBlocks(world, pos, state, state.getValue(FACING));
                popResource(world, pos, new ItemStack(this));
            } else {
                removeBoundingBlocks(world, pos, state, state.getValue(FACING));
            }
        }
        if (world.isClientSide) {
            world.levelEvent(player, 2001, pos, Block.getId(state));
        }
        super.playerWillDestroy(world, pos, state, player);
    }

    protected abstract Map<Direction, VoxelShape> getShapes();

    @Override
    public VoxelShape getShape(@NotNull BlockState blockState, IBlockReader reader, BlockPos pos, ISelectionContext context) {
        return getShapes().get(blockState.getValue(FACING));
    }

    @Override
    public VoxelShape getCustomShape(IBlockReader world, BlockPos pos) {
        Direction facing = world.getBlockState(pos).getValue(FACING);
        return getShapes().get(facing);
    }
}
