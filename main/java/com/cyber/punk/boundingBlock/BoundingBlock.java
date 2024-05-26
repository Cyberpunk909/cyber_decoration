package com.cyber.punk.boundingBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.cyber.punk.Cyber;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.chunk.ChunkRenderCache;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class BoundingBlock extends Block {
    public BoundingBlock() {
        super(AbstractBlock.Properties.of(Material.DIRT)
                .strength(5.0F, 6.0F)
                .noOcclusion());
    }

    @Nullable
    public static BlockPos getMainBlockPos(IBlockReader world, BlockPos thisPos) {
        TileEntity tile = world.getBlockEntity(thisPos);
        if (tile instanceof BoundingBlockEntity) {
            BoundingBlockEntity te = (BoundingBlockEntity) tile;
            return te.receivedCoords && !thisPos.equals(te.getMainPos()) ? te.getMainPos() : null;
        }
        return null;
    }

    @Nonnull
    @Deprecated
    public PushReaction getPistonPushReaction(@Nonnull BlockState state) {
        return PushReaction.BLOCK;
    }

    @Override
    public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos != null) {
            BlockState mainState = world.getBlockState(mainPos);
            return mainState.getBlock().use(mainState, world, mainPos, player, hand, hit);
        }
        return ActionResultType.FAIL;
    }

    @Override
    public void onRemove(@Nonnull BlockState state, @Nonnull World world, @Nonnull BlockPos pos, @Nonnull BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockPos mainPos = getMainBlockPos(world, pos);
            if (mainPos != null) {
                BlockState mainState = world.getBlockState(mainPos);
                if (!mainState.isAir(world, mainPos)) {
                    world.removeBlock(mainPos, false);
                }
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public void playerWillDestroy(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos != null) {
            BlockState mainState = world.getBlockState(mainPos);
            mainState.onRemove(world, mainPos, Blocks.AIR.defaultBlockState(), false);
            world.setBlock(mainPos, Blocks.AIR.defaultBlockState(), 35);
            if (!world.isClientSide && !player.isCreative()) {
                popResource(world, mainPos, new ItemStack(mainState.getBlock()));
            }
        }
        if (!world.isClientSide && !player.isCreative()) {
            popResource(world, pos, new ItemStack(this));
        }
        super.playerWillDestroy(world, pos, state, player);
    }


    @Override
    public ItemStack getPickBlock(@Nonnull BlockState state, RayTraceResult target, @Nonnull IBlockReader world, @Nonnull BlockPos pos, PlayerEntity player) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos == null) {
            return ItemStack.EMPTY;
        } else {
            BlockState mainState = world.getBlockState(mainPos);
            return mainState.getBlock().getPickBlock(mainState, target, world, mainPos, player);
        }
    }

    @Override
    public boolean removedByPlayer(@Nonnull BlockState state, World world, @Nonnull BlockPos pos, @Nonnull PlayerEntity player, boolean willHarvest, FluidState fluidState) {
        if (willHarvest) {
            return true;
        } else {
            BlockPos mainPos = getMainBlockPos(world, pos);
            if (mainPos != null) {
                BlockState mainState = world.getBlockState(mainPos);
                if (!mainState.isAir(world, mainPos)) {
                    mainState.removedByPlayer(world, mainPos, player, false, mainState.getFluidState());
                }
            }
            return super.removedByPlayer(state, world, pos, player, false, fluidState);
        }
    }

    @Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos != null) {
            BlockState mainState = world.getBlockState(mainPos);
            if (!mainState.isAir(world, mainPos)) {
                LootContext.Builder lootContextBuilder = new LootContext.Builder((ServerWorld) world)
                        .withRandom(world.random)
                        .withParameter(LootParameters.ORIGIN, Vector3d.atCenterOf(mainPos))
                        .withParameter(LootParameters.TOOL, ItemStack.EMPTY)
                        .withOptionalParameter(LootParameters.BLOCK_ENTITY, mainState.hasTileEntity() ? world.getBlockEntity(mainPos) : null)
                        .withOptionalParameter(LootParameters.THIS_ENTITY, explosion.getSourceMob());

                if (explosion.blockInteraction == Mode.DESTROY) {
                    lootContextBuilder.withParameter(LootParameters.EXPLOSION_RADIUS, explosion.radius);
                }
                mainState.getDrops(lootContextBuilder).forEach(stack -> Block.popResource(world, mainPos, stack));
                mainState.onBlockExploded(world, mainPos, explosion);
            }
        }

        super.onBlockExploded(state, world, pos, explosion);
    }

    @Override
    public void playerDestroy(@Nonnull World world, @Nonnull PlayerEntity player, @Nonnull BlockPos pos, @Nonnull BlockState state, TileEntity te, @Nonnull ItemStack stack) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos != null) {
            BlockState mainState = world.getBlockState(mainPos);
            mainState.getBlock().playerDestroy(world, player, mainPos, mainState, world.getBlockEntity(mainPos), stack);
        } else {
            super.playerDestroy(world, player, pos, state, te, stack);
        }

        world.removeBlock(pos, false);
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        BlockPos pos = new BlockPos(builder.getParameter(LootParameters.ORIGIN));
        BlockPos mainPos = getMainBlockPos(builder.getLevel(), pos);
        if (mainPos != null) {
            BlockState mainState = builder.getLevel().getBlockState(mainPos);
            return mainState.getDrops(builder);
        }
        return super.getDrops(state, builder);
    }

    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block neighborBlock, BlockPos neighborPos, boolean isMoving) {
        if (!world.isClientSide) {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof BoundingBlockEntity) {
                ((BoundingBlockEntity) tile).onNeighborChange(neighborBlock, neighborPos);
            }
        }

        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos != null) {
            world.getBlockState(mainPos).neighborChanged(world, mainPos, neighborBlock, neighborPos, isMoving);
        }
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public int getAnalogOutputSignal(BlockState state, World world, BlockPos pos) {
        if (!world.isClientSide) {
            TileEntity tile = world.getBlockEntity(pos);
            if (tile instanceof BoundingBlockEntity) {
                return ((BoundingBlockEntity) tile).getComparatorSignal();
            }
        }
        return 0;
    }

    @Override
    public float getDestroyProgress(@Nonnull BlockState state, @Nonnull PlayerEntity player, @Nonnull IBlockReader world, @Nonnull BlockPos pos) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos == null) {
            return super.getDestroyProgress(state, player, world, pos);
        } else {
            BlockState mainState = world.getBlockState(mainPos);
            return mainState.getDestroyProgress(player, world, mainPos);
        }
    }

    @Override
    public float getExplosionResistance(BlockState state, IBlockReader world, BlockPos pos, Explosion explosion) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos == null) {
            return super.getExplosionResistance(state, world, pos, explosion);
        } else {
            return world.getBlockState(mainPos).getExplosionResistance(world, mainPos, explosion);
        }
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(@Nonnull BlockState state, @Nonnull IBlockReader world) {
        return new BoundingBlockEntity();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        BlockPos mainPos = getMainBlockPos(world, pos);
        if (mainPos == null) {
            return VoxelShapes.empty();
        } else {
            BlockState mainState;
            try {
                mainState = world.getBlockState(mainPos);
            } catch (ArrayIndexOutOfBoundsException var9) {
                if (!(world instanceof ChunkRenderCache)) {
                    Cyber.LOGGER.error("Error getting bounding block shape, for position {}, with main position {}. World of type {}", pos, mainPos, world.getClass().getName());
                    return VoxelShapes.empty();
                }

                world = ((ChunkRenderCache) world).level;
                mainState = world.getBlockState(mainPos);
            }

            VoxelShape shape = mainState.getShape(world, mainPos, context);
            BlockPos offset = pos.subtract(mainPos);
            return shape.move(-offset.getX(), -offset.getY(), -offset.getZ());
        }
    }

    @Override
    public boolean isPathfindable(BlockState state, IBlockReader world, BlockPos pos, PathType type) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public boolean addHitEffects(BlockState state, World world, RayTraceResult target, ParticleManager manager) {
        if (target.getType() == RayTraceResult.Type.BLOCK && target instanceof BlockRayTraceResult) {
            BlockRayTraceResult blockTarget = (BlockRayTraceResult) target;
            BlockPos pos = blockTarget.getBlockPos();
            BlockPos mainPos = getMainBlockPos(world, pos);
            if (mainPos != null) {
                BlockState mainState = world.getBlockState(mainPos);
                if (!mainState.isAir(world, mainPos)) {
                    AxisAlignedBB axisalignedbb = state.getShape(world, pos).bounds();
                    double x = pos.getX() + world.random.nextDouble() * (axisalignedbb.maxX - axisalignedbb.minX - 0.2) + 0.1 + axisalignedbb.minX;
                    double y = pos.getY() + world.random.nextDouble() * (axisalignedbb.maxY - axisalignedbb.minY - 0.2) + 0.1 + axisalignedbb.minY;
                    double z = pos.getZ() + world.random.nextDouble() * (axisalignedbb.maxZ - axisalignedbb.minZ - 0.2) + 0.1 + axisalignedbb.minZ;
                    ((ClientWorld) world).addParticle(new BlockParticleData(ParticleTypes.BLOCK, mainState), true, x, y, z, 0.0, 0.0, 0.0);
                    return true;
                }
            }
        }
        return false;
    }
}
