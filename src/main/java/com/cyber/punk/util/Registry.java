package com.cyber.punk.util;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.custom_block.dungeon_decoration.*;
import com.cyber.punk.custom_block.summer_decoration.*;
import com.cyber.punk.dungeon_decoration.*;
import com.cyber.punk.just_block.summer_decoration.OakLog;
import com.cyber.punk.just_block.summer_decoration.OakPlant;
import com.cyber.punk.just_block.summer_decoration.OakStool;
import com.cyber.punk.just_block.vanilla_block.*;
import com.cyber.punk.light_block.LightBlock08;
import com.cyber.punk.light_block.LightBlock15;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
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

    // Фантом блок
    public static final RegistryObject<Block> BOUNDING_BLOCK = BLOCKS.register("bounding_block", BoundingBlock::new);

    // Обычные Блоки
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR = BLOCKS.register("dungeon_wood_chair", DungeonWoodChair::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_HEADS = BLOCKS.register("dungeon_decorate_heads", DungeonDecorateHeads::new);
    public static final RegistryObject<Block> COPPER_BLOCK = BLOCKS.register("copper_block", CopperBlock::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_VASE = BLOCKS.register("dungeon_decorate_vase", DungeonDecorateVase::new);
    public static final RegistryObject<Block> BIRCH_HANGING_SIGN = BLOCKS.register("birch_hanging_sign", BirchHangingSign::new);
    public static final RegistryObject<Block> DARK_OAK_HANGING_SIGN = BLOCKS.register("dark_oak_hanging_sign", DarkOakHangingSign::new);
    public static final RegistryObject<Block> WARPED_HANGING_SIGN = BLOCKS.register("warped_hanging_sign", WarpedHangingSign::new);
    public static final RegistryObject<Block> CRIMSON_HANGING_SIGN = BLOCKS.register("crimson_hanging_sign", CrimsonHangingSign::new);
    public static final RegistryObject<Block> DECORATED_POT = BLOCKS.register("decorated_pot", DecoratedPot::new);
    public static final RegistryObject<Block> EXPOSED_COPPER_BLOCK = BLOCKS.register("exposed_copper_block", ExposedCopperBlock::new);
    public static final RegistryObject<Block> WEATHERED_COPPER_BLOCK = BLOCKS.register("weathered_copper_block", WeatheredCopperBlock::new);
    public static final RegistryObject<Block> OXIDIZED_COPPER_BLOCK = BLOCKS.register("oxidized_copper_block", OxidizedCopperBlock::new);
    public static final RegistryObject<Block> CUT_COPPER_BLOCK = BLOCKS.register("cut_copper_block", CutCopperBlock::new);
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_BLOCK = BLOCKS.register("cut_exposed_copper_block", CutExposedCopperBlock::new);
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_BLOCK = BLOCKS.register("cut_weathered_copper_block", CutWeatheredCopperBlock::new);
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_BLOCK = BLOCKS.register("cut_oxidized_copper_block", CutOxidizedCopperBlock::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_GOLDBARS = BLOCKS.register("dungeon_decorate_goldbars", DungeonDecorateGoldbars::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_GOLDBARS_WITH_COIN = BLOCKS.register("dungeon_decorate_goldbars_with_coin", DungeonDecorateGoldbarsWithCoin::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_COINS = BLOCKS.register("dungeon_decorate_coins", DungeonDecorateCoins::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_GOLDBAR = BLOCKS.register("dungeon_decorate_goldbar", DungeonDecorateGoldbar::new);
    public static final RegistryObject<Block> DUNGEON_TORCH = BLOCKS.register("dungeon_torch", DungeonTorch::new);
    public static final RegistryObject<Block> DUNGEON_WEAPON_STAND = BLOCKS.register("dungeon_weapon_stand", DungeonWeaponStand::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_BARREL = BLOCKS.register("dungeon_wood_barrel", DungeonWoodBarrel::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_BOX = BLOCKS.register("dungeon_wood_box", DungeonWoodBox::new);
    public static final RegistryObject<Block> DUNGEON_CAGE = BLOCKS.register("dungeon_cage", DungeonCage::new);
    public static final RegistryObject<Block> OAK_LOG = BLOCKS.register("oak_log", OakLog::new);
    public static final RegistryObject<Block> OAK_PLANT = BLOCKS.register("oak_plant", OakPlant::new);
    public static final RegistryObject<Block> OAK_BENCH = BLOCKS.register("oak_bench", OakBench::new);
    public static final RegistryObject<Block> OAK_CHAIR = BLOCKS.register("oak_chair", OakChair::new);
    public static final RegistryObject<Block> OAK_STOOL = BLOCKS.register("oak_stool", OakStool::new);
    public static final RegistryObject<Block> OAK_WOOD_CHAIR = BLOCKS.register("oak_wood_chair", OakWoodChair::new);
    public static final RegistryObject<Block> OAK_STRIPPED_CHAIR = BLOCKS.register("oak_stripped_chair", OakStrippedChair::new);
    public static final RegistryObject<Block> OAK_PLANK_HORIZONTAL = BLOCKS.register("oak_plank_horizontal", OakPlankHorizontal::new);
    public static final RegistryObject<Block> OAK_PLANK_VERTICAL = BLOCKS.register("oak_plank_vertical", OakPlankVertical::new);
    public static final RegistryObject<Block> OAK_PLANK = BLOCKS.register("oak_plank", OakPlank::new);
    public static final RegistryObject<Block> OAK_TREE = BLOCKS.register("oak_tree", OakTree::new);
    public static final RegistryObject<Block> SCARE_CROW = BLOCKS.register("scare_crow", ScareCrow::new);
    public static final RegistryObject<Block> OAK_DEAD_TREE = BLOCKS.register("oak_dead_tree", OakDeadTree::new);
    public static final RegistryObject<Block> FROG = BLOCKS.register("frog", Frog::new);
    public static final RegistryObject<Block> DUNGEON_CAGE_WITH_BONE = BLOCKS.register("dungeon_cage_with_bone", DungeonCageWithBone::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_WITH_BONE = BLOCKS.register("dungeon_wood_chair_with_bone", DungeonWoodChairWithBone::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_SWORD_AND_BONE = BLOCKS.register("dungeon_decorate_sword_and_bone", DungeonDecorateSwordAndBone::new);


    // Обычные блоки предметы
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_GOLDBARS_WITH_COIN_ITEM = ITEMS.register("dungeon_decorate_goldbars_with_coin",
            () -> new BlockItem(DUNGEON_DECORATE_GOLDBARS_WITH_COIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_TORCH_ITEM = ITEMS.register("dungeon_torch",
            () -> new BlockItem(DUNGEON_TORCH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_PLANT_ITEM = ITEMS.register("oak_plant",
            () -> new BlockItem(OAK_PLANT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_BENCH_ITEM = ITEMS.register("oak_bench",
            () -> new BlockItem(OAK_BENCH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_CHAIR_ITEM = ITEMS.register("oak_chair",
            () -> new BlockItem(OAK_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCARE_CROW_ITEM = ITEMS.register("scare_crow",
            () -> new BlockItem(SCARE_CROW.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> FROG_ITEM = ITEMS.register("frog",
            () -> new BlockItem(FROG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_TREE_ITEM = ITEMS.register("oak_tree",
            () -> new BlockItem(OAK_TREE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_DEAD_TREE_ITEM = ITEMS.register("oak_dead_tree",
            () -> new BlockItem(OAK_DEAD_TREE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_STOOL_ITEM = ITEMS.register("oak_stool",
            () -> new BlockItem(OAK_STOOL.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_STRIPPED_CHAIR_ITEM = ITEMS.register("oak_stripped_chair",
            () -> new BlockItem(OAK_STRIPPED_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_WOOD_CHAIR_ITEM = ITEMS.register("oak_wood_chair",
            () -> new BlockItem(OAK_WOOD_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_PLANK_HORIZONTAL_ITEM = ITEMS.register("oak_plank_horizontal",
            () -> new BlockItem(OAK_PLANK_HORIZONTAL.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_PLANK_VERTICAL_ITEM = ITEMS.register("oak_plank_vertical",
            () -> new BlockItem(OAK_PLANK_VERTICAL.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_LOG_ITEM = ITEMS.register("oak_log",
            () -> new BlockItem(OAK_LOG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OAK_PLANK_ITEM = ITEMS.register("oak_plank",
            () -> new BlockItem(OAK_PLANK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_CAGE_ITEM = ITEMS.register("dungeon_cage",
            () -> new BlockItem(DUNGEON_CAGE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_CAGE_WITH_BONE_ITEM = ITEMS.register("dungeon_cage_with_bone",
            () -> new BlockItem(DUNGEON_CAGE_WITH_BONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_WITH_BONE_ITEM = ITEMS.register("dungeon_wood_chair_with_bone",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR_WITH_BONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_BARREL_ITEM = ITEMS.register("dungeon_wood_barrel",
            () -> new BlockItem(DUNGEON_WOOD_BARREL.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_BOX_ITEM = ITEMS.register("dungeon_wood_box",
            () -> new BlockItem(DUNGEON_WOOD_BOX.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WEAPON_STAND_ITEM = ITEMS.register("dungeon_weapon_stand",
            () -> new BlockItem(DUNGEON_WEAPON_STAND.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_COINS_ITEM = ITEMS.register("dungeon_decorate_coins",
            () -> new BlockItem(DUNGEON_DECORATE_COINS.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_GOLDBAR_ITEM = ITEMS.register("dungeon_decorate_goldbar",
            () -> new BlockItem(DUNGEON_DECORATE_GOLDBAR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_ITEM = ITEMS.register("dungeon_wood_chair",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_VASE_ITEM = ITEMS.register("dungeon_decorate_vase",
            () -> new BlockItem(DUNGEON_DECORATE_VASE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_GOLDBARS_ITEM = ITEMS.register("dungeon_decorate_goldbars",
            () -> new BlockItem(DUNGEON_DECORATE_GOLDBARS.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_SWORD_AND_BONE_ITEM = ITEMS.register("dungeon_decorate_sword_and_bone",
            () -> new BlockItem(DUNGEON_DECORATE_SWORD_AND_BONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_DECORATE_HEADS_ITEM = ITEMS.register("dungeon_decorate_heads",
            () -> new BlockItem(DUNGEON_DECORATE_HEADS.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BIRCH_HANGING_SIGN_ITEM = ITEMS.register("birch_hanging_sign",
            () -> new BlockItem(BIRCH_HANGING_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DARK_OAK_HANGING_SIGN_ITEM = ITEMS.register("dark_oak_hanging_sign",
            () -> new BlockItem(DARK_OAK_HANGING_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> WARPED_HANGING_SIGN_ITEM = ITEMS.register("warped_hanging_sign",
            () -> new BlockItem(WARPED_HANGING_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CRIMSON_HANGING_SIGN_ITEM = ITEMS.register("crimson_hanging_sign",
            () -> new BlockItem(CRIMSON_HANGING_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DECORATED_POT_ITEM = ITEMS.register("decorated_pot",
            () -> new BlockItem(DECORATED_POT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    public static final RegistryObject<BlockItem> COPPER_BLOCK_ITEM = ITEMS.register("copper_block",
            () -> new BlockItem(COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> EXPOSED_COPPER_BLOCK_ITEM = ITEMS.register("exposed_copper_block",
            () -> new BlockItem(EXPOSED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> WEATHERED_COPPER_BLOCK_ITEM = ITEMS.register("weathered_copper_block",
            () -> new BlockItem(WEATHERED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OXIDIZED_COPPER_BLOCK_ITEM = ITEMS.register("oxidized_copper_block",
            () -> new BlockItem(OXIDIZED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_COPPER_BLOCK_ITEM = ITEMS.register("cut_copper_block",
            () -> new BlockItem(CUT_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_EXPOSED_COPPER_BLOCK_ITEM = ITEMS.register("cut_exposed_copper_block",
            () -> new BlockItem(CUT_EXPOSED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_WEATHERED_COPPER_BLOCK_ITEM = ITEMS.register("cut_weathered_copper_block",
            () -> new BlockItem(CUT_WEATHERED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_OXIDIZED_COPPER_BLOCK_ITEM = ITEMS.register("cut_oxidized_copper_block",
            () -> new BlockItem(CUT_OXIDIZED_COPPER_BLOCK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));


    // Abyss
    public static final RegistryObject<Block> TANTRA_PLANKS = registerBlock("tantra_planks",
            () -> new Block(
                    Block.Properties.of(Material.WOOD)
                            .strength(1F, 3.0F)));
    public static final RegistryObject<Block> JUNGLE_PLANKS = registerBlock("jungle_planks",
            () -> new Block(
                    Block.Properties.of(Material.WOOD)
                            .strength(1F, 3.0F)));
    public static final RegistryObject<Block> FROZEN_PLANKS = registerBlock("frozen_planks",
            () -> new Block(
                    Block.Properties.of(Material.WOOD)
                            .strength(1F, 3.0F)));
    public static final RegistryObject<Block> TANTRA_SLAB = registerBlock("tantra_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> JUNGLE_SLAB = registerBlock("jungle_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> FROZEN_SLAB = registerBlock("frozen_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> TANTRA_STAIRS = registerBlock("tantra_stairs",
            () -> new StairsBlock(() -> COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> JUNGLE_STAIRS = registerBlock("jungle_stairs",
            () -> new StairsBlock(() -> COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> FROZEN_STAIRS = registerBlock("frozen_stairs",
            () -> new StairsBlock(() -> COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.WOOD)
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> TANTRA_TRAPDOOR = registerBlock("tantra_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.WOOD)
                            .noOcclusion()
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> JUNGLE_TRAPDOOR = registerBlock("jungle_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.WOOD)
                            .noOcclusion()
                            .strength(1.0F, 3.0F)));
    public static final RegistryObject<Block> FROZEN_TRAPDOOR = registerBlock("frozen_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.WOOD)
                            .noOcclusion()
                            .strength(1.0F, 3.0F)));
    // Растения без класса
    public static final RegistryObject<Block> MOSS_BLOCK = registerBlock("moss_block",
            () -> new Block(
                    Block.Properties.of(Material.DIRT)
                            .strength(0.5F, 3.0F)));

    public static final RegistryObject<Block> AZALEA_BLOCK = registerBlock("azalea_block",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.5F, 3.0F)
                            .noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_AZALEA_BLOCK = registerBlock("flowering_azalea_block",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.5F, 3.0F)
                            .noOcclusion()));
    public static final RegistryObject<Block> AZALEA_LEAVES = registerBlock("azalea_leaves",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.5F, 3.0F)
                            .noOcclusion()));
    public static final RegistryObject<Block> FLOWERING_AZALEA_LEAVES = registerBlock("flowering_azalea_leaves",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.5F, 3.0F)
                            .noOcclusion()));
    public static final RegistryObject<Block> MOSS_CARPET = registerBlock("moss_carpet",
            () -> new CarpetBlock(DyeColor.GREEN,
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)));
    public static final RegistryObject<Block> HANGING_ROOTS = registerBlock("hanging_roots",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)
                            .noOcclusion()
                            .noCollission()));
    public static final RegistryObject<Block> CAVE_VINES = registerBlock("cave_vines",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)
                            .noOcclusion()
                            .noCollission()));
    public static final RegistryObject<Block> CAVE_VINES_BERRIES = registerBlock("cave_vines_berries",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)
                            .noOcclusion()
                            .noCollission()));
    public static final RegistryObject<Block> CAVE_VINES_PLANT = registerBlock("cave_vines_plant",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)
                            .noOcclusion()
                            .noCollission()));
    public static final RegistryObject<Block> CAVE_VINES_PLANT_BERRIES = registerBlock("cave_vines_plant_berries",
            () -> new Block(
                    Block.Properties.of(Material.LEAVES)
                            .strength(0.1F, 3.0F)
                            .noOcclusion()
                            .noCollission()));


    // Растения

    public static final RegistryObject<Block> BIG_DRIPLEAF = BLOCKS.register("big_dripleaf", BigDripLeaf::new);
    public static final RegistryObject<Block> SMALL_DRIPLEAF_TOP = BLOCKS.register("small_dripleaf_top", SmallDripleafTop::new);
    public static final RegistryObject<Block> SMALL_DRIPLEAF_BOTTOM = BLOCKS.register("small_dripleaf_bottom", SmallDripleafBottom::new);
    public static final RegistryObject<Block> BIG_DRIPLEAF_STEM = BLOCKS.register("big_dripleaf_stem", BigDripLeafStem::new);



    // Растения предметы

    public static final RegistryObject<BlockItem> BIG_DRIPLEAF_ITEM = ITEMS.register("big_dripleaf",
            () -> new BlockItem(BIG_DRIPLEAF.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SMALL_DRIPLEAF_TOP_ITEM = ITEMS.register("small_dripleaf_top",
            () -> new BlockItem(SMALL_DRIPLEAF_TOP.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SMALL_DRIPLEAF_BOTTOM_ITEM = ITEMS.register("small_dripleaf_bottom",
            () -> new BlockItem(SMALL_DRIPLEAF_BOTTOM.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BIG_DRIPLEAF_STEM_ITEM = ITEMS.register("big_dripleaf_stem",
            () -> new BlockItem(BIG_DRIPLEAF_STEM.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    // Блоки света
    public static final RegistryObject<Block> LIGHT_BLOCK08 = BLOCKS.register("light_block08", LightBlock08::new);
    public static final RegistryObject<Block> LIGHT_BLOCK15 = BLOCKS.register("light_block15", LightBlock15::new);

    // Блоки света предметы
    public static final RegistryObject<BlockItem> LIGHT_BLOCK08_ITEM = ITEMS.register("light_block08",
            () -> new BlockItem(LIGHT_BLOCK08.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> LIGHT_BLOCK15_ITEM = ITEMS.register("light_block15",
            () -> new BlockItem(LIGHT_BLOCK15.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    // Ступеньки
    public static final RegistryObject<Block> COPPER_STAIRS = registerBlock("copper_stairs",
            () -> new StairsBlock(() -> COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_STAIRS = registerBlock("exposed_copper_stairs",
            () -> new StairsBlock(() -> EXPOSED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WEATHERED_COPPER_STAIRS = registerBlock("weathered_copper_stairs",
            () -> new StairsBlock(() -> WEATHERED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_STAIRS = registerBlock("oxidized_copper_stairs",
            () -> new StairsBlock(() -> OXIDIZED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_COPPER_STAIRS = registerBlock("cut_copper_stairs",
            () -> new StairsBlock(() -> CUT_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_STAIRS = registerBlock("cut_exposed_copper_stairs",
            () -> new StairsBlock(() -> CUT_EXPOSED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_STAIRS = registerBlock("cut_weathered_copper_stairs",
            () -> new StairsBlock(() -> CUT_WEATHERED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_STAIRS = registerBlock("cut_oxidized_copper_stairs",
            () -> new StairsBlock(() -> CUT_OXIDIZED_COPPER_BLOCK.get().defaultBlockState(),
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    // Заборы
    public static final RegistryObject<Block> COPPER_FENCE = registerBlock("copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_FENCE = registerBlock("exposed_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WEATHERED_COPPER_FENCE = registerBlock("weathered_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_FENCE = registerBlock("oxidized_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_COPPER_FENCE = registerBlock("cut_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_FENCE = registerBlock("cut_exposed_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_FENCE = registerBlock("cut_weathered_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_FENCE = registerBlock("cut_oxidized_copper_fence",
            () -> new FenceBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    // Калитки
    public static final RegistryObject<Block> COPPER_FENCE_GATE = registerBlock("copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_FENCE_GATE = registerBlock("exposed_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WEATHERED_COPPER_FENCE_GATE = registerBlock("weathered_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_FENCE_GATE = registerBlock("oxidized_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_COPPER_FENCE_GATE = registerBlock("cut_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_FENCE_GATE = registerBlock("cut_exposed_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_FENCE_GATE = registerBlock("cut_weathered_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_FENCE_GATE = registerBlock("cut_oxidized_copper_fence_gate",
            () -> new FenceGateBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));

    // Двери
    public static final RegistryObject<Block> COPPER_DOOR = registerBlock("copper_door",
            () -> new DoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_DOOR = registerBlock("exposed_copper_door",
            () -> new DoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> WEATHERED_COPPER_DOOR = registerBlock("weathered_copper_door",
            () -> new DoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));

    public static final RegistryObject<Block> OXIDIZED_COPPER_DOOR = registerBlock("oxidized_copper_door",
            () -> new DoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));



    // Люки
    public static final RegistryObject<Block> COPPER_TRAPDOOR = registerBlock("copper_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_TRAPDOOR = registerBlock("exposed_copper_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WEATHERED_COPPER_TRAPDOOR = registerBlock("weathered_copper_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_TRAPDOOR = registerBlock("oxidized_copper_trapdoor",
            () -> new TrapDoorBlock(
                    Block.Properties.of(Material.STONE)
                            .noOcclusion()
                            .strength(2.0F, 3.0F)));


    // Полу-блоки
    public static final RegistryObject<Block> COPPER_SLAB = registerBlock("copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> EXPOSED_COPPER_SLAB = registerBlock("exposed_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> WEATHERED_COPPER_SLAB = registerBlock("weathered_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> OXIDIZED_COPPER_SLAB = registerBlock("oxidized_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_COPPER_SLAB = registerBlock("cut_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_SLAB = registerBlock("cut_exposed_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_SLAB = registerBlock("cut_weathered_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_SLAB = registerBlock("cut_oxidized_copper_slab",
            () -> new SlabBlock(
                    Block.Properties.of(Material.METAL)
                            .strength(2.0F, 3.0F)));
    // Вертикальные полу-блоки
    public static final RegistryObject<Block> COPPER_VERTICAL_SLAB = BLOCKS.register("copper_vertical_slab", CopperVerticalSlab::new);
    public static final RegistryObject<Block> EXPOSED_COPPER_VERTICAL_SLAB = BLOCKS.register("exposed_copper_vertical_slab", ExposedCopperVerticalSlab::new);
    public static final RegistryObject<Block> WEATHERED_COPPER_VERTICAL_SLAB = BLOCKS.register("weathered_copper_vertical_slab", WeatheredCopperVerticalSlab::new);
    public static final RegistryObject<Block> OXIDIZED_COPPER_VERTICAL_SLAB = BLOCKS.register("oxidized_copper_vertical_slab", OxidizedCopperVerticalSlab::new);
    public static final RegistryObject<Block> CUT_COPPER_VERTICAL_SLAB = BLOCKS.register("cut_copper_vertical_slab", CutCopperVerticalSlab::new);
    public static final RegistryObject<Block> CUT_EXPOSED_COPPER_VERTICAL_SLAB = BLOCKS.register("cut_exposed_copper_vertical_slab", CutExposedCopperVerticalSlab::new);
    public static final RegistryObject<Block> CUT_WEATHERED_COPPER_VERTICAL_SLAB = BLOCKS.register("cut_weathered_copper_vertical_slab", CutWeatheredCopperVerticalSlab::new);
    public static final RegistryObject<Block> CUT_OXIDIZED_COPPER_VERTICAL_SLAB = BLOCKS.register("cut_oxidized_copper_vertical_slab", CutOxidizedCopperVerticalSlab::new);

    // Вертикальные полу-блоки предметы
    public static final RegistryObject<BlockItem> COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("copper_vertical_slab",
            () -> new BlockItem(COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> EXPOSED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("exposed_copper_vertical_slab",
            () -> new BlockItem(EXPOSED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> WEATHERED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("weathered_copper_vertical_slab",
            () -> new BlockItem(WEATHERED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OXIDIZED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("oxidized_copper_vertical_slab",
            () -> new BlockItem(OXIDIZED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("cut_copper_vertical_slab",
            () -> new BlockItem(CUT_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_EXPOSED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("cut_exposed_copper_vertical_slab",
            () -> new BlockItem(CUT_EXPOSED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_WEATHERED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("cut_weathered_copper_vertical_slab",
            () -> new BlockItem(CUT_WEATHERED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CUT_OXIDIZED_COPPER_VERTICAL_SLAB_ITEM = ITEMS.register("cut_oxidized_copper_vertical_slab",
            () -> new BlockItem(CUT_OXIDIZED_COPPER_VERTICAL_SLAB.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));

    // Блоки использующие Bounding
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_LONG = BLOCKS.register("dungeon_wood_chair_long", DungeonWoodChairLong::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_THRONE = BLOCKS.register("dungeon_wood_throne", DungeonWoodThrone::new);
    public static final RegistryObject<Block> DUNGEON_FLAG = BLOCKS.register("dungeon_flag", DungeonFlag::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON = BLOCKS.register("dungeon_skeleton", DungeonSkeleton::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON_SLEEP = BLOCKS.register("dungeon_skeleton_sleep", DungeonSkeletonSleep::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON_HEAD = BLOCKS.register("dungeon_skeleton_head", DungeonSkeletonHead::new);
    public static final RegistryObject<Block> DUNGEON_HANG_FLAG = BLOCKS.register("dungeon_hang_flag", DungeonHangFlag::new);

    // Блоки предметы использующие Bounding
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_LONG_ITEM = ITEMS.register("dungeon_wood_chair_long",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR_LONG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_WOOD_THRONE_ITEM = ITEMS.register("dungeon_wood_throne",
            () -> new BlockItem(DUNGEON_WOOD_THRONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_SKELETON_HEAD_ITEM = ITEMS.register("dungeon_skeleton_head",
            () -> new BlockItem(DUNGEON_SKELETON_HEAD.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_SKELETON_SLEEP_ITEM = ITEMS.register("dungeon_skeleton_sleep",
            () -> new BlockItem(DUNGEON_SKELETON_SLEEP.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_FLAG_ITEM = ITEMS.register("dungeon_flag",
            () -> new BlockItem(DUNGEON_FLAG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> DUNGEON_SKELETON_ITEM = ITEMS.register("dungeon_skeleton",
            () -> new BlockItem(DUNGEON_SKELETON.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
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
