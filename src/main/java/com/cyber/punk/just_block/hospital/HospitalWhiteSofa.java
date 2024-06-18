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

public class HospitalWhiteSofa extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public HospitalWhiteSofa() {
        super(Properties.of(Material.WOOD)
                .strength(1f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(2.4069999999999983, 0, 3.2110000000000003, 13.592999999999998, 6.3919999999999995, 15.995),
                Block.box(2.4069999999999983, 6.3919999999999995, 12.799, 13.592999999999998, 15.180999999999997, 15.995),
                Block.box(13.592999999999998, 0, 3.2110000000000003, 15.989999999999998, 11.186, 15.995),
                Block.box(0.009999999999999787, 0, 3.2110000000000003, 2.4069999999999983, 11.186, 15.995)
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