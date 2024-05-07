package com.Cyber.punk.item;

import com.Cyber.punk.BoundingBlock.BoundingBlockEntity;
import com.Cyber.punk.block.CustomBlock;
import com.Cyber.punk.block.entity.CustomBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.gen.placement.EndIsland;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public class Entites {
    public static final DeferredRegister<TileEntityType<?>> REGISTER;
    public static final RegistryObject<TileEntityType<BoundingBlockEntity>> BOUNDING_BLOCK;
    public static final RegistryObject<TileEntityType<CustomBlockEntity>> CUSTOM_BLOCK;

    public Entites() {

    }

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(@Nonnull RegistryObject<? extends Block> block, @Nonnull Supplier<T> supplier) {
        return REGISTER.register(block.getId().getPath(), () ->
                TileEntityType.Builder.of(supplier, block.get()).build(null)
        );
    }

    static {
        REGISTER = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "cyber_hardevo");
        CUSTOM_BLOCK = register(Registry.CUSTOM_BLOCK, CustomBlockEntity::new);
        BOUNDING_BLOCK = register(Registry.BOUNDING_BLOCK, BoundingBlockEntity::new);
    }
}
