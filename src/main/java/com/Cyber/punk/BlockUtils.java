package com.Cyber.punk;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class BlockUtils extends Block {
    // Определение свойства направления для блока
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    public BlockUtils(AbstractBlock.Properties properties) {
        super(properties);
        // Регистрация состояния блока по умолчанию с установленным свойством направления
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public BlockRenderType getRenderShape(BlockState state) {
        return BlockRenderType.MODEL;
    }

    // Получение состояния блока для размещения в мире
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    // Поворот состояния блока
    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    // Зеркальное отображение состояния блока
    @Override
    public BlockState mirror(BlockState state, net.minecraft.util.Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    // Определение состояний блока для его сохранения
    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    // Получение направления, в котором сущность смотрит относительно блока в мире
    public static Direction getFacingFromEntity(World world, BlockPos clickedBlock, net.minecraft.entity.Entity entity) {
        return getFacingFromEntity(clickedBlock, entity.blockPosition());
    }

    // Получение направления, в котором сущность смотрит относительно блока в мире
    public static Direction getFacingFromEntity(BlockPos clickedBlock, BlockPos entityPos) {
        return Direction.fromYRot((float) (Math.atan2(entityPos.getZ() - clickedBlock.getZ(), entityPos.getX() - clickedBlock.getX()) * 180.0D / Math.PI) - 90.0F);
    }

    // Проверка, являются ли два блока одинаковыми
    public static boolean isSameBlock(BlockState state1, BlockState state2) {
        return state1.is(state2.getBlock());
    }
    protected void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
    }
}
