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
    public static final RegistryObject<Block> DUNGEON_TABLE_LONG = BLOCKS.register("dungeon_table_long", DungeonTableLong::new);
    public static final RegistryObject<Block> DUNGEON_CAGE = BLOCKS.register("dungeon_cage", DungeonCage::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_WITH_REST = BLOCKS.register("dungeon_wood_chair_with_rest", DungeonWoodChairWithRest::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_WITH_BONE = BLOCKS.register("dungeon_wood_chair_with_bone", DungeonWoodChairWithBone::new);
    public static final RegistryObject<Block> CUSTOM_BLOCK = BLOCKS.register("custom_block", CustomBlock::new);



    // Блоки предметы
    public static final RegistryObject<BlockItem> CUSTOM_BLOCK_ITEM = ITEMS.register("custom_block",
            () -> new BlockItem(CUSTOM_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_ITEM = ITEMS.register("dungeon_wood_chair",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_HEADS_ITEM = ITEMS.register("dungeon_decorate_heads",
            () -> new BlockItem(DUNGEON_DECORATE_HEADS.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    public static final RegistryObject<BlockItem> DUNGEON_TABLE_LONG_ITEM = ITEMS.register("dungeon_table_long",
            () -> new BlockItem(DUNGEON_TABLE_LONG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_CAGE_ITEM = ITEMS.register("dungeon_cage",
            () -> new BlockItem(DUNGEON_CAGE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_WITH_REST_ITEM = ITEMS.register("dungeon_wood_chair_with_rest",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR_WITH_REST.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_WITH_BONE_ITEM = ITEMS.register("dungeon_wood_chair_with_bone",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR_WITH_BONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

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
