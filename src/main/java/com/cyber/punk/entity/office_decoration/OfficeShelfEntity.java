package com.cyber.punk.entity.office_decoration;

import com.cyber.punk.util.Entites;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class OfficeShelfEntity extends TileEntity {
    private BlockPos mainPos;

    public OfficeShelfEntity() {
        super(Entites.OFFICE_SHELF.get());
        this.mainPos = BlockPos.ZERO;
    }

    public void setMainPosition(BlockPos pos) {
        this.mainPos = pos;
        setChanged();
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        mainPos = BlockPos.of(nbt.getLong("MainPos"));
    }

    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        super.save(nbt);
        nbt.putLong("MainPos", mainPos.asLong());
        return nbt;
    }
}