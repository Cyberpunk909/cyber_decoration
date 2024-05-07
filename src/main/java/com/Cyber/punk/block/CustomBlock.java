package com.Cyber.punk.block;

import com.Cyber.punk.BoundingBlock.BoundingBlock;
import com.Cyber.punk.BoundingBlock.BoundingBlockEntity;
import com.Cyber.punk.BoundingBlock.ICustomShapeProvider;
import com.Cyber.punk.BoundingBlock.VoxelUtil;
import com.Cyber.punk.block.entity.CustomBlockEntity;
import com.Cyber.punk.item.Registry;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Map;
import java.util.stream.Stream;

public class CustomBlock extends HorizontalBlock implements ICustomShapeProvider {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public CustomBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(5.0F).noOcclusion());
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
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CustomBlockEntity();
    }

    @Override
    public void onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide && !oldState.is(state.getBlock())) {
            placeBoundingBlocks(world, pos, state.getValue(FACING));
        }
    }
    private void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions = new BlockPos[]{
                pos.relative(Direction.EAST), pos.relative(Direction.WEST)
        };

        VoxelShape shape = SHAPES.get(facing);
        Vector3d offset = OFFSETS.get(facing);

        for (BlockPos blockPos : positions) {
            if (world.isEmptyBlock(blockPos)) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(pos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(-blockPos.getX() + pos.getX(), -blockPos.getY() + pos.getY(), -blockPos.getZ() + pos.getZ()).move(offset.x, offset.y, offset.z));
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            removeBoundingBlocks(world, pos);
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    private void removeBoundingBlocks(World world, BlockPos pos) {
        BlockPos[] positions = new BlockPos[]{
                pos.relative(Direction.EAST),
                pos.relative(Direction.WEST)
        };

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(-14.5, 13, -2, 31.5, 16, 2),
            Block.box(-14.5, 13, 6, 31.5, 16, 10),
            Block.box(-15.5, 13, 10, 30.5, 16, 14),
            Block.box(-15.5, 13, 2, 30.5, 16, 6),
            Block.box(-14.5, 13, 14, 31.5, 16, 18),
            Block.box(26.5, 2, 3, 29.5, 4, 13),
            Block.box(-13.5, 2, 3, -10.5, 4, 13),
            Block.box(-10.5, 2, 6, 26.5, 4, 10),
            Block.box(26.5, 6, 0, 29.5, 10, 3),
            Block.box(25.5, 0, -1, 30.5, 3, 4),
            Block.box(26, 3, -0.5, 30, 6, 3.5),
            Block.box(26.5, 6, 13, 29.5, 10, 16),
            Block.box(26, 3, 12.5, 30, 6, 16.5),
            Block.box(25.5, 0, 12, 30.5, 3, 17),
            Block.box(26, 10, -2.5, 30, 13, 18.5),
            Block.box(-13, 6, 13, -10, 10, 16),
            Block.box(-13.5, 3, 12.5, -9.5, 6, 16.5),
            Block.box(-14, 0, 12, -9, 3, 17),
            Block.box(-13.5, 10, -2.5, -9.5, 13, 18.5),
            Block.box(-14, 0, -1, -9, 3, 4),
            Block.box(-13.5, 3, -0.5, -9.5, 6, 3.5),
            Block.box(-13, 6, 0, -10, 10, 3)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    private static final VoxelShape SHAPE_E = VoxelUtil.rotateShape(Direction.NORTH, Direction.EAST, SHAPE_N);
    private static final VoxelShape SHAPE_S = VoxelUtil.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE_N);
    private static final VoxelShape SHAPE_W = VoxelUtil.rotateShape(Direction.NORTH, Direction.WEST, SHAPE_N);
    private static final Map<Direction, VoxelShape> SHAPES = ImmutableMap.of(
            Direction.NORTH, SHAPE_N,
            Direction.SOUTH, SHAPE_S,
            Direction.WEST, SHAPE_W,
            Direction.EAST, SHAPE_E
    );
    private static final Map<Direction, Vector3d> OFFSETS = ImmutableMap.of(
            Direction.NORTH, new Vector3d(0.0, 1.0, -0.264),
            Direction.SOUTH, new Vector3d(0.0, 1.0, 0.264),
            Direction.WEST, new Vector3d(-0.264, 1.0, 0.0),
            Direction.EAST, new Vector3d(0.264, 1.0, 0.0)
    );

    @Override
    public VoxelShape getCustomShape(IBlockReader world, BlockPos pos) {
        Direction facing = world.getBlockState(pos).getValue(FACING);
        switch (facing) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }
}
