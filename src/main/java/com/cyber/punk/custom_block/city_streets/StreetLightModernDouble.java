package com.cyber.punk.custom_block.city_streets;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.city_streets.StreetLightModernDoubleEntity;
import com.cyber.punk.entity.city_streets.StreetLightModernEntity;
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

public class StreetLightModernDouble extends AbstractCustomBlock {
    public StreetLightModernDouble() {
        super(Properties.of(
                        Material.HEAVY_METAL)
                .strength(3f,4.0f)
                .noOcclusion()
                .lightLevel((state) -> 15));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(5.999999999999999, -16, 6, 10, 17, 10),
            Block.box(6.000000000000001, 17, -11.999999999999998, 10, 23, 8.000000000000002),
            Block.box(6.000000000000001, 17, 8.000000000000002, 10, 23, 28)
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
        return new StreetLightModernDoubleEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST)};
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
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP), pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above().relative(Direction.WEST)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}

