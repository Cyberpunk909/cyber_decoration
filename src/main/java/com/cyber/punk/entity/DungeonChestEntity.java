package com.cyber.punk.entity;

import com.cyber.punk.Entites;
import net.minecraft.tileentity.ChestTileEntity;

public class DungeonChestEntity extends ChestTileEntity {
    public DungeonChestEntity() {
        super(Entites.DUNGEON_CHEST.get());
    }
}
