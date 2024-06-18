package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalAmbulanceBedEntity;
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

public class HospitalAmbulanceBed extends AbstractCustomBlock {
    public HospitalAmbulanceBed() {
        super(Properties.of(
                        Material.HEAVY_METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3, 0, -6.9999999999999964, 13, 2, 15.999999999999988),
            Block.box(5, 2, -2.999999999999999, 11, 6, 12.000000000000005),
            Block.box(4, 6, -3.9999999999999996, 12, 10, 13.000000000000005),
            Block.box(0, 10, -3.9999999999999996, 16, 13, 13.000000000000005),
            Block.box(16, 15, -0.9999999999999996, 19, 16, 12.000000000000005),
            Block.box(16, 10, 2, 17, 15, 5.0000000000000036),
            Block.box(-1, 10, 2, 0, 15, 5.0000000000000036),
            Block.box(-3, 15, -0.9999999999999996, 0, 16, 12.000000000000005),
            Block.box(0, 9, 13, 17, 18, 26),
            Block.box(0, 14, 26, 17, 27, 32),
            Block.box(0, 5, -16, 17, 13, -4)
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
        return new HospitalAmbulanceBedEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
