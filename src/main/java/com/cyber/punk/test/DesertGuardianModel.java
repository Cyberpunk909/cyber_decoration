package com.cyber.punk.test;

import software.bernie.geckolib3.model.AnimatedGeoModel;
import net.minecraft.util.ResourceLocation;

public class DesertGuardianModel extends AnimatedGeoModel<DesertGuardianEntity> {

    @Override
    public ResourceLocation getModelLocation(DesertGuardianEntity object) {
        return new ResourceLocation("cyber_decoration", "geo/desert_guardian.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DesertGuardianEntity object) {
        return new ResourceLocation("cyber_decoration", "textures/entity/desert_guardian.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DesertGuardianEntity object) {
        return new ResourceLocation("cyber_decoration", "animations/desert_guardian.animation.json");
    }
}
