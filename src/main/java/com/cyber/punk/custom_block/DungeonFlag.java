package com.cyber.punk.custom_block;

import com.cyber.punk.AbstractCustomBlock;
import com.cyber.punk.Registry;
import com.cyber.punk.custom_block.entity.DungeonFlagEntity;
import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Map;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DungeonFlag extends AbstractCustomBlock {
    private static final Logger LOGGER = LogManager.getLogger();

    public DungeonFlag() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD)
                .strength(1f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(2, 30, 13.5, 13.5, 32, 15.5),
            Block.box(13.5, 28.5, 12.5, 15.5, 32, 16),
            Block.box(13.5, 25, 15.5, 15.5, 28.5, 16),
            Block.box(14.25, 26.5, 14.2, 14.75, 30.5, 14.7),
            Block.box(0, 25, 15.5, 2, 28.5, 16),
            Block.box(0.75, 26.5, 14.2, 1.25, 30.5, 14.7),
            Block.box(2, 0, 13.4, 13.5, 32, 13.5),
            Block.box(0, 28.5, 12.5, 2, 32, 16)
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
        return new DungeonFlagEntity();
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
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case SOUTH:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case WEST:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case EAST:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
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
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case SOUTH:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case WEST:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
            case EAST:
                positions = new BlockPos[]{
                        pos.relative(Direction.UP),
                        pos.relative(Direction.UP, 2)
                };
                break;
        }

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
    protected void removeBoundingBlocks(World world, BlockPos pos, BlockState blockState) {
        BlockPos[] positions = new BlockPos[]{
                pos.relative(Direction.UP),
                pos.relative(Direction.UP, 2)
        };

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
                LOGGER.info("Bounding block removed at {}", blockPos);
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        TileEntity te = world.getBlockEntity(pos);
        if (te instanceof BoundingBlockEntity) {
            BoundingBlockEntity boundingBlockEntity = (BoundingBlockEntity) te;
            VoxelShape shape = boundingBlockEntity.getCustomShape();
            if (shape != null) {
                return shape;
            }
        }
        return getShapes().get(state.getValue(FACING));
    }
}
