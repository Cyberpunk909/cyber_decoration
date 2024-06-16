package com.cyber.punk.util;

import com.cyber.punk.bounding_block.BoundingBlock;
import com.cyber.punk.custom_block.city_streets.*;
import com.cyber.punk.custom_block.dungeon_decoration.*;
import com.cyber.punk.custom_block.office_decoration.*;
import com.cyber.punk.custom_block.sci_fi_decoration.*;
import com.cyber.punk.custom_block.summer_decoration.*;
import com.cyber.punk.just_block.city_streets.*;
import com.cyber.punk.just_block.dungeon_decoration.*;
import com.cyber.punk.just_block.office_decoration.*;
import com.cyber.punk.just_block.sci_fi_decoration.*;
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

    // Блоки

    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_LONG = BLOCKS.register("dungeon_wood_chair_long", DungeonWoodChairLong::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_THRONE = BLOCKS.register("dungeon_wood_throne", DungeonWoodThrone::new);
    public static final RegistryObject<Block> DUNGEON_FLAG = BLOCKS.register("dungeon_flag", DungeonFlag::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON = BLOCKS.register("dungeon_skeleton", DungeonSkeleton::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON_SLEEP = BLOCKS.register("dungeon_skeleton_sleep", DungeonSkeletonSleep::new);
    public static final RegistryObject<Block> DUNGEON_SKELETON_HEAD = BLOCKS.register("dungeon_skeleton_head", DungeonSkeletonHead::new);
    public static final RegistryObject<Block> DUNGEON_HANG_FLAG = BLOCKS.register("dungeon_hang_flag", DungeonHangFlag::new);
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
    public static final RegistryObject<Block> GRAFFITI = BLOCKS.register("graffiti", Graffiti::new);
    public static final RegistryObject<Block> MONITOR = BLOCKS.register("monitor", Monitor::new);
    public static final RegistryObject<Block> SCI_FI_PLANT = BLOCKS.register("sci_fi_plant", SciFiPlant::new);
    public static final RegistryObject<Block> SCI_FI_TV = BLOCKS.register("sci_fi_tv", SciFiTV::new);
    public static final RegistryObject<Block> SCI_FI_LAMP = BLOCKS.register("sci_fi_lamp", SciFiLamp::new);
    public static final RegistryObject<Block> SCI_FI_WALL_LAMP = BLOCKS.register("sci_fi_wall_lamp", SciFiWallLamp::new);
    public static final RegistryObject<Block> SCI_FI_RADIO = BLOCKS.register("sci_fi_radio", SciFiRadio::new);
    public static final RegistryObject<Block> SCI_FI_TABLE = BLOCKS.register("sci_fi_table", SciFiTable::new);
    public static final RegistryObject<Block> SCI_FI_TABLET = BLOCKS.register("sci_fi_tablet", SciFiTablet::new);
    public static final RegistryObject<Block> SCI_FI_WEAPON = BLOCKS.register("sci_fi_weapon", SciFiWeapon::new);
    public static final RegistryObject<Block> SCI_FI_BED = BLOCKS.register("sci_fi_bed", SciFiBed::new);
    public static final RegistryObject<Block> SCI_FI_BENCH = BLOCKS.register("sci_fi_bench", SciFiBench::new);
    public static final RegistryObject<Block> SCI_FI_CC_TV = BLOCKS.register("sci_fi_cc_tv", SciFiCCTV::new);
    public static final RegistryObject<Block> SCI_FI_BIN = BLOCKS.register("sci_fi_bin", SciFiBin::new);
    public static final RegistryObject<Block> SCI_FI_CHAIR = BLOCKS.register("sci_fi_chair", SciFiChair::new);
    public static final RegistryObject<Block> SCI_FI_CHEST = BLOCKS.register("sci_fi_chest", SciFiChest::new);
    public static final RegistryObject<Block> SCI_FI_CRATE = BLOCKS.register("sci_fi_crate", SciFiCrate::new);
    public static final RegistryObject<Block> SCI_FI_GATE = BLOCKS.register("sci_fi_gate", SciFiGate::new);
    public static final RegistryObject<Block> SCI_FI_VERTICAL_SIGN_NIGHT = BLOCKS.register("sci_fi_vertical_sign_night", SciFiVerticalSignNight::new);
    public static final RegistryObject<Block> SCI_FI_SIGN_NIGHT = BLOCKS.register("sci_fi_sign_night", SciFiSignNight::new);
    public static final RegistryObject<Block> SCI_FI_SIGN_SUN = BLOCKS.register("sci_fi_sign_sun", SciFiSignSun::new);
    public static final RegistryObject<Block> SCI_FI_BIG_TABLE = BLOCKS.register("sci_fi_big_table", SciFiBigTable::new);
    public static final RegistryObject<Block> SCI_FI_BIG_VERTICAL_TABLE = BLOCKS.register("sci_fi_big_vertical_table", SciFiBigVerticalTable::new);
    public static final RegistryObject<Block> SCI_FI_BIG_GLASS_TABLE = BLOCKS.register("sci_fi_big_glass_table", SciFiBigGlassTable::new);
    public static final RegistryObject<Block> SCI_FI_LAMP_PILLAR = BLOCKS.register("sci_fi_lamp_pillar", SciFiLampPillar::new);
    public static final RegistryObject<Block> SCI_FI_VERTICAL_CABLE = BLOCKS.register("sci_fi_vertical_cable", SciFiVerticalCable::new);
    public static final RegistryObject<Block> SCI_FI_HORIZONTAL_WIRE = BLOCKS.register("sci_fi_horizontal_wire", SciFiHorizontalWire::new);
    public static final RegistryObject<Block> SCI_FI_VERTICAL_WIRE = BLOCKS.register("sci_fi_vertical_wire", SciFiVerticalWire::new);
    public static final RegistryObject<Block> SCI_FI_TRASH = BLOCKS.register("sci_fi_trash", SciFiTrash::new);
    public static final RegistryObject<Block> SCI_FI_BARRIER = BLOCKS.register("sci_fi_barrier", SciFiBarrier::new);
    public static final RegistryObject<Block> SCI_FI_YELLOW_BARRIER = BLOCKS.register("sci_fi_yellow_barrier", SciFiYellowBarrier::new);
    public static final RegistryObject<Block> SCI_FI_WARNING_SIGN = BLOCKS.register("sci_fi_warning_sign", SciFiWarningSign::new);
    public static final RegistryObject<Block> SCI_FI_VARIOUS_TRASH = BLOCKS.register("sci_fi_various_trash", SciFiVariousTrash::new);
    public static final RegistryObject<Block> SCI_FI_LIGHT_PILLAR = BLOCKS.register("sci_fi_light_pillar", SciFiLightPillar::new);
    public static final RegistryObject<Block> SCI_FI_GENERATOR = BLOCKS.register("sci_fi_generator", SciFiGenerator::new);
    public static final RegistryObject<Block> SCI_FI_RED_CHAIR = BLOCKS.register("sci_fi_red_chair", SciFiRedChair::new);
    public static final RegistryObject<Block> SCI_FI_ORANGE_CHAIR = BLOCKS.register("sci_fi_orange_chair", SciFiOrangeChair::new);
    public static final RegistryObject<Block> SCI_FI_BLACK_CHAIR = BLOCKS.register("sci_fi_black_chair", SciFiBlackChair::new);
    public static final RegistryObject<Block> SCI_FI_STOOL = BLOCKS.register("sci_fi_stool", SciFiStool::new);
    public static final RegistryObject<Block> TRAFFIC_CONE = BLOCKS.register("traffic_cone", TrafficCone::new);
    public static final RegistryObject<Block> TELEPHONE_CABIN = BLOCKS.register("telephone_cabin", TelephoneCabin::new);
    public static final RegistryObject<Block> SCI_FI_BIG_BIN = BLOCKS.register("sci_fi_big_bin", SciFiBigBin::new);
    public static final RegistryObject<Block> SCI_FI_SMALL_BIN = BLOCKS.register("sci_fi_small_bin", SciFiSmallBin::new);
    public static final RegistryObject<Block> SODA_STORAGE = BLOCKS.register("soda_storage", SodaStorage::new);
    public static final RegistryObject<Block> TRAFFIC_LIGHT = BLOCKS.register("traffic_light", TrafficLight::new);
    public static final RegistryObject<Block> TRASH_CAN = BLOCKS.register("trash_can", TrashCan::new);
    public static final RegistryObject<Block> STREET_LIGHT_BIG = BLOCKS.register("street_light_big", StreetLightBig::new);
    public static final RegistryObject<Block> STREET_LIGHT_MODERN = BLOCKS.register("street_light_modern", StreetLightModern::new);
    public static final RegistryObject<Block> STREET_LIGHT_MODERN_DOUBLE = BLOCKS.register("street_light_modern_double", StreetLightModernDouble::new);
    public static final RegistryObject<Block> TRANSIT_FENCE = BLOCKS.register("transit_fence", TransitFence::new);
    public static final RegistryObject<Block> TRASH_CONTAINER = BLOCKS.register("trash_container", TrashContainer::new);
    public static final RegistryObject<Block> TRASH_CONTAINER_OPEN = BLOCKS.register("trash_container_open", TrashContainerOpen::new);
    public static final RegistryObject<Block> AIR_CONDITIONER = BLOCKS.register("air_conditioner", AirConditioner::new);
    public static final RegistryObject<Block> VEHICLE_BARRIER = BLOCKS.register("vehicle_barrier", VehicleBarrier::new);
    public static final RegistryObject<Block> ATM_MACHINE = BLOCKS.register("atm_machine", AtmMachine::new);
    public static final RegistryObject<Block> MAIL_BOX = BLOCKS.register("mail_box", MailBox::new);
    public static final RegistryObject<Block> NEWSPAPER_READ = BLOCKS.register("newspaper_read", NewspaperRead::new);
    public static final RegistryObject<Block> NEWSPAPER_STACK = BLOCKS.register("newspaper_stack", NewspaperStack::new);
    public static final RegistryObject<Block> NEWSPAPER_VENDING_MACHINE = BLOCKS.register("newspaper_vending_machine", NewspaperVendingMachine::new);
    public static final RegistryObject<Block> PIZZA_BOX = BLOCKS.register("pizza_box", PizzaBox::new);
    public static final RegistryObject<Block> PIZZA_BOX_02 = BLOCKS.register("pizza_box_02", PizzaBox02::new);
    public static final RegistryObject<Block> CITY_BENCH = BLOCKS.register("city_bench", CityBench::new);
    public static final RegistryObject<Block> BUS_SIGN = BLOCKS.register("bus_sign", BusSign::new);
    public static final RegistryObject<Block> BUS_STATION = BLOCKS.register("bus_station", BusStation::new);
    public static final RegistryObject<Block> RAT_BROWN = BLOCKS.register("rat_brown", RatBrown::new);
    public static final RegistryObject<Block> SECURITY_FENCE = BLOCKS.register("security_fence", SecurityFence::new);
    public static final RegistryObject<Block> SEWER_COVER_SMOKE = BLOCKS.register("sewer_cover_smoke", SewerCoverSmoke::new);
    public static final RegistryObject<Block> SMALL_LIGHT = BLOCKS.register("small_light", SmallLight::new);
    public static final RegistryObject<Block> SPRAY_CAN_01 = BLOCKS.register("spray_can_01", SprayCan01::new);
    public static final RegistryObject<Block> SPRAY_CAN_02 = BLOCKS.register("spray_can_02", SprayCan02::new);
    public static final RegistryObject<Block> SPRAY_CAN_03 = BLOCKS.register("spray_can_03", SprayCan03::new);
    public static final RegistryObject<Block> RAT_BLACK = BLOCKS.register("rat_black", RatBlack::new);
    public static final RegistryObject<Block> STREET_LIGHT = BLOCKS.register("street_light", StreetLight::new);
    public static final RegistryObject<Block> BOX_01 = BLOCKS.register("box_01", Box01::new);
    public static final RegistryObject<Block> BOX_02 = BLOCKS.register("box_02", Box02::new);
    public static final RegistryObject<Block> BOX_03 = BLOCKS.register("box_03", Box03::new);
    public static final RegistryObject<Block> BOX_04 = BLOCKS.register("box_04", Box04::new);
    public static final RegistryObject<Block> BOX_05 = BLOCKS.register("box_05", Box05::new);
    public static final RegistryObject<Block> BOX_06 = BLOCKS.register("box_06", Box06::new);
    public static final RegistryObject<Block> BOX_07 = BLOCKS.register("box_07", Box07::new);
    public static final RegistryObject<Block> GRAFFITI_01 = BLOCKS.register("graffiti_01", Graffiti01::new);
    public static final RegistryObject<Block> GRAFFITI_02 = BLOCKS.register("graffiti_02", Graffiti02::new);
    public static final RegistryObject<Block> GRAFFITI_03 = BLOCKS.register("graffiti_03", Graffiti03::new);
    public static final RegistryObject<Block> GRAFFITI_04 = BLOCKS.register("graffiti_04", Graffiti04::new);
    public static final RegistryObject<Block> GRAFFITI_05 = BLOCKS.register("graffiti_05", Graffiti05::new);
    public static final RegistryObject<Block> GRAFFITI_06 = BLOCKS.register("graffiti_06", Graffiti06::new);
    public static final RegistryObject<Block> FIRE_HYDRANT = BLOCKS.register("fire_hydrant", FireHydrant::new);
    public static final RegistryObject<Block> MAP_HOLOGRAM = BLOCKS.register("map_hologram", MapHologram::new);
    public static final RegistryObject<Block> PILE_FILES = BLOCKS.register("pile_files", PileFiles::new);
    public static final RegistryObject<Block> PILE_PAPER = BLOCKS.register("pile_paper", PilePaper::new);
    public static final RegistryObject<Block> OFFICE_SMALL_PRINTER = BLOCKS.register("office_small_printer", OfficeSmallPrinter::new);
    public static final RegistryObject<Block> OFFICE_SMALL_SOFA = BLOCKS.register("office_small_sofa", OfficeSmallSofa::new);
    public static final RegistryObject<Block> OFFICE_SHELF = BLOCKS.register("office_shelf", OfficeShelf::new);
    public static final RegistryObject<Block> OFFICE_SHORT_TONGUE = BLOCKS.register("office_short_tongue", OfficeShortTongue::new);
    public static final RegistryObject<Block> OFFICE_BIG_SOFA = BLOCKS.register("office_big_sofa", OfficeBigSofa::new);
    public static final RegistryObject<Block> OFFICE_TABLE = BLOCKS.register("office_table", OfficeTable::new);
    public static final RegistryObject<Block> OFFICE_BIG_TABLE = BLOCKS.register("office_big_table", OfficeBigTable::new);
    public static final RegistryObject<Block> OFFICE_SMALL_TABLE = BLOCKS.register("office_small_table", OfficeSmallTable::new);
    public static final RegistryObject<Block> OFFICE_TV = BLOCKS.register("office_tv", OfficeTV::new);
    public static final RegistryObject<Block> OFFICE_WATER_DISPENSER = BLOCKS.register("office_water_dispenser", OfficeWaterDispenser::new);
    public static final RegistryObject<Block> OFFICE_BIG_PRINTER = BLOCKS.register("office_big_printer", OfficeBigPrinter::new);
    public static final RegistryObject<Block> OFFICE_WHITE_BOARD = BLOCKS.register("office_white_board", OfficeWhiteBoard::new);
    public static final RegistryObject<Block> OFFICE_BIN = BLOCKS.register("office_bin", OfficeBin::new);
    public static final RegistryObject<Block> OFFICE_BOARD = BLOCKS.register("office_board", OfficeBoard::new);
    public static final RegistryObject<Block> OFFICE_ARMCHAIR = BLOCKS.register("office_armchair", OfficeArmchair::new);
    public static final RegistryObject<Block> OFFICE_CHAIR = BLOCKS.register("office_chair", OfficeChair::new);
    public static final RegistryObject<Block> OFFICE_FILE_BOX = BLOCKS.register("office_file_box", OfficeFileBox::new);
    public static final RegistryObject<Block> OFFICE_LONG_DRAWER = BLOCKS.register("office_long_drawer", OfficeLongDrawer::new);
    public static final RegistryObject<Block> DUNGEON_CAGE_WITH_BONE = BLOCKS.register("dungeon_cage_with_bone", DungeonCageWithBone::new);
    public static final RegistryObject<Block> DUNGEON_WOOD_CHAIR_WITH_BONE = BLOCKS.register("dungeon_wood_chair_with_bone", DungeonWoodChairWithBone::new);
    public static final RegistryObject<Block> DUNGEON_DECORATE_SWORD_AND_BONE = BLOCKS.register("dungeon_decorate_sword_and_bone", DungeonDecorateSwordAndBone::new);


    // Блоки предметы

    public static final RegistryObject<BlockItem> DUNGEON_WOOD_CHAIR_LONG_ITEM = ITEMS.register("dungeon_wood_chair_long",
            () -> new BlockItem(DUNGEON_WOOD_CHAIR_LONG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_ITEM = ITEMS.register("graffiti",
            () -> new BlockItem(GRAFFITI.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRANSIT_FENCE_ITEM = ITEMS.register("transit_fence",
            () -> new BlockItem(TRANSIT_FENCE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> PILE_FILES_ITEM = ITEMS.register("pile_files",
            () -> new BlockItem(PILE_FILES.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> PILE_PAPER_ITEM = ITEMS.register("pile_paper",
            () -> new BlockItem(PILE_PAPER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_SMALL_PRINTER_ITEM = ITEMS.register("office_small_printer",
            () -> new BlockItem(OFFICE_SMALL_PRINTER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_BIG_PRINTER_ITEM = ITEMS.register("office_big_printer",
            () -> new BlockItem(OFFICE_BIG_PRINTER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_BIG_SOFA_ITEM = ITEMS.register("office_big_sofa",
            () -> new BlockItem(OFFICE_BIG_SOFA.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_SMALL_SOFA_ITEM = ITEMS.register("office_small_sofa",
            () -> new BlockItem(OFFICE_SMALL_SOFA.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRASH_CAN_ITEM = ITEMS.register("trash_can",
            () -> new BlockItem(TRASH_CAN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_SHELF_ITEM = ITEMS.register("office_shelf",
            () -> new BlockItem(OFFICE_SHELF.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_SHORT_TONGUE_ITEM = ITEMS.register("office_short_tongue",
            () -> new BlockItem(OFFICE_SHORT_TONGUE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_TABLE_ITEM = ITEMS.register("office_table",
            () -> new BlockItem(OFFICE_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_BIN_ITEM = ITEMS.register("office_bin",
            () -> new BlockItem(OFFICE_BIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_BOARD_ITEM = ITEMS.register("office_board",
            () -> new BlockItem(OFFICE_BOARD.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_BIG_TABLE_ITEM = ITEMS.register("office_big_table",
            () -> new BlockItem(OFFICE_BIG_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_SMALL_TABLE_ITEM = ITEMS.register("office_small_table",
            () -> new BlockItem(OFFICE_SMALL_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_TV_ITEM = ITEMS.register("office_tv",
            () -> new BlockItem(OFFICE_TV.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_WATER_DISPENSER_ITEM = ITEMS.register("office_water_dispenser",
            () -> new BlockItem(OFFICE_WATER_DISPENSER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_WHITE_BOARD_ITEM = ITEMS.register("office_white_board",
            () -> new BlockItem(OFFICE_WHITE_BOARD.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_ARMCHAIR_ITEM = ITEMS.register("office_armchair",
            () -> new BlockItem(OFFICE_ARMCHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_CHAIR_ITEM = ITEMS.register("office_chair",
            () -> new BlockItem(OFFICE_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_FILE_BOX_ITEM = ITEMS.register("office_file_box",
            () -> new BlockItem(OFFICE_FILE_BOX.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> OFFICE_LONG_DRAWER_ITEM = ITEMS.register("office_long_drawer",
            () -> new BlockItem(OFFICE_LONG_DRAWER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> ATM_MACHINE_ITEM = ITEMS.register("atm_machine",
            () -> new BlockItem(ATM_MACHINE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> AIR_CONDITIONER_ITEM = ITEMS.register("air_conditioner",
            () -> new BlockItem(AIR_CONDITIONER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> CITY_BENCH_ITEM = ITEMS.register("city_bench",
            () -> new BlockItem(CITY_BENCH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> FIRE_HYDRANT_ITEM = ITEMS.register("fire_hydrant",
            () -> new BlockItem(FIRE_HYDRANT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BUS_STATION_ITEM = ITEMS.register("bus_station",
            () -> new BlockItem(BUS_STATION.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BUS_SIGN_ITEM = ITEMS.register("bus_sign",
            () -> new BlockItem(BUS_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> MAIL_BOX_ITEM = ITEMS.register("mail_box",
            () -> new BlockItem(MAIL_BOX.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> RAT_BLACK_ITEM = ITEMS.register("rat_black",
            () -> new BlockItem(RAT_BLACK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> RAT_BROWN_ITEM = ITEMS.register("rat_brown",
            () -> new BlockItem(RAT_BROWN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> NEWSPAPER_READ_ITEM = ITEMS.register("newspaper_read",
            () -> new BlockItem(NEWSPAPER_READ.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> NEWSPAPER_STACK_ITEM = ITEMS.register("newspaper_stack",
            () -> new BlockItem(NEWSPAPER_STACK.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> NEWSPAPER_VENDING_MACHINE_ITEM = ITEMS.register("newspaper_vending_machine",
            () -> new BlockItem(NEWSPAPER_VENDING_MACHINE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> PIZZA_BOX_ITEM = ITEMS.register("pizza_box",
            () -> new BlockItem(PIZZA_BOX.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SECURITY_FENCE_ITEM = ITEMS.register("security_fence",
            () -> new BlockItem(SECURITY_FENCE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SEWER_COVER_SMOKE_ITEM = ITEMS.register("sewer_cover_smoke",
            () -> new BlockItem(SEWER_COVER_SMOKE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SMALL_LIGHT_ITEM = ITEMS.register("small_light",
            () -> new BlockItem(SMALL_LIGHT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SPRAY_CAN_01_ITEM = ITEMS.register("spray_can_01",
            () -> new BlockItem(SPRAY_CAN_01.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SPRAY_CAN_02_ITEM = ITEMS.register("spray_can_02",
            () -> new BlockItem(SPRAY_CAN_02.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SPRAY_CAN_03_ITEM = ITEMS.register("spray_can_03",
            () -> new BlockItem(SPRAY_CAN_03.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> STREET_LIGHT_ITEM = ITEMS.register("street_light",
            () -> new BlockItem(STREET_LIGHT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> PIZZA_BOX_02_ITEM = ITEMS.register("pizza_box_02",
            () -> new BlockItem(PIZZA_BOX_02.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_01_ITEM = ITEMS.register("graffiti_01",
            () -> new BlockItem(GRAFFITI_01.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_02_ITEM = ITEMS.register("graffiti_02",
            () -> new BlockItem(GRAFFITI_02.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_03_ITEM = ITEMS.register("graffiti_03",
            () -> new BlockItem(GRAFFITI_03.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_04_ITEM = ITEMS.register("graffiti_04",
            () -> new BlockItem(GRAFFITI_04.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_05_ITEM = ITEMS.register("graffiti_05",
            () -> new BlockItem(GRAFFITI_05.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> GRAFFITI_06_ITEM = ITEMS.register("graffiti_06",
            () -> new BlockItem(GRAFFITI_06.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_01_ITEM = ITEMS.register("box_01",
            () -> new BlockItem(BOX_01.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_02_ITEM = ITEMS.register("box_02",
            () -> new BlockItem(BOX_02.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_03_ITEM = ITEMS.register("box_03",
            () -> new BlockItem(BOX_03.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_04_ITEM = ITEMS.register("box_04",
            () -> new BlockItem(BOX_04.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_05_ITEM = ITEMS.register("box_05",
            () -> new BlockItem(BOX_05.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_06_ITEM = ITEMS.register("box_06",
            () -> new BlockItem(BOX_06.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> BOX_07_ITEM = ITEMS.register("box_07",
            () -> new BlockItem(BOX_07.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> VEHICLE_BARRIER_ITEM = ITEMS.register("vehicle_barrier",
            () -> new BlockItem(VEHICLE_BARRIER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> STREET_LIGHT_MODERN_ITEM = ITEMS.register("street_light_modern",
            () -> new BlockItem(STREET_LIGHT_MODERN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> STREET_LIGHT_MODERN_DOUBLE_ITEM = ITEMS.register("street_light_modern_double",
            () -> new BlockItem(STREET_LIGHT_MODERN_DOUBLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> STREET_LIGHT_BIG_ITEM = ITEMS.register("street_light_big",
            () -> new BlockItem(STREET_LIGHT_BIG.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRASH_CONTAINER_ITEM = ITEMS.register("trash_container",
            () -> new BlockItem(TRASH_CONTAINER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRASH_CONTAINER_OPEN_ITEM = ITEMS.register("trash_container_open",
            () -> new BlockItem(TRASH_CONTAINER_OPEN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRAFFIC_CONE_ITEM = ITEMS.register("traffic_cone",
            () -> new BlockItem(TRAFFIC_CONE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TRAFFIC_LIGHT_ITEM = ITEMS.register("traffic_light",
            () -> new BlockItem(TRAFFIC_LIGHT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_PLANT_ITEM = ITEMS.register("sci_fi_plant",
            () -> new BlockItem(SCI_FI_PLANT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BLACK_CHAIR_ITEM = ITEMS.register("sci_fi_black_chair",
            () -> new BlockItem(SCI_FI_BLACK_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_ORANGE_CHAIR_ITEM = ITEMS.register("sci_fi_orange_chair",
            () -> new BlockItem(SCI_FI_ORANGE_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> TELEPHONE_CABIN_ITEM = ITEMS.register("telephone_cabin",
            () -> new BlockItem(TELEPHONE_CABIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_STOOL_ITEM = ITEMS.register("sci_fi_stool",
            () -> new BlockItem(SCI_FI_STOOL.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_SMALL_BIN_ITEM = ITEMS.register("sci_fi_small_bin",
            () -> new BlockItem(SCI_FI_SMALL_BIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BIG_BIN_ITEM = ITEMS.register("sci_fi_big_bin",
            () -> new BlockItem(SCI_FI_BIG_BIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BARRIER_ITEM = ITEMS.register("sci_fi_barrier",
            () -> new BlockItem(SCI_FI_BARRIER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_YELLOW_BARRIER_ITEM = ITEMS.register("sci_fi_yellow_barrier",
            () -> new BlockItem(SCI_FI_YELLOW_BARRIER.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_WARNING_SIGN_ITEM = ITEMS.register("sci_fi_warning_sign",
            () -> new BlockItem(SCI_FI_WARNING_SIGN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_VERTICAL_CABLE_ITEM = ITEMS.register("sci_fi_vertical_cable",
            () -> new BlockItem(SCI_FI_VERTICAL_CABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_HORIZONTAL_WIRE_ITEM = ITEMS.register("sci_fi_horizontal_wire",
            () -> new BlockItem(SCI_FI_HORIZONTAL_WIRE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_VERTICAL_WIRE_ITEM = ITEMS.register("sci_fi_vertical_wire",
            () -> new BlockItem(SCI_FI_VERTICAL_WIRE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_TRASH_ITEM = ITEMS.register("sci_fi_trash",
            () -> new BlockItem(SCI_FI_TRASH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_VARIOUS_TRASH_ITEM = ITEMS.register("sci_fi_various_trash",
            () -> new BlockItem(SCI_FI_VARIOUS_TRASH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BIG_TABLE_ITEM = ITEMS.register("sci_fi_big_table",
            () -> new BlockItem(SCI_FI_BIG_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BIG_VERTICAL_TABLE_ITEM = ITEMS.register("sci_fi_big_vertical_table",
            () -> new BlockItem(SCI_FI_BIG_VERTICAL_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BIG_GLASS_TABLE_ITEM = ITEMS.register("sci_fi_big_glass_table",
            () -> new BlockItem(SCI_FI_BIG_GLASS_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_TV_ITEM = ITEMS.register("sci_fi_tv",
            () -> new BlockItem(SCI_FI_TV.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_LIGHT_PILLAR_ITEM = ITEMS.register("sci_fi_light_pillar",
            () -> new BlockItem(SCI_FI_LIGHT_PILLAR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_LAMP_PILLAR_ITEM = ITEMS.register("sci_fi_lamp_pillar",
            () -> new BlockItem(SCI_FI_LAMP_PILLAR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_CHEST_ITEM = ITEMS.register("sci_fi_chest",
            () -> new BlockItem(SCI_FI_CHEST.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_VERTICAL_SIGN_NIGHT_ITEM = ITEMS.register("sci_fi_vertical_sign_night",
            () -> new BlockItem(SCI_FI_VERTICAL_SIGN_NIGHT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_SIGN_NIGHT_ITEM = ITEMS.register("sci_fi_sign_night",
            () -> new BlockItem(SCI_FI_SIGN_NIGHT.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_SIGN_SUN_ITEM = ITEMS.register("sci_fi_sign_sun",
            () -> new BlockItem(SCI_FI_SIGN_SUN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_GENERATOR_ITEM = ITEMS.register("sci_fi_generator",
            () -> new BlockItem(SCI_FI_GENERATOR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_GATE_ITEM = ITEMS.register("sci_fi_gate",
            () -> new BlockItem(SCI_FI_GATE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_CRATE_ITEM = ITEMS.register("sci_fi_crate",
            () -> new BlockItem(SCI_FI_CRATE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_CC_TV_ITEM = ITEMS.register("sci_fi_cc_tv",
            () -> new BlockItem(SCI_FI_CC_TV.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BIN_ITEM = ITEMS.register("sci_fi_bin",
            () -> new BlockItem(SCI_FI_BIN.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_CHAIR_ITEM = ITEMS.register("sci_fi_chair",
            () -> new BlockItem(SCI_FI_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_RED_CHAIR_ITEM = ITEMS.register("sci_fi_red_chair",
            () -> new BlockItem(SCI_FI_RED_CHAIR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BED_ITEM = ITEMS.register("sci_fi_bed",
            () -> new BlockItem(SCI_FI_BED.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_BENCH_ITEM = ITEMS.register("sci_fi_bench",
            () -> new BlockItem(SCI_FI_BENCH.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_LAMP_ITEM = ITEMS.register("sci_fi_lamp",
            () -> new BlockItem(SCI_FI_LAMP.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_WEAPON_ITEM = ITEMS.register("sci_fi_weapon",
            () -> new BlockItem(SCI_FI_WEAPON.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_WALL_LAMP_ITEM = ITEMS.register("sci_fi_wall_lamp",
            () -> new BlockItem(SCI_FI_WALL_LAMP.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_RADIO_ITEM = ITEMS.register("sci_fi_radio",
            () -> new BlockItem(SCI_FI_RADIO.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_TABLE_ITEM = ITEMS.register("sci_fi_table",
            () -> new BlockItem(SCI_FI_TABLE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SCI_FI_TABLET_ITEM = ITEMS.register("sci_fi_tablet",
            () -> new BlockItem(SCI_FI_TABLET.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> SODA_STORAGE_ITEM = ITEMS.register("soda_storage",
            () -> new BlockItem(SODA_STORAGE.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> MAP_HOLOGRAM_ITEM = ITEMS.register("map_hologram",
            () -> new BlockItem(MAP_HOLOGRAM.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
    public static final RegistryObject<BlockItem> MONITOR_ITEM = ITEMS.register("monitor",
            () -> new BlockItem(MONITOR.get(), new Item.Properties().tab(Cyber_Group.CYBER_GROUP)));
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
