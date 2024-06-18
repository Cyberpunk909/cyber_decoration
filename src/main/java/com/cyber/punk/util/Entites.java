package com.cyber.punk.util;

import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.entity.city_streets.*;
import com.cyber.punk.entity.dungeon_decoration.*;
import com.cyber.punk.entity.hospital.*;
import com.cyber.punk.entity.office_decoration.*;
import com.cyber.punk.entity.sci_fi_decoration.*;
import com.cyber.punk.entity.summer_decoration.*;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class Entites {
    public static final DeferredRegister<TileEntityType<?>> REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Cyber.MOD_ID);
    public static final RegistryObject<TileEntityType<BoundingBlockEntity>> BOUNDING_BLOCK = register(Registry.BOUNDING_BLOCK, BoundingBlockEntity::new);
    public static final RegistryObject<TileEntityType<DungeonWoodChairLongEntity>> DUNGEON_WOOD_CHAIR_LONG = register(Registry.DUNGEON_WOOD_CHAIR_LONG, DungeonWoodChairLongEntity::new);
    public static final RegistryObject<TileEntityType<DungeonWoodThroneEntity>> DUNGEON_WOOD_THRONE = register(Registry.DUNGEON_WOOD_THRONE, DungeonWoodThroneEntity::new);
    public static final RegistryObject<TileEntityType<DungeonFlagEntity>> DUNGEON_FLAG = register(Registry.DUNGEON_FLAG, DungeonFlagEntity::new);
    public static final RegistryObject<TileEntityType<OakPlankEntity>> OAK_PLANK = register(Registry.OAK_PLANK, OakPlankEntity::new);
    public static final RegistryObject<TileEntityType<OakBenchEntity>> OAK_BENCH = register(Registry.OAK_BENCH, OakBenchEntity::new);
    public static final RegistryObject<TileEntityType<OakChairEntity>> OAK_CHAIR = register(Registry.OAK_CHAIR, OakChairEntity::new);
    public static final RegistryObject<TileEntityType<OakTreeEntity>> OAK_TREE = register(Registry.OAK_TREE, OakTreeEntity::new);
    public static final RegistryObject<TileEntityType<FrogEntity>> FROG = register(Registry.FROG, FrogEntity::new);
    public static final RegistryObject<TileEntityType<GraffitiEntity>> GRAFFITI = register(Registry.GRAFFITI, GraffitiEntity::new);
    public static final RegistryObject<TileEntityType<MapHologramEntity>> MAP_HOLOGRAM = register(Registry.MAP_HOLOGRAM, MapHologramEntity::new);
    public static final RegistryObject<TileEntityType<MonitorEntity>> MONITOR = register(Registry.MONITOR, MonitorEntity::new);
    public static final RegistryObject<TileEntityType<SciFiPlantEntity>> SCI_FI_PLANT = register(Registry.SCI_FI_PLANT, SciFiPlantEntity::new);
    public static final RegistryObject<TileEntityType<SodaStorageEntity>> SODA_STORAGE = register(Registry.SODA_STORAGE, SodaStorageEntity::new);
    public static final RegistryObject<TileEntityType<SciFiWeaponEntity>> SCI_FI_WEAPON = register(Registry.SCI_FI_WEAPON, SciFiWeaponEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBedEntity>> SCI_FI_BED = register(Registry.SCI_FI_BED, SciFiBedEntity::new);
    public static final RegistryObject<TileEntityType<AtmMachineEntity>> ATM_MACHINE = register(Registry.ATM_MACHINE, AtmMachineEntity::new);
    public static final RegistryObject<TileEntityType<HospitalAmbulanceBedEntity>> HOSPITAL_AMBULANCE_BED = register(Registry.HOSPITAL_AMBULANCE_BED, HospitalAmbulanceBedEntity::new);
    public static final RegistryObject<TileEntityType<HospitalBedEntity>> HOSPITAL_BED = register(Registry.HOSPITAL_BED, HospitalBedEntity::new);
    public static final RegistryObject<TileEntityType<HospitalBedsideTableEntity>> HOSPITAL_BEDSIDE_TABLE = register(Registry.HOSPITAL_BEDSIDE_TABLE, HospitalBedsideTableEntity::new);
    public static final RegistryObject<TileEntityType<HospitalBenchEntity>> HOSPITAL_BENCH = register(Registry.HOSPITAL_BENCH, HospitalBenchEntity::new);
    public static final RegistryObject<TileEntityType<HospitalBlueBedEntity>> HOSPITAL_BLUE_BED = register(Registry.HOSPITAL_BLUE_BED, HospitalBlueBedEntity::new);
    public static final RegistryObject<TileEntityType<HospitalChairEntity>> HOSPITAL_CHAIR = register(Registry.HOSPITAL_CHAIR, HospitalChairEntity::new);
    public static final RegistryObject<TileEntityType<HospitalCurtainEntity>> HOSPITAL_CURTAIN = register(Registry.HOSPITAL_CURTAIN, HospitalCurtainEntity::new);
    public static final RegistryObject<TileEntityType<HospitalFilingCabinetEntity>> HOSPITAL_FILING_CABINET = register(Registry.HOSPITAL_FILING_CABINET, HospitalFilingCabinetEntity::new);
    public static final RegistryObject<TileEntityType<HospitalLongCurtainEntity>> HOSPITAL_LONG_CURTAIN = register(Registry.HOSPITAL_LONG_CURTAIN, HospitalLongCurtainEntity::new);
    public static final RegistryObject<TileEntityType<HospitalRefrigeratorEntity>> HOSPITAL_REFRIGERATOR = register(Registry.HOSPITAL_REFRIGERATOR, HospitalRefrigeratorEntity::new);
    public static final RegistryObject<TileEntityType<HospitalStandEntity>> HOSPITAL_STAND = register(Registry.HOSPITAL_STAND, HospitalStandEntity::new);
    public static final RegistryObject<TileEntityType<HospitalSupplyCabinetEntity>> HOSPITAL_SUPPLY_CABINET = register(Registry.HOSPITAL_SUPPLY_CABINET, HospitalSupplyCabinetEntity::new);
    public static final RegistryObject<TileEntityType<HospitalThirdSofaEntity>> HOSPITAL_THIRD_SOFA = register(Registry.HOSPITAL_THIRD_SOFA, HospitalThirdSofaEntity::new);
    public static final RegistryObject<TileEntityType<HospitalWhiteBedEntity>> HOSPITAL_WHITE_BED = register(Registry.HOSPITAL_WHITE_BED, HospitalWhiteBedEntity::new);
    public static final RegistryObject<TileEntityType<HospitalWhiteChairEntity>> HOSPITAL_WHITE_CHAIR = register(Registry.HOSPITAL_WHITE_CHAIR, HospitalWhiteChairEntity::new);
    public static final RegistryObject<TileEntityType<Graffiti01Entity>> GRAFFITI_01 = register(Registry.GRAFFITI_01, Graffiti01Entity::new);
    public static final RegistryObject<TileEntityType<Graffiti02Entity>> GRAFFITI_02 = register(Registry.GRAFFITI_02, Graffiti02Entity::new);
    public static final RegistryObject<TileEntityType<Graffiti03Entity>> GRAFFITI_03 = register(Registry.GRAFFITI_03, Graffiti03Entity::new);
    public static final RegistryObject<TileEntityType<Graffiti04Entity>> GRAFFITI_04 = register(Registry.GRAFFITI_04, Graffiti04Entity::new);
    public static final RegistryObject<TileEntityType<Graffiti05Entity>> GRAFFITI_05 = register(Registry.GRAFFITI_05, Graffiti05Entity::new);
    public static final RegistryObject<TileEntityType<Graffiti06Entity>> GRAFFITI_06 = register(Registry.GRAFFITI_06, Graffiti06Entity::new);
    public static final RegistryObject<TileEntityType<MailBoxEntity>> MAIL_BOX = register(Registry.MAIL_BOX, MailBoxEntity::new);
    public static final RegistryObject<TileEntityType<OfficeArmchairEntity>> OFFICE_ARMCHAIR = register(Registry.OFFICE_ARMCHAIR, OfficeArmchairEntity::new);
    public static final RegistryObject<TileEntityType<OfficeBigPrinterEntity>> OFFICE_BIG_PRINTER = register(Registry.OFFICE_BIG_PRINTER, OfficeBigPrinterEntity::new);
    public static final RegistryObject<TileEntityType<OfficeBigSofaEntity>> OFFICE_BIG_SOFA = register(Registry.OFFICE_BIG_SOFA, OfficeBigSofaEntity::new);
    public static final RegistryObject<TileEntityType<OfficeBigTableEntity>> OFFICE_BIG_TABLE = register(Registry.OFFICE_BIG_TABLE, OfficeBigTableEntity::new);
    public static final RegistryObject<TileEntityType<OfficeBoardEntity>> OFFICE_BOARD = register(Registry.OFFICE_BOARD, OfficeBoardEntity::new);
    public static final RegistryObject<TileEntityType<OfficeWhiteBoardEntity>> OFFICE_WHITE_BOARD = register(Registry.OFFICE_WHITE_BOARD, OfficeWhiteBoardEntity::new);
    public static final RegistryObject<TileEntityType<OfficeChairEntity>> OFFICE_CHAIR = register(Registry.OFFICE_CHAIR, OfficeChairEntity::new);
    public static final RegistryObject<TileEntityType<OfficeLongDrawerEntity>> OFFICE_LONG_DRAWER = register(Registry.OFFICE_LONG_DRAWER, OfficeLongDrawerEntity::new);
    public static final RegistryObject<TileEntityType<OfficeShelfEntity>> OFFICE_SHELF = register(Registry.OFFICE_SHELF, OfficeShelfEntity::new);
    public static final RegistryObject<TileEntityType<OfficeShortTongueEntity>> OFFICE_SHORT_TONGUE = register(Registry.OFFICE_SHORT_TONGUE, OfficeShortTongueEntity::new);
    public static final RegistryObject<TileEntityType<OfficeSmallTableEntity>> OFFICE_SMALL_TABLE = register(Registry.OFFICE_SMALL_TABLE, OfficeSmallTableEntity::new);
    public static final RegistryObject<TileEntityType<OfficeTableEntity>> OFFICE_TABLE = register(Registry.OFFICE_TABLE, OfficeTableEntity::new);
    public static final RegistryObject<TileEntityType<OfficeTVEntity>> OFFICE_TV = register(Registry.OFFICE_TV, OfficeTVEntity::new);
    public static final RegistryObject<TileEntityType<OfficeWaterDispenserEntity>> OFFICE_WATER_DISPENSER = register(Registry.OFFICE_WATER_DISPENSER, OfficeWaterDispenserEntity::new);
    public static final RegistryObject<TileEntityType<SecurityFenceEntity>> SECURITY_FENCE = register(Registry.SECURITY_FENCE, SecurityFenceEntity::new);
    public static final RegistryObject<TileEntityType<StreetLightEntity>> STREET_LIGHT = register(Registry.STREET_LIGHT, StreetLightEntity::new);
    public static final RegistryObject<TileEntityType<NewspaperVendingMachineEntity>> NEWSPAPER_VENDING_MACHINE = register(Registry.NEWSPAPER_VENDING_MACHINE, NewspaperVendingMachineEntity::new);
    public static final RegistryObject<TileEntityType<Box03Entity>> BOX_03 = register(Registry.BOX_03, Box03Entity::new);
    public static final RegistryObject<TileEntityType<Box06Entity>> BOX_06 = register(Registry.BOX_06, Box06Entity::new);
    public static final RegistryObject<TileEntityType<Box07Entity>> BOX_07 = register(Registry.BOX_07, Box07Entity::new);
    public static final RegistryObject<TileEntityType<BusSignEntity>> BUS_SIGN = register(Registry.BUS_SIGN, BusSignEntity::new);
    public static final RegistryObject<TileEntityType<FireHydrantEntity>> FIRE_HYDRANT = register(Registry.FIRE_HYDRANT, FireHydrantEntity::new);
    public static final RegistryObject<TileEntityType<BusStationEntity>> BUS_STATION = register(Registry.BUS_STATION, BusStationEntity::new);
    public static final RegistryObject<TileEntityType<CityBenchEntity>> CITY_BENCH = register(Registry.CITY_BENCH, CityBenchEntity::new);
    public static final RegistryObject<TileEntityType<VehicleBarrierEntity>> VEHICLE_BARRIER = register(Registry.VEHICLE_BARRIER, VehicleBarrierEntity::new);
    public static final RegistryObject<TileEntityType<AirConditionerEntity>> AIR_CONDITIONER = register(Registry.AIR_CONDITIONER, AirConditionerEntity::new);
    public static final RegistryObject<TileEntityType<TransitFenceEntity>> TRANSIT_FENCE = register(Registry.TRANSIT_FENCE, TransitFenceEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBenchEntity>> SCI_FI_BENCH = register(Registry.SCI_FI_BENCH, SciFiBenchEntity::new);
    public static final RegistryObject<TileEntityType<TrashContainerEntity>> TRASH_CONTAINER = register(Registry.TRASH_CONTAINER, TrashContainerEntity::new);
    public static final RegistryObject<TileEntityType<TrashContainerOpenEntity>> TRASH_CONTAINER_OPEN = register(Registry.TRASH_CONTAINER_OPEN, TrashContainerOpenEntity::new);
    public static final RegistryObject<TileEntityType<StreetLightBigEntity>> STREET_LIGHT_BIG = register(Registry.STREET_LIGHT_BIG, StreetLightBigEntity::new);
    public static final RegistryObject<TileEntityType<StreetLightModernEntity>> STREET_LIGHT_MODERN = register(Registry.STREET_LIGHT_MODERN, StreetLightModernEntity::new);
    public static final RegistryObject<TileEntityType<StreetLightModernDoubleEntity>> STREET_LIGHT_MODERN_DOUBLE = register(Registry.STREET_LIGHT_MODERN_DOUBLE, StreetLightModernDoubleEntity::new);
    public static final RegistryObject<TileEntityType<SciFiRedChairEntity>> SCI_FI_RED_CHAIR = register(Registry.SCI_FI_RED_CHAIR, SciFiRedChairEntity::new);
    public static final RegistryObject<TileEntityType<SciFiOrangeChairEntity>> SCI_FI_ORANGE_CHAIR = register(Registry.SCI_FI_ORANGE_CHAIR, SciFiOrangeChairEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBlackChairEntity>> SCI_FI_BLACK_CHAIR = register(Registry.SCI_FI_BLACK_CHAIR, SciFiBlackChairEntity::new);
    public static final RegistryObject<TileEntityType<SciFiStoolEntity>> SCI_FI_STOOL = register(Registry.SCI_FI_STOOL, SciFiStoolEntity::new);
    public static final RegistryObject<TileEntityType<TelephoneCabinEntity>> TELEPHONE_CABIN = register(Registry.TELEPHONE_CABIN, TelephoneCabinEntity::new);
    public static final RegistryObject<TileEntityType<SciFiChairEntity>> SCI_FI_CHAIR = register(Registry.SCI_FI_CHAIR, SciFiChairEntity::new);
    public static final RegistryObject<TileEntityType<TrafficLightEntity>> TRAFFIC_LIGHT = register(Registry.TRAFFIC_LIGHT, TrafficLightEntity::new);
    public static final RegistryObject<TileEntityType<SciFiGateEntity>> SCI_FI_GATE = register(Registry.SCI_FI_GATE, SciFiGateEntity::new);
    public static final RegistryObject<TileEntityType<SciFiSmallBinEntity>> SCI_FI_SMALL_BIN = register(Registry.SCI_FI_SMALL_BIN, SciFiSmallBinEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBigBinEntity>> SCI_FI_BIG_BIN = register(Registry.SCI_FI_BIG_BIN, SciFiBigBinEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBarrierEntity>> SCI_FI_BARRIER = register(Registry.SCI_FI_BARRIER, SciFiBarrierEntity::new);
    public static final RegistryObject<TileEntityType<SciFiYellowBarrierEntity>> SCI_FI_YELLOW_BARRIER = register(Registry.SCI_FI_YELLOW_BARRIER, SciFiYellowBarrierEntity::new);
    public static final RegistryObject<TileEntityType<SciFiWarningSignEntity>> SCI_FI_WARNING_SIGN = register(Registry.SCI_FI_WARNING_SIGN, SciFiWarningSignEntity::new);
    public static final RegistryObject<TileEntityType<SciFiVerticalWireEntity>> SCI_FI_VERTICAL_WIRE = register(Registry.SCI_FI_VERTICAL_WIRE, SciFiVerticalWireEntity::new);
    public static final RegistryObject<TileEntityType<SciFiHorizontalWireEntity>> SCI_FI_HORIZONTAL_WIRE = register(Registry.SCI_FI_HORIZONTAL_WIRE, SciFiHorizontalWireEntity::new);
    public static final RegistryObject<TileEntityType<SciFiVerticalCableEntity>> SCI_FI_VERTICAL_CABLE = register(Registry.SCI_FI_VERTICAL_CABLE, SciFiVerticalCableEntity::new);
    public static final RegistryObject<TileEntityType<SciFiVariousTrashEntity>> SCI_FI_VARIOUS_TRASH = register(Registry.SCI_FI_VARIOUS_TRASH, SciFiVariousTrashEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBigTableEntity>> SCI_FI_BIG_TABLE = register(Registry.SCI_FI_BIG_TABLE, SciFiBigTableEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBigVerticalTableEntity>> SCI_FI_BIG_VERTICAL_TABLE = register(Registry.SCI_FI_BIG_VERTICAL_TABLE, SciFiBigVerticalTableEntity::new);
    public static final RegistryObject<TileEntityType<SciFiBigGlassTableEntity>> SCI_FI_BIG_GLASS_TABLE = register(Registry.SCI_FI_BIG_GLASS_TABLE, SciFiBigGlassTableEntity::new);
    public static final RegistryObject<TileEntityType<SciFiVerticalSignNightEntity>> SCI_FI_VERTICAL_SIGN_NIGHT = register(Registry.SCI_FI_VERTICAL_SIGN_NIGHT, SciFiVerticalSignNightEntity::new);
    public static final RegistryObject<TileEntityType<SciFiSignNightEntity>> SCI_FI_SIGN_NIGHT = register(Registry.SCI_FI_SIGN_NIGHT, SciFiSignNightEntity::new);
    public static final RegistryObject<TileEntityType<SciFiSignSunEntity>> SCI_FI_SIGN_SUN = register(Registry.SCI_FI_SIGN_SUN, SciFiSignSunEntity::new);
    public static final RegistryObject<TileEntityType<SciFiLampPillarEntity>> SCI_FI_LAMP_PILLAR = register(Registry.SCI_FI_LAMP_PILLAR, SciFiLampPillarEntity::new);
    public static final RegistryObject<TileEntityType<SciFiLightPillarEntity>> SCI_FI_LIGHT_PILLAR = register(Registry.SCI_FI_LIGHT_PILLAR, SciFiLightPillarEntity::new);
    public static final RegistryObject<TileEntityType<SciFiGeneratorEntity>> SCI_FI_GENERATOR = register(Registry.SCI_FI_GENERATOR, SciFiGeneratorEntity::new);
    public static final RegistryObject<TileEntityType<ScareCrowEntity>> SCARE_CROW = register(Registry.SCARE_CROW, ScareCrowEntity::new);
    public static final RegistryObject<TileEntityType<OakDeadTreeEntity>> OAK_DEAD_TREE = register(Registry.OAK_DEAD_TREE, OakDeadTreeEntity::new);
    public static final RegistryObject<TileEntityType<OakPlankHorizontalEntity>> OAK_PLANK_HORIZONTAL = register(Registry.OAK_PLANK_HORIZONTAL, OakPlankHorizontalEntity::new);
    public static final RegistryObject<TileEntityType<OakPlankVerticalEntity>> OAK_PLANK_VERTICAL = register(Registry.OAK_PLANK_VERTICAL, OakPlankVerticalEntity::new);
    public static final RegistryObject<TileEntityType<OakWoodChairEntity>> OAK_WOOD_CHAIR = register(Registry.OAK_WOOD_CHAIR, OakWoodChairEntity::new);
    public static final RegistryObject<TileEntityType<OakStrippedChairEntity>> OAK_STRIPPED_CHAIR = register(Registry.OAK_STRIPPED_CHAIR, OakStrippedChairEntity::new);
    public static final RegistryObject<TileEntityType<DungeonCageEntity>> DUNGEON_CAGE = register(Registry.DUNGEON_CAGE, DungeonCageEntity::new);
    public static final RegistryObject<TileEntityType<DungeonCageWithBoneEntity>> DUNGEON_CAGE_WITH_BONE = register(Registry.DUNGEON_CAGE_WITH_BONE, DungeonCageWithBoneEntity::new);
    public static final RegistryObject<TileEntityType<DungeonWeaponStandEntity>> DUNGEON_WEAPON_STAND = register(Registry.DUNGEON_WEAPON_STAND, DungeonWeaponStandEntity::new);
    public static final RegistryObject<TileEntityType<DungeonSkeletonEntity>> DUNGEON_SKELETON = register(Registry.DUNGEON_SKELETON, DungeonSkeletonEntity::new);
    public static final RegistryObject<TileEntityType<DungeonWoodChairWithBoneEntity>> DUNGEON_WOOD_CHAIR_WITH_BONE = register(Registry.DUNGEON_WOOD_CHAIR_WITH_BONE, DungeonWoodChairWithBoneEntity::new);
    public static final RegistryObject<TileEntityType<DungeonSkeletonSleepEntity>> DUNGEON_SKELETON_SLEEP = register(Registry.DUNGEON_SKELETON_SLEEP, DungeonSkeletonSleepEntity::new);
    public static final RegistryObject<TileEntityType<DungeonHangFlagEntity>> DUNGEON_HANG_FLAG = register(Registry.DUNGEON_HANG_FLAG, DungeonHangFlagEntity::new);

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(@Nonnull RegistryObject<? extends Block> block, @Nonnull Supplier<T> supplier) {
        return REGISTER.register(block.getId().getPath(), () ->
                TileEntityType.Builder.of(supplier, block.get()).build(null)
        );
    }
}