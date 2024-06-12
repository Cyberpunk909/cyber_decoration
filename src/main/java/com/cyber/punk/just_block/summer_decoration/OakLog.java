package com.cyber.punk.just_block.summer_decoration;

import com.cyber.punk.util.BlockUtils;
import com.cyber.punk.bounding_block.VoxelUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class OakLog extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public OakLog() {
        super(Properties.of(Material.WOOD)
                .strength(1f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0.5, 0, 0, 3.5, 3, 16),
                Block.box(4.5, 0, 0, 7.5, 3, 16),
                Block.box(8.5, 0, 0, 11.5, 3, 16),
                Block.box(12.5, 0, 0, 15.5, 3, 16),
                Block.box(2.5, 3, 0, 5.5, 6, 16),
                Block.box(6.5, 3, 0, 9.5, 6, 16),
                Block.box(10.5, 3, 0, 13.5, 6, 16),
                Block.box(4.5, 6, 0, 7.5, 9, 16),
                Block.box(8.5, 6, 0, 11.5, 9, 16),
                Block.box(6.5, 9, 0, 9.5, 12, 16)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();
    }
    private static final VoxelShape SHAPE_E = VoxelUtil.rotateShape(Direction.NORTH, Direction.EAST, SHAPE_N);
    private static final VoxelShape SHAPE_S = VoxelUtil.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE_N);
    private static final VoxelShape SHAPE_W = VoxelUtil.rotateShape(Direction.NORTH, Direction.WEST, SHAPE_N);

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
}