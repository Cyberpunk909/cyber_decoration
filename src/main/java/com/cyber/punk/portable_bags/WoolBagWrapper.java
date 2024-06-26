package com.cyber.punk.portable_bags;

import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class WoolBagWrapper extends ItemStackHandler {
    public WoolBagWrapper() {
        super(9); // Количество слотов
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return true; // Добавьте вашу логику для проверки валидности предметов, если нужно
    }
}
