package com.cyber.punk.custom_block;

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

public class DungeonCage extends Block {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-3, -16, -3, 19, -14, 19),
                Block.box(3, 18.1, 3, 13, 20.1, 13),
                Block.box(6, 20, 6, 10, 23, 10),
                Block.box(4, 23, 8, 12, 30, 8),
                Block.box(17, -11, -1, 19, -9, 17),
                Block.box(-1, 18, -1, 17, 18, 17),
                Block.box(-1, -15, -0.9, 17, 18, -0.9),
                Block.box(16.9, -15, -1, 16.9, 18, 17),
                Block.box(-0.9, -15, -1, -0.9, 18, 17),
                Block.box(-1, -15, 16.9, 17, 18, 16.9),
                Block.box(-3, -11, -3, 19, -9, -1),
                Block.box(17, 1, -1, 19, 3, 17),
                Block.box(-3, 1, -3, 19, 3, -1),
                Block.box(17, 13, -1, 19, 15, 17),
                Block.box(-3, 13, -1, -1, 15, 17),
                Block.box(-3, 1, -1, -1, 3, 17),
                Block.box(-3, -11, -1, -1, -9, 17),
                Block.box(-3, 13, -3, 19, 15, -1),
                Block.box(-3, 13, 17, 19, 15, 19),
                Block.box(-3, 1, 17, 19, 3, 19),
                Block.box(-3, -11, 17, 19, -9, 19),
                Block.box(-1, -15, -0.9, 17, 18, -0.9)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_E;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-3, -16, -3, 19, -14, 19),
                Block.box(3, 18.1, 3, 13, 20.1, 13),
                Block.box(6, 20, 6, 10, 23, 10),
                Block.box(8, 23, 4, 8, 30, 12),
                Block.box(-1, -11, 17, 17, -9, 19),
                Block.box(-1, 18, -1, 17, 18, 17),
                Block.box(16.9, -15, -1, 16.9, 18, 17),
                Block.box(-1, -15, 16.9, 17, 18, 16.9),
                Block.box(-1, -15, -0.9000000000000004, 17, 18, -0.9000000000000004),
                Block.box(-0.8999999999999986, -15, -1, -0.8999999999999986, 18, 17),
                Block.box(17, -11, -3, 19, -9, 19),
                Block.box(-1, 1, 17, 17, 3, 19),
                Block.box(17, 1, -3, 19, 3, 19),
                Block.box(-1, 13, 17, 17, 15, 19),
                Block.box(-1, 13, -3, 17, 15, -1),
                Block.box(-1, 1, -3, 17, 3, -1),
                Block.box(-1, -11, -3, 17, -9, -1),
                Block.box(17, 13, -3, 19, 15, 19),
                Block.box(-3, 13, -3, -1, 15, 19),
                Block.box(-3, 1, -3, -1, 3, 19),
                Block.box(-3, -11, -3, -1, -9, 19),
                Block.box(16.9, -15, -1, 16.9, 18, 17)
        );
        SHAPE_E = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_S;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-3, -16, -3, 19, -14, 19),
                Block.box(3, 18.1, 3, 13, 20.1, 13),
                Block.box(6, 20, 6, 10, 23, 10),
                Block.box(4, 23, 8, 12, 30, 8),
                Block.box(-3, -11, -1, -1, -9, 17),
                Block.box(-1, 18, -1, 17, 18, 17),
                Block.box(-1, -15, 16.9, 17, 18, 16.9),
                Block.box(-0.8999999999999986, -15, -1, -0.8999999999999986, 18, 17),
                Block.box(16.9, -15, -1, 16.9, 18, 17),
                Block.box(-1, -15, -0.8999999999999986, 17, 18, -0.8999999999999986),
                Block.box(-3, -11, 17, 19, -9, 19),
                Block.box(-3, 1, -1, -1, 3, 17),
                Block.box(-3, 1, 17, 19, 3, 19),
                Block.box(-3, 13, -1, -1, 15, 17),
                Block.box(17, 13, -1, 19, 15, 17),
                Block.box(17, 1, -1, 19, 3, 17),
                Block.box(17, -11, -1, 19, -9, 17),
                Block.box(-3, 13, 17, 19, 15, 19),
                Block.box(-3, 13, -3, 19, 15, -1),
                Block.box(-3, 1, -3, 19, 3, -1),
                Block.box(-3, -11, -3, 19, -9, -1),
                Block.box(-1, -15, 16.9, 17, 18, 16.9)
        );
        SHAPE_S = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    private static final VoxelShape SHAPE_W;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-3, -16, -3, 19, -14, 19),
                Block.box(3, 18.1, 3, 13, 20.1, 13),
                Block.box(6, 20, 6, 10, 23, 10),
                Block.box(8, 23, 4, 8, 30, 12),
                Block.box(-1, -11, -3, 17, -9, -1),
                Block.box(-1, 18, -1, 17, 18, 17),
                Block.box(-0.8999999999999986, -15, -1, -0.8999999999999986, 18, 17),
                Block.box(-1, -15, -0.8999999999999986, 17, 18, -0.8999999999999986),
                Block.box(-1, -15, 16.9, 17, 18, 16.9),
                Block.box(16.9, -15, -1, 16.9, 18, 17),
                Block.box(-3, -11, -3, -1, -9, 19),
                Block.box(-1, 1, -3, 17, 3, -1),
                Block.box(-3, 1, -3, -1, 3, 19),
                Block.box(-1, 13, -3, 17, 15, -1),
                Block.box(-1, 13, 17, 17, 15, 19),
                Block.box(-1, 1, 17, 17, 3, 19),
                Block.box(-1, -11, 17, 17, -9, 19),
                Block.box(-3, 13, -3, -1, 15, 19),
                Block.box(17, 13, -3, 19, 15, 19),
                Block.box(17, 1, -3, 19, 3, 19),
                Block.box(17, -11, -3, 19, -9, 19),
                Block.box(-0.8999999999999986, -15, -1, -0.8999999999999986, 18, 17)
        );
        SHAPE_W = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    public DungeonCage() {
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
