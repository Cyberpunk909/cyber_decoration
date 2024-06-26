package com.cyber.punk.test;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DesertGuardianEntity extends MonsterEntity implements IAnimatable {
    private static final Logger LOGGER = LogManager.getLogger();
    private AnimationFactory factory = new AnimationFactory(this);
    private boolean isActive = false;
    private boolean hasSpawned = false;
    private boolean useBluntAttack = true;
    private boolean swinging = false;

    public DesertGuardianEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 10;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, true)); // Немного быстрее игрока
        this.goalSelector.addGoal(3, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute createMobAttributes() {
        return CreatureEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.ATTACK_DAMAGE, 10.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.12); // Немного быстрее игрока
    }

    @Override
    public void aiStep() {
        super.aiStep();
        // Пользовательское поведение анимации
        if (!this.isActive && this.level.getNearestPlayer(this, 10.0D) != null) {
            this.activateBoss();
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource source, int looting, boolean recentlyHitIn) {
        super.dropCustomDeathLoot(source, looting, recentlyHitIn);
        // Выпадение предметов при смерти
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        // Проигрывание анимации и эффектов при смерти
        this.level.playSound(null, this.blockPosition(), SoundEvents.IRON_GOLEM_DEATH, this.getSoundSource(), 1.0F, 1.0F);
        this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1.0D, 0.0D, 0.0D);
    }

    public void performSpawnEffect() {
        // Проигрывание эффектов при появлении
        this.level.playSound(null, this.blockPosition(), SoundEvents.WITHER_SPAWN, this.getSoundSource(), 1.0F, 1.0F);
        for (int i = 0; i < 10; ++i) {
            this.level.addParticle((IParticleData) ParticleTypes.BLOCK, this.getX() + this.random.nextDouble(), this.getY() + this.random.nextDouble(), this.getZ() + this.random.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

    public void performAttackBlunt() {
        LOGGER.info("Выполнение обычной атаки");
        // Выполнение тупой атаки
        this.level.playSound(null, this.blockPosition(), SoundEvents.GENERIC_EXPLODE, this.getSoundSource(), 1.0F, 1.0F);
        this.level.addParticle(ParticleTypes.EXPLOSION, this.getX(), this.getY(), this.getZ(), 1.0D, 0.0D, 0.0D);
        // Нанесение урона сущностям в радиусе
        for (LivingEntity entity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(6.0D))) {
            if (entity != this && !entity.isAlliedTo(this)) {
                entity.hurt(DamageSource.mobAttack(this), 6.0F);
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.6D, 0.0D));
            }
        }
    }

    public void performAttackSlash() {
        LOGGER.info("Выполнение рубящей атаки");
        // Выполнение рубящей атаки
        this.level.playSound(null, this.blockPosition(), SoundEvents.PLAYER_ATTACK_SWEEP, this.getSoundSource(), 1.0F, 1.0F);
        // Нанесение урона сущностям в радиусе
        for (LivingEntity entity : this.level.getEntitiesOfClass(LivingEntity.class, this.getBoundingBox().inflate(5.0D))) {
            if (entity != this && !entity.isAlliedTo(this)) {
                entity.hurt(DamageSource.mobAttack(this), 6.0F);
                entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, 0.3D, 0.0D));
            }
        }
    }

    public void performWalkEffect() {
        // Проигрывание эффектов при ходьбе
        this.level.playSound(null, this.blockPosition(), SoundEvents.STONE_STEP, this.getSoundSource(), 1.0F, 1.0F);
        this.level.addParticle((IParticleData) ParticleTypes.BLOCK, this.getX(), this.getY(), this.getZ(), 1.0D, 0.0D, 0.0D);
    }

    public void onSpawn() {
        this.performSpawnEffect();
        // Переход в состояние агрессии
        this.setAggressive(true);
    }

    public void onDamaged(DamageSource source) {
        super.hurt(source, 0.0F);
        this.level.playSound(null, this.blockPosition(), SoundEvents.IRON_GOLEM_HURT, this.getSoundSource(), 1.0F, 1.0F);
    }

    public void onAttack() {
        if (useBluntAttack) {
            this.performAttackBlunt();
            this.swinging = true;
        } else {
            this.performAttackSlash();
            this.swinging = true;
        }
        useBluntAttack = !useBluntAttack; // Чередование атак
    }

    @Override
    public void registerControllers(AnimationData data) {
        AnimationController<DesertGuardianEntity> controller = new AnimationController<>(this, "controller", 0, this::predicate);
        controller.registerSoundListener(event -> {
            if (event.sound.equals("attack_blunt")) {
                this.onAttack();
            } else if (event.sound.equals("attack_slash")) {
                this.onAttack();
            }
        });
        data.addAnimationController(controller);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if (!this.hasSpawned) {
            LOGGER.info("Playing spawn_idle animation");
            event.getController().setAnimation(new AnimationBuilder().addAnimation("spawn_idle", false));
            this.hasSpawned = true;
            return PlayState.CONTINUE;
        }

        if (!this.isActive) {
            LOGGER.info("Playing idle animation");
            event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
            return PlayState.CONTINUE;
        }

        if (event.isMoving()) {
            LOGGER.info("Playing walk animation");
            event.getController().setAnimation(new AnimationBuilder().addAnimation("walk", true));
            return PlayState.CONTINUE;
        }

        if (this.swinging) {
            String attackAnimation = this.useBluntAttack ? "attack_blunt" : "attack_slash";
            LOGGER.info("Playing attack animation: " + attackAnimation);
            event.getController().setAnimation(new AnimationBuilder().addAnimation(attackAnimation, false));
            this.swinging = false;
            return PlayState.CONTINUE;
        }

        LOGGER.info("Playing idle animation");
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public void activateBoss() {
        this.isActive = true;
        this.level.playSound(null, this.blockPosition(), SoundEvents.WITHER_SPAWN, this.getSoundSource(), 1.0F, 1.0F);
        // Запуск анимации 'spawn'
        AnimationData data = this.factory.getOrCreateAnimationData(this.getId());
        AnimationController<?> controller = data.getAnimationControllers().get("controller");

        if (controller != null) {
            LOGGER.info("Запуск анимации 'spawn' для босса");
            controller.setAnimation(new AnimationBuilder().addAnimation("spawn", false));
        } else {
            LOGGER.warn("Не удалось найти контроллер анимации 'controller'");
        }
    }
}
