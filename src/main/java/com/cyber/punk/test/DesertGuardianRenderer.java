package com.cyber.punk.test;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class DesertGuardianRenderer extends GeoEntityRenderer<DesertGuardianEntity> {
    public DesertGuardianRenderer(EntityRendererManager renderManager) {
        super(renderManager, new DesertGuardianModel());
        this.shadowRadius = 0.7F;
    }

    @Override
    public void renderEarly(DesertGuardianEntity animatable, MatrixStack stackIn, float partialTicks, IRenderTypeBuffer bufferIn, IVertexBuilder builder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        super.renderEarly(animatable, stackIn, partialTicks, bufferIn, builder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }

    @Override
    protected void applyRotations(DesertGuardianEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
    }
}
