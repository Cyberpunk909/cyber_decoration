package com.cyber.punk.util;

import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.entity.dungeon_decoration.*;
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
    public static final RegistryObject<TileEntityType<SciFiBenchEntity>> SCI_FI_BENCH = register(Registry.SCI_FI_BENCH, SciFiBenchEntity::new);
    public static final RegistryObject<TileEntityType<SciFiRedChairEntity>> SCI_FI_RED_CHAIR = register(Registry.SCI_FI_RED_CHAIR, SciFiRedChairEntity::new);
    public static final RegistryObject<TileEntityType<SciFiChairEntity>> SCI_FI_CHAIR = register(Registry.SCI_FI_CHAIR, SciFiChairEntity::new);
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
