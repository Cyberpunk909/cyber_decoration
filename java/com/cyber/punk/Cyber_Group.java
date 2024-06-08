package com.cyber.punk;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Cyber_Group {

    public static final ItemGroup CYBER_GROUP = new ItemGroup("Cyber") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registry.SHADOW_BOOK.get());
        }
    };
}
