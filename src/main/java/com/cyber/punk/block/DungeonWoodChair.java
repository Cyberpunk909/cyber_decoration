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

public class DungeonWoodChair extends Block {

        public static final DirectionProperty FACING = HorizontalBlock.FACING;

    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0, 7, 6, 14, 10, 10),
                Block.box(1, 7, 2, 15, 10, 6),
                Block.box(1, 7, 10, 15, 10, 14),
                Block.box(11, 3, 3, 14, 7, 6),
                 Block.box(10.5, 0, 2.5, 14.5, 3, 6.5),
                Block.box(1.5, 0, 2.5, 5.5, 3, 6.5),
                Block.box(2, 3, 3, 5, 7, 6),
                Block.box(10.5, 0, 9.5, 14.5, 3, 13.5),
                Block.box(11, 3, 10, 14, 7, 13),
                Block.box(1.5, 0, 9.5, 5.5, 3, 13.5),
                Block.box(2, 3, 10, 5, 7, 13),
                Block.box(11.5, 1, 6.5, 13.5, 3, 9.5),
                Block.box(2.5, 1, 6.5, 4.5, 3, 9.5),
                Block.box(4.5, 1, 7.5, 11.5, 3, 8.5)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_E;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(6, 7, 0, 10, 10, 14),
                Block.box(10, 7, 1, 14, 10, 15),
                Block.box(2, 7, 1, 6, 10, 15),
                Block.box(10, 3, 11, 13, 7, 14),
                Block.box(9.5, 0, 10.5, 13.5, 3, 14.5),
                Block.box(9.5, 0, 1.5, 13.5, 3, 5.5),
                Block.box(10, 3, 2, 13, 7, 5),
                Block.box(2.5, 0, 10.5, 6.5, 3, 14.5),
                Block.box(3, 3, 11, 6, 7, 14),
                Block.box(2.5, 0, 1.5, 6.5, 3, 5.5),
                Block.box(3, 3, 2, 6, 7, 5),
                Block.box(6.5, 1, 11.5, 9.5, 3, 13.5),
                Block.box(6.5, 1, 2.5, 9.5, 3, 4.5),
                Block.box(7.5, 1, 4.5, 8.5, 3, 11.5)
        );
        SHAPE_E = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_S;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(2, 7, 6, 16, 10, 10),
                Block.box(1, 7, 10, 15, 10, 14),
                Block.box(1, 7, 2, 15, 10, 6),
                Block.box(2, 3, 10, 5, 7, 13),
                Block.box(1.5, 0, 9.5, 5.5, 3, 13.5),
                Block.box(10.5, 0, 9.5, 14.5, 3, 13.5),
                Block.box(11, 3, 10, 14, 7, 13),
                Block.box(1.5, 0, 2.5, 5.5, 3, 6.5),
                Block.box(2, 3, 3, 5, 7, 6),
                Block.box(10.5, 0, 2.5, 14.5, 3, 6.5),
                Block.box(11, 3, 3, 14, 7, 6),
                Block.box(2.5, 1, 6.5, 4.5, 3, 9.5),
                Block.box(11.5, 1, 6.5, 13.5, 3, 9.5),
                Block.box(4.5, 1, 7.5, 11.5, 3, 8.5)
        );
        SHAPE_S = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    private static final VoxelShape SHAPE_W;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(6, 7, 2, 10, 10, 16),
                Block.box(2, 7, 1, 6, 10, 15),
                Block.box(10, 7, 1, 14, 10, 15),
                Block.box(3, 3, 2, 6, 7, 5),
                Block.box(2.5, 0, 1.5, 6.5, 3, 5.5),
                Block.box(2.5, 0, 10.5, 6.5, 3, 14.5),
                Block.box(3, 3, 11, 6, 7, 14),
                Block.box(9.5, 0, 1.5, 13.5, 3, 5.5),
                Block.box(10, 3, 2, 13, 7, 5),
                Block.box(9.5, 0, 10.5, 13.5, 3, 14.5),
                Block.box(10, 3, 11, 13, 7, 14),
                Block.box(6.5, 1, 2.5, 9.5, 3, 4.5),
                Block.box(6.5, 1, 11.5, 9.5, 3, 13.5),
                Block.box(7.5, 1, 4.5, 8.5, 3, 11.5)
        );
        SHAPE_W = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    public DungeonWoodChair() {
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