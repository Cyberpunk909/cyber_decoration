package com.cyber.punk.custom_block.summer_decoration;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.dungeon_decoration.DungeonHangFlagEntity;
import com.cyber.punk.util.AbstractCustomBlock;
import com.cyber.punk.util.Registry;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
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

public class OakTree extends AbstractCustomBlock {

    public OakTree() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD)
                .strength(1f,4.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6, -13, 6, 9, -3, 9),
            Block.box(6, -3, 6, 9, 13, 9),
            Block.box(9, 2, 6, 21, 5, 9),
            Block.box(-6, 0, 6, 6, 3, 9),
            Block.box(6, 5, -6, 9, 8, 6),
            Block.box(8, 13, -2.5, 19, 25, -2.5),
            Block.box(-3, 15, -2.5, 8, 27, -2.5),
            Block.box(4, 9, -7.5, 15, 21, -7.5),
            Block.box(16, 12, 5.25, 27, 24, 5.25),
            Block.box(1, 6, -7.5, 12, 18, -7.5),
            Block.box(-13, 12, 4.5, -2, 24, 4.5),
            Block.box(-13, 6, -7.5, -2, 18, -7.5),
            Block.box(19.25, 7, 8.5, 30.25, 19, 8.5),
            Block.box(5.25, 16, 21, 16.25, 28, 21),
            Block.box(-15, 8, 9, -4, 20, 9),
            Block.box(-2, 13, 21.5, 9, 25, 21.5),
            Block.box(7.5, 14, -14, 7.5, 26, -3),
            Block.box(7.5, 17, -3, 7.5, 29, 8),
            Block.box(6.5, 20, 4, 6.5, 32, 15),
            Block.box(8, 18, 15.5, 19, 30, 15.5),
            Block.box(-4, 18, 15.5, 7, 30, 15.5),
            Block.box(7.5, 8, 16, 7.5, 20, 27),
            Block.box(6, 4, 9, 9, 7, 21),
            Block.box(6, 7, 14, 9, 19, 17),
            Block.box(6, 8, -4, 9, 19, -1),
            Block.box(-3.6066, -1, 6.98528, 7.3934, 11, 6.98528),
            Block.box(-2.5, 6, -4, -2.5, 18, 7),
            Block.box(-10.80761, 3, 7.48528, 0.19239, 15, 7.48528),
            Block.box(-13, 7, 7.5, -2, 19, 7.5),
            Block.box(-4, 3, 6, -1, 11, 9),
            Block.box(-2, 5, 7.5, 9, 17, 7.5),
            Block.box(-0.82843, 1, 6.98528, 10.17157, 13, 6.98528),
            Block.box(14, 3, -7.5, 25, 15, -7.5),
            Block.box(14, 8, 7.5, 25, 20, 7.5),
            Block.box(11.80761, 4, 7.48528, 22.80761, 16, 7.48528),
            Block.box(14.5, 7, -4, 14.5, 19, 7),
            Block.box(0, 7, -7.5, 11, 19, -7.5),
            Block.box(3, 6, 7.5, 14, 18, 7.5),
            Block.box(1.82843, 2, 6.98528, 12.82843, 14, 6.98528),
            Block.box(13, 5, 6, 16, 12, 9),
            Block.box(-2.5, 9, 7, -2.5, 21, 18),
            Block.box(-10.80761, 3, 7.48528, 0.19239, 15, 7.48528),
            Block.box(-2.5, 6, -4, -2.5, 18, 7),
            Block.box(1, 6, -7.5, 12, 18, -7.5),
            Block.box(-2, 5, 7.5, 9, 17, 7.5),
            Block.box(-0.82843, 1, 6.98528, 10.17157, 13, 6.98528),
            Block.box(-2.5, 9, 7, -2.5, 21, 18),
            Block.box(-13, 7, 7.5, -2, 19, 7.5),
            Block.box(-4, 4, 6, -1, 11, 9),
            Block.box(2, -7, 2, 13, -5, 13),
            Block.box(2.5, -8, 2.5, 12.5, -7, 12.5),
            Block.box(3, -14, 3, 12, -8, 12),
            Block.box(3, -16, 3, 12, -15, 12),
            Block.box(4, -15, 4, 11, -14, 11)
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
        return new DungeonHangFlagEntity();
    }

    @Override
    protected Map<Direction, VoxelShape> getShapes() {
        return SHAPES;
    }

    protected boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{ pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
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
                positions = new BlockPos[]{ pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
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
                positions = new BlockPos[]{ pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.UP),
                        pos.relative(Direction.UP).above().relative(Direction.WEST),
                        pos.relative(Direction.UP).above().relative(Direction.EAST),
                        pos.relative(Direction.UP).above(),
                        pos.relative(Direction.UP).above().relative(Direction.NORTH),
                        pos.relative(Direction.UP).above().relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST),
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
