package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalLongCurtainEntity;
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

public class HospitalLongCurtain extends AbstractCustomBlock {
    public HospitalLongCurtain() {
        super(Properties.of(
                        Material.METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(18.9, 6.3, 8.1, 29.7, 28.8, 8.2),
            Block.box(29.7, 2.7, 7.1, 31.5, 31.5, 8.9),
            Block.box(18.9, 29.7, 7.1, 29.7, 31.5, 8.9),
            Block.box(29.25, 1.8, 3.95, 31.95, 2.7, 12.05),
            Block.box(29.7, 0, 4.85, 31.5, 1.8, 5.75),
            Block.box(29.7, 0, 10.25, 31.5, 1.8, 11.15),
            Block.box(18.9, 3.6, 7.1, 29.7, 5.4, 8.9),
            Block.box(8.1, 6.3, 8.1, 18.9, 28.8, 8.2),
            Block.box(-2.9000000000000004, 6.3, 8.1, 8.099999999999998, 28.8, 8.2),
            Block.box(-13.9, 6.3, 8.1, -2.900000000000002, 28.8, 8.2),
            Block.box(-15.5, 2.7, 7.1, -13.7, 31.5, 8.9),
            Block.box(8.1, 29.7, 7.1, 18.9, 31.5, 8.9),
            Block.box(-15.95, 1.8, 3.95, -13.25, 2.7, 12.05),
            Block.box(-15.5, 0, 4.85, -13.7, 1.8, 5.75),
            Block.box(-15.5, 0, 10.25, -13.7, 1.8, 11.15),
            Block.box(8.1, 3.6, 7.1, 18.9, 5.4, 8.9),
            Block.box(-2.9000000000000004, 3.6, 7.1, 8.099999999999998, 5.4, 8.9),
            Block.box(-13.700000000000001, 3.6, 7.1, -2.9000000000000012, 5.4, 8.9),
            Block.box(-2.7, 29.700000000000003, 7.1, 8.099999999999998, 31.5, 8.9),
            Block.box(-13.700000000000001, 29.700000000000003, 7.1, -2.700000000000002, 31.5, 8.9)
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
        return new HospitalLongCurtainEntity();
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
