package com.cyber.punk.block;

import com.cyber.punk.AbstractCustomBlock;
import com.cyber.punk.Registry;
import com.cyber.punk.block.entity.DungeonHangFlagEntity;
import com.cyber.punk.boundingBlock.BoundingBlock;
import com.cyber.punk.boundingBlock.BoundingBlockEntity;
import com.cyber.punk.boundingBlock.VoxelUtil;
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
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.stream.Stream;

public class DungeonHangFlag extends AbstractCustomBlock {
    private static final Logger LOGGER = LogManager.getLogger();

    public DungeonHangFlag() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD)
                .strength(5.0F)
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
            Block.box(26, 16, 13, 28, 18, 14),
            Block.box(9, 19.1, 5, 22, 19.1, 13),
            Block.box(22, 19, 5, 22, 23, 13),
            Block.box(9, 23, 5, 22, 23, 13),
            Block.box(9, 19.1, 5, 22, 23.1, 5),
            Block.box(9, 19, 5, 9, 23, 13),
            Block.box(-2, 19, 10, 9, 21, 12),
            Block.box(-1.4290964938346509, 19, 4.75, 9.57090350616535, 21, 6.75),
            Block.box(19, 8, 2.75, 21, 21, 4.75),
            Block.box(19, 8, 13.25, 21, 21, 15.25),
            Block.box(9, 19, 13, 22, 23, 13),
            Block.box(-12, -10, 4.9, 28, 18, 4.9),
            Block.box(23.547439384910767, 20, 5, 29.547439384910767, 28, 13),
            Block.box(26.44128063653593, 25.13615736928115, 4.5, 27.44128063653593, 27.63615736928115, 5),
            Block.box(26.564215554377363, 21.018229889461743, 4.5, 27.564215554377363, 23.518229889461743, 5),
            Block.box(21.8709513717378, 20.64877126526723, 8, 23.8709513717378, 26.64877126526723, 13),
            Block.box(21.8709513717378, 20.64877126526723, 6, 22.8709513717378, 26.64877126526723, 8)
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
        return new DungeonHangFlagEntity();
    }

    @Override
    protected Map<Direction, VoxelShape> getShapes() {
        return SHAPES;
    }

    @Override
    public void setPlacedBy(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        BlockPos newPos = pos.above(); // Смещение размещения на 1 блок вверх

        if (!world.isClientSide && canPlaceBlockAt(world, newPos, state.getValue(FACING))) {
            BlockState newState = state.setValue(FACING, state.getValue(FACING));
            LOGGER.info("Placing block at new position: {}", newPos);
            world.setBlock(newPos, newState, 3);
            TileEntity te = world.getBlockEntity(newPos);
            if (te instanceof DungeonHangFlagEntity) {
                ((DungeonHangFlagEntity) te).setMainPosition(newPos);
                LOGGER.info("TileEntity set at new position: {}", newPos);
            }
            world.removeBlock(pos, false); // Удалить старый блок
            placeBoundingBlocks(world, newPos, state.getValue(FACING)); // Размещение bounding блоков
            super.setPlacedBy(world, newPos, newState, placer, stack);
        } else {
            LOGGER.info("Cannot place block at new position: {}", newPos);
        }
    }

    /*@Override
    protected boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions = new BlockPos[]{
                pos.above(),
                pos.above(2),
                pos.above(3),
                pos.above(2).north(),
                pos.above(2).south(),
                pos.above(2).east(),
                pos.above(2).west(),
                pos.above(3).north(),
                pos.above(3).south(),
                pos.above(3).east(),
                pos.above(3).west(),
        };

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (!state.isAir() && !state.getMaterial().isReplaceable()) {
                LOGGER.info("Cannot place block at {} due to {}", blockPos, state);
                return false;
            }
        }
        return true;
    }
     */

    @Override
    protected void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos basePos = pos.above(); // Смещение размещения на 1 блок вверх
        BlockPos[] positions = new BlockPos[]{
                basePos,
                basePos.above(),
                basePos.above(2),
                basePos.above().north(),
                basePos.above().south(),
                basePos.above().east(),
                basePos.above().west(),
                basePos.above(2).north(),
                basePos.above(2).south(),
                basePos.above(2).east(),
                basePos.above(2).west(),
                basePos.above(3),
                basePos.above(3).north(),
                basePos.above(3).south(),
                basePos.above(3).east(),
                basePos.above(3).west()
        };

        VoxelShape shape = getShapes().get(facing);
        LOGGER.info("Placing bounding blocks for {} facing {}", basePos, facing);

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (state.isAir() || state.getMaterial().isReplaceable()) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(basePos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(
                            -blockPos.getX() + basePos.getX(),
                            -blockPos.getY() + basePos.getY(),
                            -blockPos.getZ() + basePos.getZ()
                    ));
                    LOGGER.info("Bounding block placed at {}", blockPos);
                }
            }
        }
    }

    @Override
    protected void removeBoundingBlocks(World world, BlockPos pos) {
        BlockPos basePos = pos.above(); // Смещение размещения на 1 блок вверх
        BlockPos[] positions = new BlockPos[]{
                basePos,
                basePos.above(),
                basePos.above(2),
                basePos.above().north(),
                basePos.above().south(),
                basePos.above().east(),
                basePos.above().west(),
                basePos.above(2).north(),
                basePos.above(2).south(),
                basePos.above(2).east(),
                basePos.above(2).west(),
                basePos.above(3),
                basePos.above(3).north(),
                basePos.above(3).south(),
                basePos.above(3).east(),
                basePos.above(3).west()
        };

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
                LOGGER.info("Bounding block removed at {}", blockPos);
            }
        }
    }
}
