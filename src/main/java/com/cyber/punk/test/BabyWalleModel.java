package com.cyber.punk.test;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class BabyWalleModel extends AnimatedGeoModel<BabyWalleEntity> {

    @Override
    public ResourceLocation getModelLocation(BabyWalleEntity object) {
        return new ResourceLocation("cyber_decoration", "geo/baby_walle.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(BabyWalleEntity object) {
        return new ResourceLocation("cyber_decoration", "textures/entity/baby_walle.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(BabyWalleEntity animatable) {
        return new ResourceLocation("cyber_decoration", "animations/baby_walle.animation.json");
    }
}
