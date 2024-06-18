package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalBedEntity;
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

public class HospitalBed extends AbstractCustomBlock {
    public HospitalBed() {
        super(Properties.of(
                        Material.HEAVY_METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0.8557999999999987, 6.3648, 0.6154750000000022, 15.1442, 9.54, 29.986075000000007),
            Block.box(3.2371999999999987, 9.54, 24.429475000000004, 12.762799999999997, 11.127600000000001, 29.19227500000001),
            Block.box(0.06199999999999872, 4.7772, 0.6154750000000022, 1.6495999999999986, 6.3648, 29.986075000000007),
            Block.box(14.350399999999999, 4.7772, 0.6154750000000022, 15.938, 6.3648, 29.986075000000007),
            Block.box(1.6495999999999986, 5.1741, 0.6154750000000022, 14.350399999999999, 5.1741, 29.986075000000007),
            Block.box(1.6495999999999986, 8.7462, -0.9721249999999975, 14.350399999999999, 10.3338, 0.6154750000000022),
            Block.box(1.6495999999999986, 4.7772, -0.9721249999999975, 14.350399999999999, 6.3648, 0.6154750000000022),
            Block.box(1.6495999999999986, 6.3648, -0.3767749999999981, 14.350399999999999, 8.7462, -0.3767749999999981),
            Block.box(1.6495999999999986, 6.3648, 31.176775000000006, 14.350399999999999, 8.7462, 31.176775000000006),
            Block.box(14.350399999999999, 2.3958, 29.986075000000007, 15.938, 17.478, 31.57367500000001),
            Block.box(0.06199999999999872, 2.3958, 29.986075000000007, 1.6495999999999986, 17.478, 31.57367500000001),
            Block.box(14.350399999999999, 2.3958, -0.9721249999999975, 15.938, 10.3338, 0.6154750000000022),
            Block.box(13.9535, 1.9989000000000001, -1.369024999999998, 16.334899999999998, 2.7927000000000004, 1.0123750000000031),
            Block.box(14.747300000000001, 0, -0.9721249999999975, 15.541100000000002, 1.5876000000000001, 0.6154750000000022),
            Block.box(14.747300000000001, 1.602, -0.3767749999999981, 15.541100000000002, 2.3958, 0.41702500000000287),
            Block.box(0.06199999999999872, 2.3958, -0.9721249999999975, 1.6495999999999986, 10.3338, 0.6154750000000022),
            Block.box(-0.33490000000000153, 1.9989000000000001, -1.369024999999998, 2.0464999999999987, 2.7927000000000004, 1.0123750000000031),
            Block.box(0.45889999999999853, 1.602, -0.3767749999999981, 1.2526999999999986, 2.3958, 0.41702500000000287),
            Block.box(0.45889999999999853, 0, -0.9721249999999975, 1.2526999999999986, 1.5876000000000001, 0.6154750000000022),
            Block.box(14.747300000000001, 0, 29.986075000000007, 15.541100000000002, 1.5876000000000001, 31.57367500000001),
            Block.box(14.747300000000001, 1.602, 30.581425000000003, 15.541100000000002, 2.3958, 31.375225000000007),
            Block.box(13.9535, 1.9989000000000001, 29.589175000000004, 16.334899999999998, 2.7927000000000004, 31.97057500000001),
            Block.box(0.45889999999999853, 0, 29.986075000000007, 1.2526999999999986, 1.5876000000000001, 31.57367500000001),
            Block.box(0.45889999999999853, 1.602, 30.581425000000003, 1.2526999999999986, 2.3958, 31.375225000000007),
            Block.box(-0.33490000000000153, 1.9989000000000001, 29.589175000000004, 2.0464999999999987, 2.7927000000000004, 31.97057500000001),
            Block.box(1.6495999999999986, 15.8904, 29.986075000000007, 14.350399999999999, 17.478, 31.57367500000001),
            Block.box(1.6495999999999986, 8.7462, 29.986075000000007, 14.350399999999999, 10.3338, 31.57367500000001),
            Block.box(1.6495999999999986, 4.7772, 29.986075000000007, 14.350399999999999, 6.3648, 31.57367500000001),
            Block.box(1.6495999999999986, 10.3338, 30.978325000000005, 14.350399999999999, 15.8904, 30.978325000000005)
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
        return new HospitalBedEntity();
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
