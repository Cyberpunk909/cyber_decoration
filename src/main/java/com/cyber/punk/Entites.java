package com.cyber.punk;

import com.cyber.punk.bounding_block.BoundingBlockEntity;
import com.cyber.punk.entity.*;
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
    public static final RegistryObject<TileEntityType<DungeonSkeletonEntity>> DUNGEON_SKELETON = register(Registry.DUNGEON_SKELETON, DungeonSkeletonEntity::new);
    public static final RegistryObject<TileEntityType<DungeonSkeletonSleepEntity>> DUNGEON_SKELETON_SLEEP = register(Registry.DUNGEON_SKELETON_SLEEP, DungeonSkeletonSleepEntity::new);
    public static final RegistryObject<TileEntityType<DungeonHangFlagEntity>> DUNGEON_HANG_FLAG = register(Registry.DUNGEON_HANG_FLAG, DungeonHangFlagEntity::new);

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(@Nonnull RegistryObject<? extends Block> block, @Nonnull Supplier<T> supplier) {
        return REGISTER.register(block.getId().getPath(), () ->
                TileEntityType.Builder.of(supplier, block.get()).build(null)
        );
    }
}
