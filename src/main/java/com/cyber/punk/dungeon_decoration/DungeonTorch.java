package com.cyber.punk.dungeon_decoration;

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

public class DungeonTorch extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public DungeonTorch() {
        super(Properties.of(Material.STONE)
                .strength(2f, 3.0f)
                .lightLevel((state) -> 8)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(4, 2.5, 9, 12, 13.5, 16)
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