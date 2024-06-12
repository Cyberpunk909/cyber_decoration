package com.cyber.punk.custom_block.summer_decoration;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.summer_decoration.OakDeadTreeEntity;
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

public class OakDeadTree extends AbstractCustomBlock {

    public OakDeadTree() {
        super(Properties.of(
                        Material.WOOD)
                .strength(1f,4.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(6, -13, 6, 9, -3, 9),
            Block.box(6, -3, 6, 9, 13, 9),
            Block.box(1, 0, 6, 6, 3, 9),
            Block.box(9, -1, 6, 16, 2, 9),
            Block.box(6, 5, 9, 9, 8, 16),
            Block.box(6, 1, -1, 9, 4, 6),
            Block.box(1, 3, 6, 4, 11, 9),
            Block.box(-7, 3, 7.5, 3, 13, 7.5),
            Block.box(13, 4, 7.5, 23, 14, 7.5),
            Block.box(9, 10, 12.5, 19, 20, 12.5),
            Block.box(9, 4, 13, 19, 14, 13),
            Block.box(9, 7, 2.5, 19, 17, 2.5),
            Block.box(7.5, 7, -7, 7.5, 17, 3),
            Block.box(13.5, 6, -4, 13.5, 16, 6),
            Block.box(13.5, -1, 8, 13.5, 9, 18),
            Block.box(7.5, 9, 13, 7.5, 19, 23),
            Block.box(7.5, 13, 2, 7.5, 23, 12),
            Block.box(2.5, 1, 8, 2.5, 11, 18),
            Block.box(2.5, 0, -3, 2.5, 10, 7),
            Block.box(-4, 7, 1.5, 6, 17, 1.5),
            Block.box(-4, 7, 12.5, 6, 17, 12.5),
            Block.box(6, 8, 11, 9, 16, 14),
            Block.box(6, 4, 1, 9, 12, 4),
            Block.box(12, 2, 6, 15, 10, 9),
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
        return new OakDeadTreeEntity();
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
