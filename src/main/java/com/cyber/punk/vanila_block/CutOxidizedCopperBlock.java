package com.cyber.punk.vanila_block;

import com.cyber.punk.BlockUtils;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import java.util.stream.Stream;

public class CutOxidizedCopperBlock extends BlockUtils {

    public CutOxidizedCopperBlock() {
        super(AbstractBlock.Properties.of(Material.METAL)
                .strength(3.5f, 4.0f));
    }

    private static final VoxelShape SHAPE;

    static {
        SHAPE = Stream.of(
                Block.box(0, 0, 0, 16, 16, 16)
        ).reduce((v1, v2) -> VoxelShapes.or(v1, v2)).get();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
}
