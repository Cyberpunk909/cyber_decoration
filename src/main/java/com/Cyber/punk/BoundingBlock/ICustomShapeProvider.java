package com.Cyber.punk.BoundingBlock;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public interface ICustomShapeProvider {
    VoxelShape getCustomShape(IBlockReader world, BlockPos pos);
}

