package com.cyber.punk.custom_block.sci_fi_decoration;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.sci_fi_decoration.SciFiHorizontalWireEntity;
import com.cyber.punk.entity.sci_fi_decoration.SciFiWarningSignEntity;
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

public class SciFiWarningSign extends AbstractCustomBlock {
    public SciFiWarningSign() {
        super(Properties.of(
                        Material.METAL)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(12, 0, 6, 16, 2, 10),
            Block.box(-16, 0, 6, -12, 2, 10),
            Block.box(-15, 2, 7, -13, 16, 9),
            Block.box(13, 2, 7, 15, 16, 9),
            Block.box(-13, 5, 7, 13, 16, 9),
            Block.box(-11, 10, 6, 11, 13, 7),
            Block.box(-4, 4, 6.5, 4, 10, 7.5),
            Block.box(-1.5, 18, 6.5, 1.5, 20, 9.5),
            Block.box(-2, 16, 6, 2, 18, 10)
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
        return new SciFiWarningSignEntity();
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
                        pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),};
                break;
            case WEST:
                positions = new BlockPos[]{
                        pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{
                        pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
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
                        pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),};
                break;
            case WEST:
                positions = new BlockPos[]{
                        pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{
                        pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
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
                        pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{
                        pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST),};
                break;
            case WEST:
                positions = new BlockPos[]{
                        pos.relative(Direction.SOUTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{
                        pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
