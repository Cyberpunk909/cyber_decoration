package com.cyber.punk.portable_bags;

import com.cyber.punk.util.Registry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.Hand;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;

public class WoolBagContainer extends Container {
    private final WoolBagWrapper wrapper;
    private final ItemStack stack;
    private final Hand handIn;
    private final PlayerInventory playerInventory;

    public WoolBagContainer(int windowId, PlayerInventory inv, PacketBuffer data) {
        this(windowId, inv, data.readItem(), data.readEnum(Hand.class));
    }

    public WoolBagContainer(int windowId, @Nonnull PlayerInventory inv, @Nonnull ItemStack stack, @Nonnull Hand handIn) {
        super((ContainerType<?>) Registry.WOOL_BAG_CONTAINER.get(), windowId);
        this.stack = stack;
        this.handIn = handIn;
        this.playerInventory = inv;
        this.wrapper = WoolBagItem.getWrapper(stack);

        setupContainerSlots(inv);
    }

    protected void setupPlayerInventorySlots(@Nonnull PlayerInventory inv) {
        int playerInventoryTop = 99;
        int playerInventoryLeft = 8;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new Slot(inv, j + i * 9 + 9, playerInventoryLeft + j * 18,
                        playerInventoryTop + i * 18));
            }
        }
    }

    protected void setupPlayerHotbar(@Nonnull PlayerInventory inv) {
        int hotbarTop = 157;
        int hotbarLeft = 8;
        for (int i = 0; i < 9; i++) {
            this.addSlot(new Slot(inv, i, hotbarLeft + i * 18, hotbarTop));
        }
    }

    protected void setupSatchelSlots() {
        int startX = 8;
        int startY = 73;
        int slotSizePlus2 = 18;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 9; j++) {
                this.addSlot(new SlotItemHandler(this.wrapper, j + i * 9, startX + j * slotSizePlus2, startY + i * slotSizePlus2) {
                    @Override
                    public void setChanged() {
                        super.setChanged();
                        saveInventory();
                    }
                });
            }
        }
    }

    private void setupContainerSlots(@Nonnull PlayerInventory inv) {
        setupSatchelSlots();
        setupPlayerInventorySlots(inv);
        setupPlayerHotbar(inv);
    }

    private void addPlayerInventorySlot(@Nonnull PlayerInventory inv, int index, int x, int y) {
        if (index == inv.selected && handIn == Hand.MAIN_HAND) {
            this.addSlot(new Slot(inv, index, x, y) {
                @Override
                public boolean mayPickup(@Nonnull PlayerEntity player) {
                    return false;
                }

                @Override
                public boolean mayPlace(@Nonnull ItemStack stack) {
                    return false;
                }
            });
        } else {
            this.addSlot(new Slot(inv, index, x, y));
        }
    }

    public static WoolBagContainer createClientContainer(int windowId, PlayerInventory inv, PacketBuffer data) {
        return new WoolBagContainer(windowId, inv, data.readItem(), data.readEnum(Hand.class));
    }

    @Nonnull
    @Override
    public ItemStack clicked(int slotId, int dragType, @Nonnull ClickType clickType, @Nonnull PlayerEntity player) {
        // Prevent dropping or swapping the item if the GUI is open
        if ((clickType == ClickType.THROW && slotId == player.inventory.selected)) {
            return ItemStack.EMPTY;
        }

        // Block pressing F to swap it when it is in the offhand
        if (clickType == ClickType.SWAP) {
            if (handIn == Hand.OFF_HAND && dragType == 40) {
                return ItemStack.EMPTY;
            } else if (handIn == Hand.MAIN_HAND && dragType >= 0 && dragType < PlayerInventory.getSelectionSize()) {
                // Block taking out of the selected slot
                if (!slots.get(dragType).mayPickup(player)) {
                    return ItemStack.EMPTY;
                }
            }
        }

        return super.clicked(slotId, dragType, clickType, player);
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.wrapper.getSlots()) {
                if (!this.moveItemStackTo(itemstack1, this.wrapper.getSlots(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.wrapper.getSlots(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        saveInventory();
        if (!playerInventory.player.level.isClientSide) {
            ItemStack itemStackInHand = playerInventory.player.getItemInHand(handIn);
            if (!ItemStack.isSame(stack, itemStackInHand)) {
                playerInventory.player.closeContainer();
            }
        }
    }

    @Override
    public void removed(PlayerEntity playerIn) {
        super.removed(playerIn);
        if (!playerIn.level.isClientSide) {
            saveInventory();
        }
    }

    @Override
    public boolean stillValid(PlayerEntity player) {
        return player.getItemInHand(this.handIn) == this.stack;
    }

    private void saveInventory() {
        if (!playerInventory.player.level.isClientSide) {
            WoolBagItem.setTagItems(this.stack, this.wrapper.serializeNBT());
        }
    }
}
