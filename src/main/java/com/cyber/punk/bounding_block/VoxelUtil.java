package com.cyber.punk.bounding_block;

import net.minecraft.util.Direction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.AxisAlignedBB;

public class VoxelUtil {

    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        if (from == to) {
            return shape;
        }

        VoxelShape rotatedShape = shape;

        // Handle vertical rotation cases
        if (from == Direction.UP || from == Direction.DOWN || to == Direction.UP || to == Direction.DOWN) {
            rotatedShape = rotateVertical(from, to, rotatedShape);
        } else {
            // Handle horizontal rotation cases
            int fromIndex = from.get2DDataValue();
            int toIndex = to.get2DDataValue();

            int times = Math.floorMod(toIndex - fromIndex, 4);
            for (int i = 0; i < times; i++) {
                rotatedShape = rotateShape90(rotatedShape);
            }
        }

        return rotatedShape;
    }

    private static VoxelShape rotateVertical(Direction from, Direction to, VoxelShape shape) {
        if (from == Direction.DOWN) {
            shape = rotateShape180(shape);
        }

        if (to == Direction.DOWN) {
            shape = rotateShape180(shape);
        }

        if (from == Direction.UP) {
            shape = rotateShape270(shape);
        }

        if (to == Direction.UP) {
            shape = rotateShape90(shape);
        }

        return shape;
    }

    private static VoxelShape rotateShape90(VoxelShape shape) {
        VoxelShape result = VoxelShapes.empty();
        for (AxisAlignedBB box : shape.toAabbs()) {
            result = VoxelShapes.or(result, rotateAABB90(box));
        }
        return result;
    }

    private static VoxelShape rotateShape180(VoxelShape shape) {
        VoxelShape result = VoxelShapes.empty();
        for (AxisAlignedBB box : shape.toAabbs()) {
            result = VoxelShapes.or(result, rotateAABB180(box));
        }
        return result;
    }

    private static VoxelShape rotateShape270(VoxelShape shape) {
        VoxelShape result = VoxelShapes.empty();
        for (AxisAlignedBB box : shape.toAabbs()) {
            result = VoxelShapes.or(result, rotateAABB270(box));
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

    private static VoxelShape rotateAABB180(AxisAlignedBB box) {
        AxisAlignedBB rotatedBox = new AxisAlignedBB(
                1 - box.maxX,
                box.minY,
                1 - box.maxZ,
                1 - box.minX,
                box.maxY,
                1 - box.minZ
        );
        return VoxelShapes.create(rotatedBox);
    }

    private static VoxelShape rotateAABB270(AxisAlignedBB box) {
        AxisAlignedBB rotatedBox = new AxisAlignedBB(
                box.minZ,
                box.minY,
                1 - box.maxX,
                box.maxZ,
                box.maxY,
                1 - box.minX
        );
        return VoxelShapes.create(rotatedBox);
    }
}
