package com.cyber.punk.test;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MerchantOffer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class BabyWalleEntity extends AbstractVillagerEntity implements IAnimatable {
    private final AnimationFactory factory = new AnimationFactory(this);

    public BabyWalleEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void rewardTradeXp(MerchantOffer p_213713_1_) {
        this.getTradingPlayer().giveExperiencePoints(0);
    }

    @Nullable
    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(1, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
        } else {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        }
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState groundInspectPredicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("ground_inspect", false));
        return PlayState.CONTINUE;
    }

    private <E extends IAnimatable> PlayState helloPredicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("hello", false));
        return PlayState.CONTINUE;
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide && this.tickCount % 1200 == 0) { // 1200 тиков = 60 секунд
            AnimationController<?> controller = GeckoLibUtil.getControllerForID(this.factory, 0, "controller");
            controller.markNeedsReload();
            controller.setAnimation(new AnimationBuilder().addAnimation("ground_inspect", false));
        }

        PlayerEntity closestPlayer = this.level.getNearestPlayer(this, 10);
        if (closestPlayer != null) {
            AnimationController<?> helloController = GeckoLibUtil.getControllerForID(this.factory, 1, "helloController");
            helloController.markNeedsReload();
            helloController.setAnimation(new AnimationBuilder().addAnimation("hello", false));
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<>(this, "controller", 10, this::predicate));
        data.addAnimationController(new AnimationController<>(this, "groundInspectController", 0, this::groundInspectPredicate));
        data.addAnimationController(new AnimationController<>(this, "helloController", 0, this::helloPredicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    protected void updateTrades() {
        // Добавьте вашу логику обмена здесь
    }
}
