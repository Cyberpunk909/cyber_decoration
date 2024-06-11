package com.cyber.punk;

import net.minecraft.block.Blocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

@Mod(Cyber.MOD_ID)
public class Cyber {
    public static final String MOD_ID = "cyber_decoration";
    public static final Logger LOGGER = LogManager.getLogger();

    public Cyber() {
        LOGGER.info("Registering items and blocks...");
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Entites.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
        eventBus.addListener(this::setup);
        eventBus.addListener(this::enqueueIMC);
        eventBus.addListener(this::processIMC);
        eventBus.addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
        Registry.register(eventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        RenderTypeLookup.setRenderLayer(Registry.DUNGEON_FLAG.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.DUNGEON_SKELETON.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.DUNGEON_SKELETON_HEAD.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.DUNGEON_SKELETON_SLEEP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.DUNGEON_HANG_FLAG.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.AZALEA_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.FLOWERING_AZALEA_BLOCK.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.AZALEA_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.FLOWERING_AZALEA_LEAVES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.BIG_DRIPLEAF.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.HANGING_ROOTS.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.BIRCH_HANGING_SIGN.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.DARK_OAK_HANGING_SIGN.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.WARPED_HANGING_SIGN.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.CRIMSON_HANGING_SIGN.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.CAVE_VINES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.CAVE_VINES_BERRIES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.CAVE_VINES_PLANT.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.CAVE_VINES_PLANT_BERRIES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.SMALL_DRIPLEAF_TOP.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.SMALL_DRIPLEAF_BOTTOM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.BIG_DRIPLEAF_STEM.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(Registry.COPPER_DOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.EXPOSED_COPPER_DOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.WEATHERED_COPPER_DOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.OXIDIZED_COPPER_DOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.COPPER_TRAPDOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.EXPOSED_COPPER_TRAPDOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.WEATHERED_COPPER_TRAPDOOR.get(), RenderType.translucent());
        RenderTypeLookup.setRenderLayer(Registry.OXIDIZED_COPPER_TRAPDOOR.get(), RenderType.translucent());
    }


    private void enqueueIMC(final InterModEnqueueEvent event) {
        InterModComms.sendTo("examplemod", "helloworld", () -> {
            LOGGER.info("Hello world from the MDK");
            return "Hello world";
        });
    }

    private void processIMC(final InterModProcessEvent event) {
        LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        LOGGER.info("HELLO from server starting");
    }
}
