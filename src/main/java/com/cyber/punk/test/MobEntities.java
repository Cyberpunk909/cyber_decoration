package com.cyber.punk.test;

import com.cyber.punk.util.Cyber;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Cyber.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MobEntities {

    @ObjectHolder("cyber_decoration:baby_walle")
    public static final EntityType<BabyWalleEntity> BABY_WALLE = null;

    @ObjectHolder("cyber_decoration:toffy_witch")
    public static final EntityType<ToffyWitchEntity> TOFFY_WITCH = null;

    @ObjectHolder("cyber_decoration:desert_guardian")
    public static final EntityType<DesertGuardianEntity> DESERT_GUARDIAN = null;


    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        EntityType<BabyWalleEntity> babyWalleEntityType = EntityType.Builder.of(BabyWalleEntity::new, EntityClassification.MISC)
                .sized(1.0F, 1.0F)
                .build(new ResourceLocation(Cyber.MOD_ID, "baby_walle").toString());
        babyWalleEntityType.setRegistryName(new ResourceLocation(Cyber.MOD_ID, "baby_walle"));
        event.getRegistry().register(babyWalleEntityType);

        EntityType<ToffyWitchEntity> toffyWitchEntityType = EntityType.Builder.of(ToffyWitchEntity::new, EntityClassification.MISC)
                .sized(1.0F, 1.0F)
                .build(new ResourceLocation(Cyber.MOD_ID, "toffy_witch").toString());
        toffyWitchEntityType.setRegistryName(new ResourceLocation(Cyber.MOD_ID, "toffy_witch"));
        event.getRegistry().register(toffyWitchEntityType);

        EntityType<DesertGuardianEntity> desertGuardianEntityEntityType = EntityType.Builder.of(DesertGuardianEntity::new, EntityClassification.MONSTER)
                .sized(0.59F, 0.83F)
                .build(new ResourceLocation(Cyber.MOD_ID, "desert_guardian").toString());
        desertGuardianEntityEntityType.setRegistryName(new ResourceLocation(Cyber.MOD_ID, "desert_guardian"));
        event.getRegistry().register(desertGuardianEntityEntityType);

    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        if (BABY_WALLE == null) {
            System.err.println("BABY_WALLE EntityType is null!");
        } else {
            event.put(BABY_WALLE, BabyWalleEntity.createMobAttributes().build());
        }

        if (TOFFY_WITCH == null) {
            System.err.println("TOFFY_WITCH EntityType is null!");
        } else {
            event.put(TOFFY_WITCH, ToffyWitchEntity.createMobAttributes().build());
        }

        if (DESERT_GUARDIAN == null) {
            System.err.println("DESERT_GUARDIAN EntityType is null!");
        } else {
            event.put(DESERT_GUARDIAN, DesertGuardianEntity.createMobAttributes().build());
        }
    }
}