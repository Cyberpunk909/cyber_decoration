package com.cyber.punk.custom_block.city_streets;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.city_streets.BusStationEntity;
import com.cyber.punk.util.AbstractCustomBlock;
import com.cyber.punk.util.Registry;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Map;
import java.util.stream.Stream;

public class BusStation extends AbstractCustomBlock {
    public BusStation() {
        super(Properties.of(
                        Material.METAL)
                .strength(4f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(-2.5, -11.3, 7.6, 18.5, -9.9, 11.8),
            Block.box(-1.1, -16, 9, 0.3, -11.1, 10.4),
            Block.box(15.7, -16, 9, 17.1, -11.1, 10.4),
            Block.box(-13, 29.2, -8.5, 29, 32, -6.4),
            Block.box(-9.5, 30.6, -6.4, 25.5, 31.3, 12.5),
            Block.box(-13, 29.2, -6.4, -9.5, 32, 12.5),
            Block.box(-13, 29.2, 12.5, 29, 32, 16),
            Block.box(25.5, 29.2, -6.4, 29, 32, 12.5),
            Block.box(26.2, -16, 13.2, 27.6, 29.4, 14.6),
            Block.box(26.2, -6.4, 1.3, 27.6, -4.3, 13.2),
            Block.box(26.2, -14.1, 1.3, 27.6, -12, 13.2),
            Block.box(26.2, -16, 0, 27.6, 29.4, 1.4),
            Block.box(26.2, 26.4, 1.3, 27.6, 29.2, 13.2),
            Block.box(-11.55, -16, 13.2, -10.15, 29.4, 14.6),
            Block.box(-11.55, -16, 0, -10.15, 29.4, 1.4),
            Block.box(-11.55, 26.4, 1.3, -10.15, 29.2, 13.2),
            Block.box(-11.55, -6.4, 1.3, -10.15, -4.3, 13.2),
            Block.box(-11.55, -14.1, 1.3, -10.15, -12, 13.2),
            Block.box(-10.15, -6.4, 13.2, 7.35, -4.3, 14.6),
            Block.box(-10.15, -4.3, 13.9, 7.35, 10.4, 14),
            Block.box(-10.15, -12, 13.9, 7.35, -6.4, 14),
            Block.box(7.3, -16, 13.2, 8.7, 29.4, 14.6),
            Block.box(-10.15, 26.4, 13.2, 7.35, 29.2, 14.6),
            Block.box(8.7, 26.4, 13.2, 26.2, 29.2, 14.6),
            Block.box(8.7, -6.4, 13.2, 26.2, -4.3, 14.6),
            Block.box(-11.55, 9.6, 1.3, -10.15, 11.7, 13.2),
            Block.box(-10.15, 11.7, 13.9, 7.35, 26.4, 14),
            Block.box(8.85, 11.7, 13.9, 26.35, 26.4, 14),
            Block.box(8.85, -4.3, 13.9, 26.35, 10.4, 14),
            Block.box(-10.15, 9.6, 13.2, 7.35, 11.7, 14.6),
            Block.box(8.7, 9.6, 13.2, 26.2, 11.7, 14.6),
            Block.box(26.2, 9.6, 1.3, 27.6, 11.7, 13.2),
            Block.box(8.7, -14.1, 13.2, 26.2, -12, 14.6),
            Block.box(8.85, -12, 13.9, 26.35, -6.4, 14),
            Block.box(-10.15, -14.1, 13.2, 7.35, -12, 14.6)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).map(voxelShape -> voxelShape.move(0, 1, 0)).get();

    private static final VoxelShape SHAPE_E = VoxelUtil.rotateShape(Direction.NORTH, Direction.EAST, SHAPE_N);
    private static final VoxelShape SHAPE_S = VoxelUtil.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE_N);
    private static final VoxelShape SHAPE_W = VoxelUtil.rotateShape(Direction.NORTH, Direction.WEST, SHAPE_N);

    private static final Map<Direction, VoxelShape> SHAPES = ImmutableMap.of(
            Direction.NORTH, SHAPE_N,
            Direction.EAST, SHAPE_E,
            Direction.SOUTH, SHAPE_S,
            Direction.WEST, SHAPE_W
    );

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new BusStationEntity();
    }

    @Override
    protected Map<Direction, VoxelShape> getShapes() {
        return SHAPES;
    }

    @Override
    protected boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.WEST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (!state.isAir() && !state.getMaterial().isReplaceable()) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.WEST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.SOUTH)};
                break;
        }

        VoxelShape shape = getShapes().get(facing);

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (state.isAir() || state.getMaterial().isReplaceable()) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(pos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(-blockPos.getX() + pos.getX(), -blockPos.getY() + pos.getY(), -blockPos.getZ() + pos.getZ()));
                }
            }
        }
    }

    @Override
    protected void removeBoundingBlocks(World world, BlockPos pos, BlockState blockState, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.WEST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.WEST).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.EAST).relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
