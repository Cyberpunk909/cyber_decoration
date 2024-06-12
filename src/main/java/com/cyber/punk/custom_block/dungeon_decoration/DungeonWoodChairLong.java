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
            Block.box(-7.932295000000002, 9.205326000000001, 0.9189800000000008, 24.640397, 11.329632, 3.7513880000000013),
            Block.box(-7.932295000000002, 9.205326000000001, 6.583796, 24.640397, 11.329632, 9.416204),
            Block.box(-8.580754000000002, 9.205326000000001, 9.416204, 23.932295000000003, 11.329632, 12.248612000000001),
            Block.box(-8.580754000000002, 9.205326000000001, 3.7513880000000013, 23.932295000000003, 11.329632, 6.583796),
            Block.box(-7.932295000000002, 9.205326000000001, 12.248612000000001, 24.640397, 11.329632, 15.081019999999999),
            Block.box(21.099887000000003, 1.416204, 4.459490000000001, 23.224193, 2.832408, 11.540510000000001),
            Block.box(-7.224193000000003, 1.416204, 4.459490000000001, -5.0998870000000025, 2.832408, 11.540510000000001),
            Block.box(-5.0998870000000025, 1.416204, 6.583796, 21.099887000000003, 2.832408, 9.416204),
            Block.box(21.099887000000003, 4.248612, 2.335184000000001, 23.224193, 7.0810200000000005, 4.459490000000001),
            Block.box(20.391785000000002, 0, 1.6270820000000008, 23.932295000000003, 2.124306, 5.167592000000002),
            Block.box(20.745835999999994, 2.124306, 1.9811330000000007, 23.578243999999998, 4.248612, 4.813541000000001),
            Block.box(21.099887000000003, 4.248612, 11.540510000000001, 23.224193, 7.0810200000000005, 13.664816000000002),
            Block.box(20.745835999999994, 2.124306, 11.186459, 23.578243999999998, 4.248612, 14.018867),
            Block.box(20.391785000000002, 0, 10.832408000000001, 23.932295000000003, 2.124306, 14.372918000000002),
            Block.box(20.745835999999994, 7.0810200000000005, 0.5649290000000007, 23.578243999999998, 9.205326000000001, 15.435071),
            Block.box(-6.870142000000001, 4.248612, 11.540510000000001, -4.745836000000001, 7.0810200000000005, 13.664816000000002),
            Block.box(-7.224193000000003, 2.124306, 11.186459, -4.391785000000001, 4.248612, 14.018867),
            Block.box(-7.5782440000000015, 0, 10.832408000000001, -4.037734000000002, 2.124306, 14.372918000000002),
            Block.box(-7.224193000000003, 7.0810200000000005, 0.5649290000000007, -4.391785000000001, 9.205326000000001, 15.435071),
            Block.box(-7.5782440000000015, 0, 1.6270820000000008, -4.037734000000002, 2.124306, 5.167592000000002),
            Block.box(-7.224193000000003, 2.124306, 1.9811330000000007, -4.391785000000001, 4.248612, 4.813541000000001),
            Block.box(-6.870142000000001, 4.248612, 2.335184000000001, -4.745836000000001, 7.0810200000000005, 4.459490000000001)
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
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
                positions = new BlockPos[]{pos.relative(Direction.EAST), pos.relative(Direction.WEST)};
                break;
            case SOUTH:
                positions = new BlockPos[]{pos.relative(Direction.WEST), pos.relative(Direction.EAST)};
                break;
            case WEST:
                positions = new BlockPos[]{pos.relative(Direction.NORTH), pos.relative(Direction.SOUTH)};
                break;
            case EAST:
                positions = new BlockPos[]{pos.relative(Direction.SOUTH), pos.relative(Direction.NORTH)};
                break;
        }

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
    }
}
