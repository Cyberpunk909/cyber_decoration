package com.cyber.punk.portable_bags;

import com.cyber.punk.util.Cyber;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class WoolBagScreen extends ContainerScreen<WoolBagContainer> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(Cyber.MOD_ID, "textures/gui/wool_bag_gui.png");

    public WoolBagScreen(WoolBagContainer container, PlayerInventory inv, ITextComponent title) {
        super(container, inv, title);
        this.imageWidth = 177; // Ширина GUI
        this.imageHeight = 181; // Высота GUI
    }

    @Override
    protected void renderBg(MatrixStack matrixStack, float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bind(GUI_TEXTURE);
        this.blit(matrixStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    @Override
    protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
        this.font.draw(matrixStack, this.title.getString(), 8.0F, 6.0F, 4210752);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        // Предотвращаем выброс предмета, если GUI открыт
        if (keyCode == this.minecraft.options.keyDrop.getKey().getValue()) {
            return false;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
