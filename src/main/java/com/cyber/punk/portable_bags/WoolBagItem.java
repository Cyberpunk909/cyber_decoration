package com.cyber.punk.portable_bags;

import com.cyber.punk.util.Cyber_Group;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import javax.annotation.Nonnull;

public class WoolBagItem extends Item {
    public WoolBagItem(Properties properties) {
        super((new Properties()).stacksTo(1).tab(Cyber_Group.CYBER_GROUP));
    }

    @Nonnull
    @Override
    public ActionResult<ItemStack> use(@Nonnull World world, @Nonnull PlayerEntity playerEntity, @Nonnull Hand hand) {
        ItemStack stack = playerEntity.getItemInHand(hand);
        if (world.isClientSide()) {
            return ActionResult.success(stack);
        } else {
            NetworkHooks.openGui((ServerPlayerEntity) playerEntity, new SimpleNamedContainerProvider((windowId, inv, player) -> {
                return new WoolBagContainer(windowId, inv, stack, hand);
            }, new StringTextComponent("Wool bag")), (buffer) -> {
                buffer.writeItem(stack);
                buffer.writeEnum(hand);
            });
            return new ActionResult<>(ActionResultType.SUCCESS, stack);
        }
    }

    public static void setTagItems(@Nonnull ItemStack stack, @Nonnull CompoundNBT compoundNBT) {
        stack.getOrCreateTag().put("bagItems", compoundNBT);
    }

    @Nonnull
    public static WoolBagWrapper getWrapper(@Nonnull ItemStack stack) {
        WoolBagWrapper wrapper = new WoolBagWrapper();
        wrapper.deserializeNBT(stack.getOrCreateTag().getCompound("bagItems"));
        return wrapper;
    }
}
