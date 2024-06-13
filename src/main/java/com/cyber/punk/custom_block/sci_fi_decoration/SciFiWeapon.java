package com.cyber.punk.custom_block.sci_fi_decoration;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.dungeon_decoration.DungeonSkeletonSleepEntity;
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

public class SciFiWeapon extends AbstractCustomBlock {
    public SciFiWeapon() {
        super(Properties.of(
                        Material.STONE)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(3.5, 14, 12.5, 12.5, 16, 14.5),
            Block.box(2.5, 13, 11.5, 3.5, 17, 15.5),
            Block.box(0.5, 14, 12.5, 2.5, 16, 14.5),
            Block.box(-6.5, 14.25, 12.75, 0.5, 15.75, 14.25),
            Block.box(12.5, 13, 11.5, 13.5, 17, 15.5),
            Block.box(13.5, 14, 12.5, 15.5, 16, 14.5),
            Block.box(15.5, 14.25, 12.75, 22.5, 15.75, 14.25),
            Block.box(-6, 4, 13.5, 10, 5, 14.5),
            Block.box(10, 3.5, 13.5, 12, 5.5, 14.5),
            Block.box(12, 3.5, 13, 19, 5.5, 15),
            Block.box(5, 12, 15, 11, 14, 16),
            Block.box(5, 2, 15, 11, 4, 16),
            Block.box(3.5, 10, 13, 4.5, 14, 15),
            Block.box(3.5, 13.90165, 11.7448, 4.5, 15.90165, 12.7448),
            Block.box(3.51, 12.25, 14.5, 4.49, 15.25, 15.5),
            Block.box(11.5, 10, 13, 12.5, 14, 15),
            Block.box(11.51, 12.25, 14.5, 12.49, 15.25, 15.5),
            Block.box(11.5, 13.90165, 11.7448, 12.5, 15.90165, 12.7448),
            Block.box(3.5, 0, 13, 4.5, 4, 15),
            Block.box(3.5, 3.90165, 11.7448, 4.5, 5.90165, 12.7448),
            Block.box(3.51, 2.25, 14.5, 4.49, 5.25, 15.5),
            Block.box(11.5, 0, 13, 12.5, 4, 15),
            Block.box(11.51, 2.25, 14.5, 12.49, 5.25, 15.5),
            Block.box(11.5, 3.90165, 11.7448, 12.5, 5.90165, 12.7448),
            Block.box(3, 0, 15, 5, 16, 16),
            Block.box(11, 0, 15, 13, 16, 16)
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
        return new DungeonSkeletonSleepEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH), pos.relative(Direction.UP),
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH), pos.relative(Direction.UP),
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH), pos.relative(Direction.UP),
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
