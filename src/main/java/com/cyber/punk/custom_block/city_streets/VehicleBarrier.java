package com.cyber.punk.custom_block.city_streets;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.city_streets.VehicleBarrierEntity;
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

public class VehicleBarrier extends AbstractCustomBlock {
    public VehicleBarrier() {
        super(Properties.of(
                        Material.METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(-16, 9.75, 3.25, 23.48964, 14.25, 4.25),
            Block.box(23.48964, 8.75, 2.75, 31.48964, 15.25, 4.75),
            Block.box(25.98964, 10.7, 4.5, 28.98964, 13.2, 5.5),
            Block.box(23.48964, 0, 4.5, 31.48964, 1, 11.5),
            Block.box(24.48964, 1, 5.5, 30.48964, 18.5, 10.5),
            Block.box(23.98964, 16, 5, 30.98964, 20.5, 11)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

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
        return new VehicleBarrierEntity();
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
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
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
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
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
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH),
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}