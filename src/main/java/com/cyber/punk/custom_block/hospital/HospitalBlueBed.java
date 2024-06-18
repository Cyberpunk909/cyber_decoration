package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalBlueBedEntity;
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

public class HospitalBlueBed extends AbstractCustomBlock {
    public HospitalBlueBed() {
        super(Properties.of(
                        Material.HEAVY_METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0.15019999999999845, 6.111200000000002, -4.594200000000001, 15.849800000000002, 9.600000000000001, 14.5942),
            Block.box(15.93702, 5.239000000000002, -4.594200000000001, 15.93702, 11.3444, 17.2108),
            Block.box(0.06297999999999837, 5.239000000000002, -4.594200000000001, 0.06297999999999837, 11.3444, 17.2108),
            Block.box(0.15019999999999845, 6.983400000000001, -11.571800000000003, 15.849800000000002, 9.600000000000001, -4.594200000000001),
            Block.box(0.15019999999999845, 6.983400000000001, 14.5942, 15.849800000000002, 9.600000000000001, 21.5718),
            Block.box(1.0223999999999984, 8.727800000000002, -15.9328, 14.977599999999999, 8.727800000000002, -11.571800000000003),
            Block.box(1.0223999999999984, 8.727800000000002, 21.5718, 14.977599999999999, 8.727800000000002, 25.9328),
            Block.box(13.2332, 2.6224, -5.4664, 14.977599999999999, 6.983400000000001, -3.7219999999999995),
            Block.box(13.6693, 0, -5.4664, 14.5415, 1.744400000000001, -3.7219999999999995),
            Block.box(13.6693, 1.7502000000000004, -4.812250000000002, 14.5415, 2.6224, -3.940050000000001),
            Block.box(12.7971, 2.1862999999999992, -5.902500000000003, 15.413699999999999, 3.0584999999999996, -3.2859000000000016),
            Block.box(1.0223999999999984, 2.6224, -5.4664, 2.7667999999999986, 6.983400000000001, -3.7219999999999995),
            Block.box(0.5862999999999985, 2.1862999999999992, -5.902500000000003, 3.2028999999999983, 3.0584999999999996, -3.2859000000000016),
            Block.box(1.4584999999999986, 1.7502000000000004, -4.812250000000002, 2.3306999999999984, 2.6224, -3.940050000000001),
            Block.box(1.4584999999999986, 0, -5.4664, 2.3306999999999984, 1.744400000000001, -3.7219999999999995),
            Block.box(1.0223999999999984, 2.6224, 13.722000000000001, 2.7667999999999986, 6.983400000000001, 15.466399999999997),
            Block.box(0.5862999999999985, 2.1862999999999992, 13.285900000000002, 3.2028999999999983, 3.0584999999999996, 15.9025),
            Block.box(1.4584999999999986, 1.7502000000000004, 14.376149999999999, 2.3306999999999984, 2.6224, 15.248349999999999),
            Block.box(1.4584999999999986, 0, 13.722000000000001, 2.3306999999999984, 1.744400000000001, 15.466399999999997),
            Block.box(13.2332, 2.6224, 13.722000000000001, 14.977599999999999, 6.983400000000001, 15.466399999999997),
            Block.box(12.7971, 2.1862999999999992, 13.285900000000002, 15.413699999999999, 3.0584999999999996, 15.9025),
            Block.box(13.6693, 1.7502000000000004, 14.376149999999999, 14.5415, 2.6224, 15.248349999999999),
            Block.box(13.6693, 0, 13.722000000000001, 14.5415, 1.744400000000001, 15.466399999999997)
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
        return new HospitalBlueBedEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
