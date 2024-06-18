package com.cyber.punk.just_block.hospital;

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

public class HospitalStool extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public HospitalStool() {
        super(Properties.of(Material.METAL)
                .strength(1f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(2, 6, 2, 14, 9, 14),
                Block.box(7, 3, 7, 9, 6, 9),
                Block.box(9.03818, 4.80304, 7.25, 9.03818, 6.80304, 8.25),
                Block.box(7, 2, 2, 9, 3, 14),
                Block.box(7.5, 0, 2.5, 8.5, 2, 4.5),
                Block.box(7.5, 0, 11.5, 8.5, 2, 13.5),
                Block.box(2.5, 0, 7.5, 4.5, 2, 8.5),
                Block.box(2, 2, 7, 14, 3, 9),
                Block.box(11.5, 0, 7.5, 13.5, 2, 8.5)
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