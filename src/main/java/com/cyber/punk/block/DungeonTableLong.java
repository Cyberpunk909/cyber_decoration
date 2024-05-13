package com.cyber.punk.block;

import com.cyber.punk.BlockUtils;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.stream.Stream;

public class DungeonTableLong extends BlockUtils {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;


    private static final VoxelShape SHAPE_N;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-14.5, 13, -2, 31.5, 16, 2),
                Block.box(-14.5, 13, 6, 31.5, 16, 10),
                Block.box(-15.5, 13, 10, 30.5, 16, 14),
                Block.box(-15.5, 13, 2, 30.5, 16, 6),
                Block.box(-14.5, 13, 14, 31.5, 16, 18),
                Block.box(26.5, 2, 3, 29.5, 4, 13),
                Block.box(-13.5, 2, 3, -10.5, 4, 13),
                Block.box(-10.5, 2, 6, 26.5, 4, 10),
                Block.box(26.5, 6, 0, 29.5, 10, 3),
                Block.box(25.5, 0, -1, 30.5, 3, 4),
                Block.box(26, 3, -0.5, 30, 6, 3.5),
                Block.box(26.5, 6, 13, 29.5, 10, 16),
                Block.box(26, 3, 12.5, 30, 6, 16.5),
                Block.box(25.5, 0, 12, 30.5, 3, 17),
                Block.box(26, 10, -2.5, 30, 13, 18.5),
                Block.box(-13, 6, 13, -10, 10, 16),
                Block.box(-13.5, 3, 12.5, -9.5, 6, 16.5),
                Block.box(-14, 0, 12, -9, 3, 17),
                Block.box(-13.5, 10, -2.5, -9.5, 13, 18.5),
                Block.box(-14, 0, -1, -9, 3, 4),
                Block.box(-13.5, 3, -0.5, -9.5, 6, 3.5),
                Block.box(-13, 6, 0, -10, 10, 3)
        );
        SHAPE_N = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_E;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(14, 13, -14.5, 18, 16, 31.5),
                Block.box(6, 13, -14.5, 10, 16, 31.5),
                Block.box(2, 13, -15.5, 6, 16, 30.5),
                Block.box(10, 13, -15.5, 14, 16, 30.5),
                Block.box(-2, 13, -14.5, 2, 16, 31.5),
                Block.box(3, 2, 26.5, 13, 4, 29.5),
                Block.box(3, 2, -13.5, 13, 4, -10.5),
                Block.box(6, 2, -10.5, 10, 4, 26.5),
                Block.box(13, 6, 26.5, 16, 10, 29.5),
                Block.box(12, 0, 25.5, 17, 3, 30.5),
                Block.box(12.5, 3, 26, 16.5, 6, 30),
                Block.box(0, 6, 26.5, 3, 10, 29.5),
                Block.box(-0.5, 3, 26, 3.5, 6, 30),
                Block.box(-1, 0, 25.5, 4, 3, 30.5),
                Block.box(-2.5, 10, 26, 18.5, 13, 30),
                Block.box(0, 6, -13, 3, 10, -10),
                Block.box(-0.5, 3, -13.5, 3.5, 6, -9.5),
                Block.box(-1, 0, -14, 4, 3, -9),
                Block.box(-2.5, 10, -13.5, 18.5, 13, -9.5),
                Block.box(12, 0, -14, 17, 3, -9),
                Block.box(12.5, 3, -13.5, 16.5, 6, -9.5),
                Block.box(13, 6, -13, 16, 10, -10)
        );
        SHAPE_E = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    private static final VoxelShape SHAPE_S;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-15.5, 13, 14, 30.5, 16, 18),
                Block.box(-15.5, 13, 6, 30.5, 16, 10),
                Block.box(-14.5, 13, 2, 31.5, 16, 6),
                Block.box(-14.5, 13, 10, 31.5, 16, 14),
                Block.box(-15.5, 13, -2, 30.5, 16, 2),
                Block.box(-13.5, 2, 3, -10.5, 4, 13),
                Block.box(26.5, 2, 3, 29.5, 4, 13),
                Block.box(-10.5, 2, 6, 26.5, 4, 10),
                Block.box(-13.5, 6, 13, -10.5, 10, 16),
                Block.box(-14.5, 0, 12, -9.5, 3, 17),
                Block.box(-14, 3, 12.5, -10, 6, 16.5),
                Block.box(-13.5, 6, 0, -10.5, 10, 3),
                Block.box(-14, 3, -0.5, -10, 6, 3.5),
                Block.box(-14.5, 0, -1, -9.5, 3, 4),
                Block.box(-14, 10, -2.5, -10, 13, 18.5),
                Block.box(26, 6, 0, 29, 10, 3),
                Block.box(25.5, 3, -0.5, 29.5, 6, 3.5),
                Block.box(25, 0, -1, 30, 3, 4),
                Block.box(25.5, 10, -2.5, 29.5, 13, 18.5),
                Block.box(25, 0, 12, 30, 3, 17),
                Block.box(25.5, 3, 12.5, 29.5, 6, 16.5),
                Block.box(26, 6, 13, 29, 10, 16)
        );
        SHAPE_S = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    private static final VoxelShape SHAPE_W;

    static {
        Stream<VoxelShape> shapeStream = Stream.of(
                Block.box(-2, 13, -15.5, 2, 16, 30.5),
                Block.box(6, 13, -15.5, 10, 16, 30.5),
                Block.box(10, 13, -14.5, 14, 16, 31.5),
                Block.box(2, 13, -14.5, 6, 16, 31.5),
                Block.box(14, 13, -15.5, 18, 16, 30.5),
                Block.box(3, 2, -13.5, 13, 4, -10.5),
                Block.box(3, 2, 26.5, 13, 4, 29.5),
                Block.box(6, 2, -10.5, 10, 4, 26.5),
                Block.box(0, 6, -13.5, 3, 10, -10.5),
                Block.box(-1, 0, -14.5, 4, 3, -9.5),
                Block.box(-0.5, 3, -14, 3.5, 6, -10),
                Block.box(13, 6, -13.5, 16, 10, -10.5),
                Block.box(12.5, 3, -14, 16.5, 6, -10),
                Block.box(12, 0, -14.5, 17, 3, -9.5),
                Block.box(-2.5, 10, -14, 18.5, 13, -10),
                Block.box(13, 6, 26, 16, 10, 29),
                Block.box(12.5, 3, 25.5, 16.5, 6, 29.5),
                Block.box(12, 0, 25, 17, 3, 30),
                Block.box(-2.5, 10, 25.5, 18.5, 13, 29.5),
                Block.box(-1, 0, 25, 4, 3, 30),
                Block.box(-0.5, 3, 25.5, 3.5, 6, 29.5),
                Block.box(0, 6, 26, 3, 10, 29)
        );
        SHAPE_W = shapeStream.reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }
    public void onPlace() {
        // Оставьте этот метод пустым, если он не должен выполнять никаких действий при размещении блока.

    }


    public DungeonTableLong() {
        super(AbstractBlock.Properties.of(Material.WOOD)
                .strength(3.5f, 4.0f)
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
}
