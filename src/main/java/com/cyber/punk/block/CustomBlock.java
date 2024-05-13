package com.cyber.punk.block;

import com.cyber.punk.boundingBlock.BoundingBlock;
import com.cyber.punk.boundingBlock.BoundingBlockEntity;
import com.cyber.punk.boundingBlock.ICustomShapeProvider;
import com.cyber.punk.boundingBlock.VoxelUtil;
import com.cyber.punk.block.entity.CustomBlockEntity;
import com.cyber.punk.Registry;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.stream.Stream;

public class CustomBlock extends HorizontalBlock implements ICustomShapeProvider {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public CustomBlock() {
        super(AbstractBlock.Properties.of(Material.METAL).strength(5.0F).noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CustomBlockEntity();
    }

    @Override
    public void onPlace(BlockState state, World world, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (!world.isClientSide && !oldState.is(state.getBlock())) {
            placeBoundingBlocks(world, pos, state.getValue(FACING));
        }
    }
    private void placeBoundingBlocks(World world, BlockPos pos, Direction facing) {
        BlockPos[] positions = new BlockPos[]{
                pos.relative(Direction.EAST), pos.relative(Direction.WEST)
        };

        VoxelShape shape = SHAPES.get(facing);
        Vector3d offset = OFFSETS.get(facing);

        for (BlockPos blockPos : positions) {
            if (world.isEmptyBlock(blockPos)) {
                world.setBlock(blockPos, Registry.BOUNDING_BLOCK.get().defaultBlockState(), 3);
                TileEntity te = world.getBlockEntity(blockPos);
                if (te instanceof BoundingBlockEntity) {
                    ((BoundingBlockEntity) te).setMainLocation(pos);
                    ((BoundingBlockEntity) te).setCustomShape(shape.move(-blockPos.getX() + pos.getX(), -blockPos.getY() + pos.getY(), -blockPos.getZ() + pos.getZ()).move(offset.x, offset.y, offset.z));
                }
            }
        }
    }

    @Override
    public void onRemove(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            removeBoundingBlocks(world, pos);
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    private void removeBoundingBlocks(World world, BlockPos pos) {
        BlockPos[] positions = new BlockPos[]{
                pos.relative(Direction.EAST),
                pos.relative(Direction.WEST)
        };

        for (BlockPos blockPos : positions) {
            if (world.getBlockState(blockPos).getBlock() instanceof BoundingBlock) {
                world.removeBlock(blockPos, false);
            }
        }
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
            Direction.SOUTH, SHAPE_S,
            Direction.WEST, SHAPE_W,
            Direction.EAST, SHAPE_E
    );

    private static final Map<Direction, Vector3d> OFFSETS = ImmutableMap.of(
            Direction.NORTH, new Vector3d(0, 0, 0),
            Direction.SOUTH, new Vector3d(0, 0, 0),
            Direction.WEST, new Vector3d(0, 0, 0),
            Direction.EAST, new Vector3d(0, 0, 0)
    );

    @Override
    public VoxelShape getShape(@NotNull BlockState blockState, IBlockReader reader, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
        return SHAPES.get(blockState.getValue(FACING));
    }

    @Override
    public VoxelShape getCustomShape(IBlockReader world, BlockPos pos) {
        Direction facing = world.getBlockState(pos).getValue(FACING);
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
