package com.cyber.punk.test;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ToffyWitchModel extends AnimatedGeoModel<ToffyWitchEntity> {

    @Override
    public ResourceLocation getModelLocation(ToffyWitchEntity object) {
        return new ResourceLocation("cyber_decoration", "geo/toffy_witch.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ToffyWitchEntity object) {
        return new ResourceLocation("cyber_decoration", "textures/entity/toffy_witch.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ToffyWitchEntity animatable) {
        return new ResourceLocation("cyber_decoration", "animations/toffy_witch.animation.json");
    }
}
