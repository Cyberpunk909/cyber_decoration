package com.cyber.punk.entity.hospital;

import com.cyber.punk.util.Entites;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class HospitalWhiteBedEntity extends TileEntity {
    private BlockPos mainPos;

    public HospitalWhiteBedEntity() {
        super(Entites.HOSPITAL_WHITE_BED.get());
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