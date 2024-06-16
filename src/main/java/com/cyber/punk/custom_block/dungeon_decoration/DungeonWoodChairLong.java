package com.cyber.punk.custom_block.dungeon_decoration;

import com.cyber.punk.util.AbstractCustomBlock;
import com.cyber.punk.util.Registry;
import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.dungeon_decoration.DungeonWoodChairLongEntity;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.Map;
import java.util.stream.Stream;

public class DungeonWoodChairLong extends AbstractCustomBlock {
    public DungeonWoodChairLong() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD)
                .strength(1f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(-0.13602900000000062, 9.0212234, 0.9473039999999999, 31.785216999999996, 11.1030374, 3.7230657999999996),
            Block.box(-0.13602900000000062, 9.0212234, 6.4988276, 31.785216999999996, 11.1030374, 9.274579600000001),
            Block.box(-0.771510000000001, 9.0212234, 9.274579600000001, 31.091279000000007, 11.1030374, 12.050341399999999),
            Block.box(-0.771510000000001, 9.0212234, 3.7230657999999996, 31.091279000000007, 11.1030374, 6.4988276),
            Block.box(-0.13602900000000062, 9.0212234, 12.050341399999999, 31.785216999999996, 11.1030374, 14.8261032),
            Block.box(28.315517200000002, 1.3878759999999999, 4.4170038, 30.397331199999996, 2.7757617999999997, 11.3564034),
            Block.box(0.5579187999999995, 1.3878759999999999, 4.4170038, 2.639732799999999, 2.7757617999999997, 11.3564034),
            Block.box(2.639732799999999, 1.3878759999999999, 6.4988276, 28.315517200000002, 2.7757617999999997, 9.274579600000001),
            Block.box(28.315517200000002, 4.1636378, 2.33518, 30.397331199999996, 6.9393996, 4.4170038),
            Block.box(27.6215792, 0, 1.641242, 31.091279000000007, 2.0818238, 5.110941799999999),
            Block.box(27.9685482, 2.0818238, 1.9882110000000002, 30.744300199999998, 4.1636378, 4.7639727999999995),
            Block.box(28.315517200000002, 4.1636378, 11.3564034, 30.397331199999996, 6.9393996, 13.4382272),
            Block.box(27.9685482, 2.0818238, 11.0094344, 30.744300199999998, 4.1636378, 13.7851962),
            Block.box(27.6215792, 0, 10.662465399999999, 31.091279000000007, 2.0818238, 14.132165200000001),
            Block.box(27.9685482, 6.9393996, 0.6003350000000001, 30.744300199999998, 9.0212234, 15.1730722),
            Block.box(0.9048878000000009, 4.1636378, 11.3564034, 2.9867017999999987, 6.9393996, 13.4382272),
            Block.box(0.5579187999999995, 2.0818238, 11.0094344, 3.3336708, 4.1636378, 13.7851962),
            Block.box(0.21094979999999808, 0, 10.662465399999999, 3.6806496000000006, 2.0818238, 14.132165200000001),
            Block.box(0.5579187999999995, 6.9393996, 0.6003350000000001, 3.3336708, 9.0212234, 15.1730722),
            Block.box(0.21094979999999808, 0, 1.641242, 3.6806496000000006, 2.0818238, 5.110941799999999),
            Block.box(0.5579187999999995, 2.0818238, 1.9882110000000002, 3.3336708, 4.1636378, 4.7639727999999995),
            Block.box(0.9048878000000009, 4.1636378, 2.33518, 2.9867017999999987, 6.9393996, 4.4170038)
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
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new DungeonWoodChairLongEntity();
    }

    @Override
    protected Map<Direction, VoxelShape> getShapes() {
        return SHAPES;
    }

    @Override
    protected boolean canPlaceBlockAt(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{pos.relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (!state.isAir() && !state.getMaterial().isReplaceable()) {
                return false;
            }
        }

        return true;
    }

    @Override
    protected void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{pos.relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH)};
                break;
        }

        VoxelShape shape = getShapes().get(facing);

        for (BlockPos blockPos : positions) {
            BlockState state = world.getBlockState(blockPos);
            if (state.isAir() || state.getMaterial().isReplaceable()) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(pos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(-blockPos.getX() + pos.getX(), -blockPos.getY() + pos.getY(), -blockPos.getZ() + pos.getZ()));
                }
            }
        }
    }

    @Override
    protected void removeBoundingBlocks(World world, BlockPos pos, BlockState blockState, Direction facing) {
        BlockPos[] positions;
        switch (facing) {
            case NORTH:
            default:
                positions = new BlockPos[]{pos.relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
