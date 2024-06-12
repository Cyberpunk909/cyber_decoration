package com.cyber.punk.just_block.vanilla_block;

import com.cyber.punk.util.BlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class CutExposedCopperVerticalSlab extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public CutExposedCopperVerticalSlab() {
        super (Properties.of(Material.METAL)
                .strength(3.5f,4.0f));
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0, 0, 8, 16, 16, 16)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_E;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(8, 0, 0, 16, 16, 16)
        );
        SHAPE_E = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_S;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0, 0, 8, 16, 16, 16)
        );
        SHAPE_S = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    private static final VoxelShape SHAPE_W;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0, 0, 0, 8, 16, 16)
        );
        SHAPE_W = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
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
}
