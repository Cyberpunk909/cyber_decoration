package com.cyber.punk;

import com.cyber.punk.Cyber_Group;
import com.cyber.punk.boundingBlock.BoundingBlock;
import com.cyber.punk.Cyber;
import com.cyber.punk.block.*;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class Registry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Cyber.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Cyber.MOD_ID);



    // Предметы
    public static final RegistryObject<Item> SHADOW_BOOK = ITEMS.register("shadow_book",
            () -> new Item(new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    //Фантом блок
    public static final RegistryObject<Block> BOUNDING_BLOCK = BLOCKS.register("bounding_block", BoundingBlock::new);
    // Блоки
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR = BLOCKS.register("dungeon_wood_chair", DungeonWoodChair::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_HEADS = BLOCKS.register("dungeon_decorate_heads", DungeonDecorateHeads::new);
    public static final RegistryObject<Block> CUSTOM_BLOCK = BLOCKS.register("custom_block", CustomBlock::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_THRONE = BLOCKS.register("dungeon_wood_throne", DungeonWoodThrone::new);
    public static final RegistryObject<Block> DUNGEON_FLAG = BLOCKS.register("dungeon_flag", DungeonFlag::new);
    public static final RegistryObject<Block> DUNGEON_HANG_FLAG = BLOCKS.register("dungeon_hang_flag", DungeonHangFlag::new);





    // Блоки предметы
    public static final RegistryObject<BlockItem> CUSTOM_BLOCK_ITEM = ITEMS.register("custom_block",
            () -> new BlockItem(CUSTOM_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_ITEM = ITEMS.register("dungeon_wood_chair",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_HEADS_ITEM = ITEMS.register("dungeon_decorate_heads",
            () -> new BlockItem(DUNGEON_DECORATE_HEADS.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_THRONE_ITEM = ITEMS.register("dungeon_wood_throne",
            () -> new BlockItem(DUNGEON_WOOD_THRONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_FLAG_ITEM = ITEMS.register("dungeon_flag",
            () -> new BlockItem(DUNGEON_FLAG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_HANG_FLAG_ITEM = ITEMS.register("dungeon_hang_flag",
            () -> new BlockItem(DUNGEON_HANG_FLAG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));


    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> blockSupplier) {
        RegistryObject<T> blockRegistryObject = BLOCKS.register(name, blockSupplier);
        registerBlockItem(name, blockRegistryObject);
        return blockRegistryObject;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
    }
}
