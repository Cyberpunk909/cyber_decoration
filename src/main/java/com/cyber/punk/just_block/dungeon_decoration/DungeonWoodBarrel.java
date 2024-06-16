package com.cyber.punk.just_block.dungeon_decoration;

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

public class DungeonWoodBarrel extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public DungeonWoodBarrel() {
        super(Properties.of(Material.WOOD)
                .strength(2f, 3.0f)
                .noOcclusion());
    }
    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(2, 1, 2, 14, 16, 4),
                Block.box(2, 1, 12, 14, 16, 14),
                Block.box(12, 1, 4, 14, 16, 12),
                Block.box(2, 1, 4, 4, 16, 12),
                Block.box(2, 0, 2, 14, 1, 14),
                Block.box(1, 4, 1, 15, 12, 15),
                Block.box(1, 13, 1, 15, 15, 15),
                Block.box(0.5, 12, 0.5, 15.5, 14, 15.5),
                Block.box(1, 1, 1, 15, 3, 15),
                Block.box(0.5, 2, 0.5, 15.5, 4, 15.5)
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