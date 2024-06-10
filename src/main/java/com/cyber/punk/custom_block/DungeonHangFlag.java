package com.cyber.punk.custom_block;

import com.cyber.punk.AbstractCustomBlock;
import com.cyber.punk.Registry;
import com.cyber.punk.entity.DungeonHangFlagEntity;
import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.stream.Stream;

public class DungeonHangFlag extends AbstractCustomBlock {
    private static final Logger LOGGER = LogManager.getLogger();

    public DungeonHangFlag() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD)
                .strength(1f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(26, 16, 4, 28, 18, 5),
            Block.box(24, 12, 4.5, 30, 18, 4.5),
            Block.box(24, 1, 13.5, 30, 7, 13.5),
            Block.box(25, 7, 13.5, 29, 16, 13.5),
            Block.box(-14, 12, 4.5, -8, 18, 4.5),
            Block.box(-14, 12, 13.5, -8, 18, 13.5),
            Block.box(-7, 14, 6, 23, 19, 12),
            Block.box(-15, 13, 5, -7, 20, 13),
            Block.box(-14, -10, 6, -8, 13, 12),
            Block.box(-15, -16, 5, -7, -10, 13),
            Block.box(23, 13, 5, 31, 20, 13),
            Block.box(24, -10, 6, 30, 13, 12),
            Block.box(23, -16, 5, 31, -10, 13),
            Block.box(-12, 16, 4, -10, 18, 5),
            Block.box(-12, 16, 13, -10, 18, 14),
            Block.box(21.87095, 20.64877, 6, 22.87095, 26.64877, 8),
            Block.box(21.87095, 20.64877, 8, 23.87095, 26.64877, 13),
            Block.box(26.56422, 21.01823, 4.5, 27.56422, 23.51823, 5),
            Block.box(9, 19.1, 5, 22, 19.1, 13),
            Block.box(9, 19, 13, 22, 23, 13),
            Block.box(22, 19, 5, 22, 23, 13),
            Block.box(9, 23, 5, 22, 23, 13),
            Block.box(9, 19.1, 5, 22, 23.1, 5),
            Block.box(9, 19, 5, 9, 23, 13),
            Block.box(26.44128, 25.13616, 4.5, 27.44128, 27.63616, 5),
            Block.box(23.54744, 20, 5, 29.54744, 28, 13),
            Block.box(19, 8, 2.75, 21, 21, 4.75),
            Block.box(-2, 19, 10, 9, 21, 12),
            Block.box(-1.4291, 19, 4.75, 9.5709, 21, 6.75),
            Block.box(19, 8, 13.25, 21, 21, 15.25),
            Block.box(26, 16, 13, 28, 18, 14),
            Block.box(-12, -10, 4.9, 28, 18, 5)
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

    @Override
    public void setPlacedBy(World p_180633_1_, BlockPos p_180633_2_, BlockState p_180633_3_, @Nullable LivingEntity p_180633_4_, ItemStack p_180633_5_) {
        placeBoundingBlocks(p_180633_1_, p_180633_2_, p_180633_3_.getValue(FACING));
    }

    /*
    @Override
    protected boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions = getBoundingBlockPositions(pos, facing);

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (!state.isAir() && !state.getMaterial().isReplaceable() && state.getMaterial() != Material.WATER) {
                LOGGER.info("Cannot place block at {} due to {}", blockPos, state);
                return false;
            }
        }
        return true;
    }
     */

    private BlockPos[] getBoundingBlockPositions(BlockPos origin, Direction facing){
        Direction direction = facing.getClockWise();
        return new BlockPos[]{
            origin.above(), origin.above(2),
            origin.relative(direction, -1), origin.relative(direction, 1),
            origin.relative(direction, -1).above(), origin.relative(direction, 1).above(),
            origin.relative(direction, -1).above(2), origin.relative(direction, 1).above(2)
        };
    }

    @Override
    protected void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions = getBoundingBlockPositions(pos, facing);

        VoxelShape shape = getShapes().get(facing);
        LOGGER.info("Placing bounding blocks for {} facing {}", pos, facing);

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (state.isAir() || state.getMaterial().isReplaceable()) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(pos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(
                        -blockPos.getX() + pos.getX(),
                        -blockPos.getY() + pos.getY(),
                        -blockPos.getZ() + pos.getZ()
                    ));
                    LOGGER.info("Bounding block placed at {}", blockPos);
                }
            }
        }
    }

    @Override
    protected void removeBoundingBlocks(World world, BlockPos pos, BlockState blockState, Direction facing) {
        for (BlockPos blockPos : getBoundingBlockPositions(pos, blockState.getValue(FACING))) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
                LOGGER.info("Bounding block removed at {}", blockPos);
            }
        }
    }
}
