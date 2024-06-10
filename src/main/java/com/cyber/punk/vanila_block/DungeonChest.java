package com.cyber.punk.vanila_block;

import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.DungeonChestEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Map;
import java.util.stream.Stream;

public class DungeonChest extends ChestBlock {
    public DungeonChest() {
        super(Block.Properties.of(Material.WOOD)
                .strength(1.0F, 3.0F)
                .noOcclusion(), () -> TileEntityType.CHEST);
    }
    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0.5, 0, 1, 15.499999999999998, 2, 15),
            Block.box(13.999999999999996, 7, 2, 16.000000000000007, 9, 14),
            Block.box(-5.551115123125783e-17, 7, 2, 2.000000000000001, 9, 14),
            Block.box(5.551115123125783e-17, 7, 0, 15.999999999999988, 9, 2),
            Block.box(-5.551115123125783e-17, 7, 14, 15.999999999999998, 9, 16),
            Block.box(5.999999999999998, 6, -0.1, 9.999999999999998, 11, 1),
            Block.box(0.5, 9, 1, 15.499999999999998, 14, 15),
            Block.box(1.5000000000000004, 2, 2, 14.499999999999998, 7.1, 14),
            Block.box(13.499999999999998, 2, 1, 15.499999999999998, 7, 3),
            Block.box(13.499999999999998, 2, 13, 15.499999999999998, 7, 15),
            Block.box(0.5, 2, 13, 2.5000000000000004, 7, 15),
            Block.box(0.5, 2, 1, 2.5000000000000004, 7, 3),
            Block.box(7.499999999999998, 7, 10, 9.499999999999998, 7.5, 12),
            Block.box(4.499999999999998, 7, 9, 6.499999999999998, 7.5, 11),
            Block.box(3.5000000000000004, 7, 5, 5.499999999999998, 7.5, 7),
            Block.box(2.5000000000000004, 7, 10, 4.499999999999998, 7.5, 12),
            Block.box(7.499999999999998, 7, 7, 8.499999999999998, 7.5, 8),
            Block.box(6.499999999999998, 7, 8, 7.499999999999998, 7.5, 9),
            Block.box(3.0000000000000004, 7, 16.1, 4.499999999999998, 8.5, 16.6),
            Block.box(1, 3.5, 16.1, 6.499999999999998, 8, 16.1),
            Block.box(9.499999999999998, 3.5, 16.1, 14.999999999999998, 8, 16.1),
            Block.box(11.499999999999998, 7, 16.1, 12.999999999999998, 8.5, 16.6)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    private static final VoxelShape SHAPE_E = VoxelUtil.rotateShape(Direction.NORTH, Direction.EAST, SHAPE_N);
    private static final VoxelShape SHAPE_S = VoxelUtil.rotateShape(Direction.NORTH, Direction.SOUTH, SHAPE_N);
    private static final VoxelShape SHAPE_W = VoxelUtil.rotateShape(Direction.NORTH, Direction.WEST, SHAPE_N);

    private static final Map<Direction, VoxelShape> SHAPES = ImmutableMap.of(
            Direction.NORTH, SHAPE_N,
            Direction.EAST, SHAPE_E,
            Direction.SOUTH, SHAPE_S,
            Direction.WEST, SHAPE_W
    );

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        Direction facing = state.getValue(FACING);
        return SHAPES.getOrDefault(facing, SHAPE_N);
    }
    @Override
    public ActionResultType use(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isClientSide) {
            TileEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof ChestTileEntity) {
                player.openMenu((INamedContainerProvider)tileEntity);
                player.awardStat(Stats.OPEN_CHEST);
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new DungeonChestEntity();
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
}
