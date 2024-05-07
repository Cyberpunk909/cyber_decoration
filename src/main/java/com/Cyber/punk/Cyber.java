    package com.Cyber.punk;

    import com.Cyber.punk.item.Entites;
    import com.Cyber.punk.item.Registry;
    import net.minecraft.block.Blocks;
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
        public static final String MOD_ID = "cyber_hardevo";
        public static final Logger LOGGER = LogManager.getLogger();

        public Cyber() {
            // Register the setup method for modloading
            LOGGER.info("Registering items and blocks..."); // Added debug output
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            Entites.REGISTER.register(FMLJavaModLoadingContext.get().getModEventBus());
            eventBus.addListener(this::setup);
            // Register the enqueueIMC method for modloading
            eventBus.addListener(this::enqueueIMC);
            // Register the processIMC method for modloading
            eventBus.addListener(this::processIMC);
            // Register the doClientStuff method for modloading
            eventBus.addListener(this::doClientStuff);

            // Register ourselves for server and other game events we are interested in
            MinecraftForge.EVENT_BUS.register(this);

            // Register ModItems and ModBlocks
            Registry.register(eventBus);
        }

        private void setup(final FMLCommonSetupEvent event) {
            LOGGER.info("HELLO FROM PREINIT");
            LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());

        }

        private void doClientStuff(final FMLClientSetupEvent event) {
            // do something that can only be done on the client
            LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        }

        private void enqueueIMC(final InterModEnqueueEvent event) {
            // some example code to dispatch IMC to another mod
            InterModComms.sendTo("examplemod", "helloworld", () -> {
                LOGGER.info("Hello world from the MDK");
                return "Hello world";
            });
        }

        private void processIMC(final InterModProcessEvent event) {
            // some example code to receive and process InterModComms from other mods
            LOGGER.info("Got IMC {}", event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
        }

        // You can use SubscribeEvent and let the Event Bus discover methods to call
        @SubscribeEvent
        public void onServerStarting(FMLServerStartingEvent event) {
            // do something when the server starts
            LOGGER.info("HELLO from server starting");
        }
    }
