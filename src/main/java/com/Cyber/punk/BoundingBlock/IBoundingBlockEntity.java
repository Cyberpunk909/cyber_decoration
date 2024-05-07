//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.Cyber.punk.BoundingBlock;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;

public interface IBoundingBlockEntity extends ICapabilityProvider {
    void onPlace();

    default void onBoundingBlockPowerChange(BlockPos boundingPos, int oldLevel, int newLevel) {
    }

    default int getBoundingComparatorSignal(Vector3i offset) {
        return 0;
    }

    default boolean supportsComparator() {
        return true;
    }

    default int getRedstoneLevel() {
        return 0;
    }

    default int getCurrentRedstoneLevel() {
        return 0;
    }

    @Nonnull
    default <T> LazyOptional<T> getOffsetCapability(@Nonnull Capability<T> capability, @Nullable Direction side, @Nonnull Vector3i offset) {
        return this.isOffsetCapabilityDisabled(capability, side, offset) ? LazyOptional.empty() : this.getOffsetCapabilityIfEnabled(capability, side, offset);
    }

    default boolean isOffsetCapabilityDisabled(@Nonnull Capability<?> capability, @Nullable Direction side, @Nonnull Vector3i offset) {
        return false;
    }

    @Nonnull
    default <T> LazyOptional<T> getOffsetCapabilityIfEnabled(@Nonnull Capability<T> capability, Direction side, @Nonnull Vector3i offset) {
        return this.getCapability(capability, side);
    }
}
