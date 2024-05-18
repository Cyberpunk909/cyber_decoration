package com.cyber.punk.boundingBlock;

import net.minecraft.block.Block;
import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;

public class VoxelUtil {

    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        if (from == to) {
            return shape;
        }

        int fromIndex = from.get2DDataValue();
        int toIndex = to.get2DDataValue();

        int times = Math.floorMod(toIndex - fromIndex, 4);
        VoxelShape rotatedShape = shape;

        for (int i = 0; i < times; i++) {
            rotatedShape = rotateShape90(rotatedShape);
        }

        return rotatedShape;
    }

    private static VoxelShape rotateShape90(VoxelShape shape) {
        VoxelShape result = VoxelShapes.empty();
        for (AxisAlignedBB box : shape.toAabbs()) {
            result = VoxelShapes.or(result, rotateAABB90(box));
        }
        return result;
    }

    private static VoxelShape rotateAABB90(AxisAlignedBB box) {
        AxisAlignedBB rotatedBox = new AxisAlignedBB(
                1 - box.maxZ,
                box.minY,
                box.minX,
                1 - box.minZ,
                box.maxY,
                box.maxX
        );
        return VoxelShapes.create(rotatedBox);
    }
}


