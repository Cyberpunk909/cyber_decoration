package com.cyber.punk.test;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class BabyWalleRender extends GeoEntityRenderer<BabyWalleEntity> {
    public BabyWalleRender(EntityRendererManager renderManager) {
        super(renderManager, new BabyWalleModel());
    }
}
