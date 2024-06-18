package com.cyber.punk.custom_block.hospital;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.hospital.HospitalBedsideTableEntity;
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

public class HospitalBedsideTable extends AbstractCustomBlock {
    public HospitalBedsideTable() {
        super(Properties.of(
                        Material.METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(9.950000000000001, 13, 2, 31.95, 15, 14),
            Block.box(12.950000000000001, 4, 6.5, 15.950000000000001, 11, 9.5),
            Block.box(11.950000000000001, 11, 6, 21.95, 13, 10),
            Block.box(8.950000000000001, 3.5, 6, 28.95, 4.5, 10),
            Block.box(8.950000000000001, 2.5, 3, 10.950000000000001, 3.5, 13),
            Block.box(9.200000000000001, 2, 3.5, 10.200000000000001, 3, 4.5),
            Block.box(8.950000000000001, 0, 3.5, 10.950000000000001, 2, 4.5),
            Block.box(9.200000000000001, 2, 11.5, 10.200000000000001, 3, 12.5),
            Block.box(8.950000000000001, 0, 11.5, 10.950000000000001, 2, 12.5),
            Block.box(26.95, 2.5, 3, 28.95, 3.5, 13),
            Block.box(26.95, 0, 3.5, 28.95, 2, 4.5),
            Block.box(27.2, 2, 3.5, 28.2, 3, 4.5),
            Block.box(26.95, 0, 11.5, 28.95, 2, 12.5),
            Block.box(27.2, 2, 11.5, 28.2, 3, 12.5)
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
        return new HospitalBedsideTableEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
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
