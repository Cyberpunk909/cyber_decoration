package com.cyber.punk.test;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ToffyWitchRender extends GeoEntityRenderer<ToffyWitchEntity> {
    public ToffyWitchRender(EntityRendererManager renderManager) {
        super(renderManager, new ToffyWitchModel());
    }
}
