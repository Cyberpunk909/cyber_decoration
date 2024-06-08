package com.cyber.punk.bounding_block;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public interface ICustomShapeProvider {
    VoxelShape getCustomShape(IBlockReader world, BlockPos pos);
}

