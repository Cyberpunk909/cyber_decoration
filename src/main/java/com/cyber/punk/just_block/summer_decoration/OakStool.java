package com.cyber.punk.just_block.summer_decoration;

import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.util.BlockUtils;
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

public class OakStool extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public OakStool() {
        super(Properties.of(Material.WOOD)
                .strength(1f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(0, 9.56497, 10.75, 16, 11.56497, 15.75),
                Block.box(0, 9.56497, 5.25, 16, 11.56497, 10.25),
                Block.box(0, 9.56497, -0.25, 16, 11.56497, 4.75),
                Block.box(1, 7.5, 3, 4, 9.5, 13),
                Block.box(1.01, 0, 12.93503, 4.01, 9.5, 14.93503),
                Block.box(1.01, 0, 1, 4.01, 9.5, 3),
                Block.box(12.01, 0, 1, 15.01, 9.5, 3),
                Block.box(12.01, 0, 12.93503, 15.01, 9.5, 14.93503),
                Block.box(12, 7.5, 3, 15, 9.5, 13)
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