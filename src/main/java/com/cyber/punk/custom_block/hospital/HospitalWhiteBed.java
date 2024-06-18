package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalWhiteBedEntity;
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

public class HospitalWhiteBed extends AbstractCustomBlock {
    public HospitalWhiteBed() {
        super(Properties.of(
                        Material.HEAVY_METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0.953, 7.047, 0.23450000000000193, 15.047, 9.396, 30.771500000000003),
            Block.box(3.302, 9.396, 24.5075, 12.698, 10.962, 29.2055),
            Block.box(14.264, 7.047, -0.5484999999999984, 15.83, 12.528, 0.23450000000000193),
            Block.box(14.264, 7.047, 30.771500000000003, 15.83, 17.226, 31.554500000000004),
            Block.box(0.17, 7.047, 30.771500000000003, 1.736, 17.226, 31.554500000000004),
            Block.box(1.736, 15.66, 30.771500000000003, 14.264, 17.226, 31.554500000000004),
            Block.box(1.736, 5.481, 30.771500000000003, 14.264, 7.047, 31.554500000000004),
            Block.box(14.264, 2.349, -0.5484999999999984, 15.83, 5.481, 1.0175000000000014),
            Block.box(1.736, 7.047, 31.163000000000004, 14.264, 15.66, 31.163000000000004),
            Block.box(1.736, 10.962, -0.5484999999999984, 14.264, 12.528, 0.23450000000000193),
            Block.box(1.736, 5.481, -0.5484999999999984, 14.264, 7.047, 0.23450000000000193),
            Block.box(14.6555, 0, -0.5484999999999984, 15.4385, 1.566, 1.0175000000000014),
            Block.box(14.6555, 1.566, 0.038750000000001616, 15.4385, 2.349, 0.8217500000000016),
            Block.box(13.8725, 1.9575, -0.9399999999999982, 16.2215, 2.7405, 1.4090000000000016),
            Block.box(1.736, 7.047, 0.038750000000001616, 14.264, 10.962, 0.038750000000001616),
            Block.box(14.264, 5.481, -0.5484999999999984, 15.83, 7.047, 31.554500000000004),
            Block.box(0.17, 7.047, -0.5484999999999984, 1.736, 12.528, 0.23450000000000193),
            Block.box(0.17, 5.481, -0.5484999999999984, 1.736, 7.047, 31.554500000000004),
            Block.box(0.17, 2.349, -0.5484999999999984, 1.736, 5.481, 1.0175000000000014),
            Block.box(-0.2215, 1.9575, -0.9399999999999982, 2.1275, 2.7405, 1.4090000000000016),
            Block.box(0.5615, 1.566, 0.038750000000001616, 1.3445, 2.349, 0.8217500000000016),
            Block.box(0.5615, 0, -0.5484999999999984, 1.3445, 1.566, 1.0175000000000014),
            Block.box(14.264, 2.349, 29.988500000000002, 15.83, 5.481, 31.554500000000004),
            Block.box(13.8725, 1.9575, 29.597, 16.2215, 2.7405, 31.945999999999998),
            Block.box(14.6555, 1.566, 30.57575, 15.4385, 2.349, 31.35875),
            Block.box(14.6555, 0, 29.988500000000002, 15.4385, 1.566, 31.554500000000004),
            Block.box(0.17, 2.349, 29.988500000000002, 1.736, 5.481, 31.554500000000004),
            Block.box(-0.2215, 1.9575, 29.597, 2.1275, 2.7405, 31.945999999999998),
            Block.box(0.5615, 1.566, 30.57575, 1.3445, 2.349, 31.35875),
            Block.box(0.5615, 0, 29.988500000000002, 1.3445, 1.566, 31.554500000000004),
            Block.box(15.4385, 7.047, 1.8005000000000018, 15.4385, 11.745, 20.5925),
            Block.box(0.5615, 7.047, 1.8005000000000018, 0.5615, 11.745, 20.5925),
            Block.box(14.264, 3.915, 1.0175000000000014, 15.83, 4.698, 29.988500000000002),
            Block.box(0.17, 3.915, 1.0175000000000014, 1.736, 4.698, 29.988500000000002),
            Block.box(1.736, 3.915, -0.5484999999999984, 14.264, 4.698, 1.0175000000000014),
            Block.box(1.736, 3.915, 29.988500000000002, 14.264, 4.698, 31.554500000000004),
            Block.box(1.736, 6.264, 1.0175000000000014, 14.264, 6.264, 29.988500000000002)
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
        return new HospitalWhiteBedEntity();
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
