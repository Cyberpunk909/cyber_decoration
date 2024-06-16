package com.cyber.punk.just_block.sci_fi_decoration;

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

public class SciFiCrate extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public SciFiCrate() {
        super(Properties.of(Material.METAL)
                .strength(2f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(1, 1, 1, 15, 15, 15),
                Block.box(0, 12, 0, 4, 16, 4),
                Block.box(4, 13.5, 0.5, 12, 15.5, 2.5),
                Block.box(12, 12, 0, 16, 16, 4),
                Block.box(13.5, 4, 0.5, 15.5, 12, 2.5),
                Block.box(12, 0, 0, 16, 4, 4),
                Block.box(4, 0.5, 0.5, 12, 2.5, 2.5),
                Block.box(0, 0, 0, 4, 4, 4),
                Block.box(0.5, 4, 0.5, 2.5, 12, 2.5),
                Block.box(0, 12, 12, 4, 16, 16),
                Block.box(4, 13.5, 13.5, 12, 15.5, 15.5),
                Block.box(12, 12, 12, 16, 16, 16),
                Block.box(13.5, 4, 13.5, 15.5, 12, 15.5),
                Block.box(12, 0, 12, 16, 4, 16),
                Block.box(4, 0.5, 13.5, 12, 2.5, 15.5),
                Block.box(13.5, 13.5, 4, 15.5, 15.5, 12),
                Block.box(13.5, 0.5, 4, 15.5, 2.5, 12),
                Block.box(0.5, 13.5, 4, 2.5, 15.5, 12),
                Block.box(0.5, 0.5, 4, 2.5, 2.5, 12),
                Block.box(0, 0, 12, 4, 4, 16),
                Block.box(0.5, 4, 13.5, 2.5, 12, 15.5)
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