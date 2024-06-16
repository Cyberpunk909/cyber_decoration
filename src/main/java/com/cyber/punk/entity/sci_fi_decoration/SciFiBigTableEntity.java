package com.cyber.punk.entity.sci_fi_decoration;

import com.cyber.punk.util.Entites;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;

public class SciFiBigTableEntity extends TileEntity {
    private BlockPos mainPos;

    public SciFiBigTableEntity() {
        super(Entites.SCI_FI_BIG_TABLE.get());
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