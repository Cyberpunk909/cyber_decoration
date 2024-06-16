package com.cyber.punk.custom_block.sci_fi_decoration;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.bounding_block.VoxelUtil;
import com.cyber.punk.entity.sci_fi_decoration.SciFiWeaponEntity;
import com.cyber.punk.util.AbstractCustomBlock;
import com.cyber.punk.util.Registry;
import com.google.common.collect.ImmutableMap;
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

public class SciFiWeapon extends AbstractCustomBlock {
    public SciFiWeapon() {
        super(Properties.of(
                        Material.STONE)
                .strength(2f,4.0f)
                .noOcclusion());
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(12.5, 14, 12.5, 21.5, 16, 14.5),
            Block.box(11.5, 13, 11.5, 12.5, 17, 15.5),
            Block.box(9.5, 14, 12.5, 11.5, 16, 14.5),
            Block.box(2.5, 14.25, 12.75, 9.5, 15.75, 14.25),
            Block.box(21.5, 13, 11.5, 22.5, 17, 15.5),
            Block.box(22.5, 14, 12.5, 24.5, 16, 14.5),
            Block.box(24.5, 14.25, 12.75, 31.5, 15.75, 14.25),
            Block.box(3, 4, 13.5, 19, 5, 14.5),
            Block.box(19, 3.5, 13.5, 21, 5.5, 14.5),
            Block.box(21, 3.5, 13, 28, 5.5, 15),
            Block.box(14, 12, 15, 20, 14, 16),
            Block.box(14, 2, 15, 20, 4, 16),
            Block.box(12.5, 10, 13, 13.5, 14, 15),
            Block.box(12.5, 13.90165, 11.7448, 13.5, 15.90165, 12.7448),
            Block.box(12.51, 12.25, 14.5, 13.49, 15.25, 15.5),
            Block.box(20.5, 10, 13, 21.5, 14, 15),
            Block.box(20.509999999999998, 12.25, 14.5, 21.490000000000002, 15.25, 15.5),
            Block.box(20.5, 13.90165, 11.7448, 21.5, 15.90165, 12.7448),
            Block.box(12.5, 0, 13, 13.5, 4, 15),
            Block.box(12.5, 3.90165, 11.7448, 13.5, 5.90165, 12.7448),
            Block.box(12.51, 2.25, 14.5, 13.49, 5.25, 15.5),
            Block.box(20.5, 0, 13, 21.5, 4, 15),
            Block.box(20.509999999999998, 2.25, 14.5, 21.490000000000002, 5.25, 15.5),
            Block.box(20.5, 3.90165, 11.7448, 21.5, 5.90165, 12.7448),
            Block.box(12, 0, 15, 14, 16, 16),
            Block.box(20, 0, 15, 22, 16, 16)
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
        return new SciFiWeaponEntity();
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.EAST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.WEST),};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.NORTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH),  pos.relative(Direction.UP),
                        pos.relative(Direction.UP).relative(Direction.SOUTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
