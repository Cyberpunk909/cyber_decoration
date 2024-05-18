package com.cyber.punk.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class DungeonWoodChairWithRest extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(1, 6, -1, 15, 10, 13),
                Block.box(1, 0, 1, 15, 6, 13),
                Block.box(2, 0, 13, 14, 32, 16),
                Block.box(15, 0, 0, 18, 12, 13),
                Block.box(14, 12, -2, 19, 16, 13),
                Block.box(14, 0, 13, 18, 30, 16),
                Block.box(-2, 0, 0, 1, 12, 13),
                Block.box(-3, 12, -2, 2, 16, 13),
                Block.box(-2, 0, 13, 2, 30, 16)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_E;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(3, 6, 1, 17, 10, 15),
                Block.box(3, 0, 1, 15, 6, 15),
                Block.box(0, 0, 2, 3, 32, 14),
                Block.box(3, 0, 15, 16, 12, 18),
                Block.box(3, 12, 14, 18, 16, 19),
                Block.box(0, 0, 14, 3, 30, 18),
                Block.box(3, 0, -2, 16, 12, 1),
                Block.box(3, 12, -3, 18, 16, 2),
                Block.box(0, 0, -2, 3, 30, 2)
        );
        SHAPE_E = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_S;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(1, 6, 3, 15, 10, 17),
                Block.box(1, 0, 3, 15, 6, 15),
                Block.box(2, 0, 0, 14, 32, 3),
                Block.box(-2, 0, 3, 1, 12, 16),
                Block.box(-3, 12, 3, 2, 16, 18),
                Block.box(-2, 0, 0, 2, 30, 3),
                Block.box(15, 0, 3, 18, 12, 16),
                Block.box(14, 12, 3, 19, 16, 18),
                Block.box(14, 0, 0, 18, 30, 3)
        );
        SHAPE_S = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    private static final VoxelShape SHAPE_W;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-1, 6, 1, 13, 10, 15),
                Block.box(1, 0, 1, 13, 6, 15),
                Block.box(13, 0, 2, 16, 32, 14),
                Block.box(0, 0, -2, 13, 12, 1),
                Block.box(-2, 12, -3, 13, 16, 2),
                Block.box(13, 0, -2, 16, 30, 2),
                Block.box(0, 0, 15, 13, 12, 18),
                Block.box(-2, 12, 14, 13, 16, 19),
                Block.box(13, 0, 14, 16, 30, 18)
        );
        SHAPE_W = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    public DungeonWoodChairWithRest() {
        super (AbstractBlock.Properties.of(Material.WOOD)
                .strength(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.AXE)
                .requiresCorrectToolForDrops());
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction facing = state.getValue(FACING);
        switch (facing) {
            case NORTH:
                return SHAPE_N;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        Direction facing = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState().setValue(FACING, facing);
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        Direction facing = state.getValue(FACING);
        Direction rotatedFacing = rotation.rotate(facing);
        return state.setValue(FACING, rotatedFacing);
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        Direction facing = state.getValue(FACING);
        Direction mirroredFacing = mirrorIn.mirror(facing);
        return state.setValue(FACING, mirroredFacing);
    }
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

}
