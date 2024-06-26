package com.cyber.punk.test;

import com.cyber.punk.util.Cyber;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cyber.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModRenderers {
    @SubscribeEvent
    public static void registerRenderers(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(MobEntities.BABY_WALLE, BabyWalleRender::new);
        RenderingRegistry.registerEntityRenderingHandler(MobEntities.TOFFY_WITCH, ToffyWitchRender::new);
        RenderingRegistry.registerEntityRenderingHandler(MobEntities.DESERT_GUARDIAN, DesertGuardianRenderer::new);
    }
}

