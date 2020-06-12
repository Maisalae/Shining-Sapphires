package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class SapphireBlock extends Block {

    public SapphireBlock() {
        super(Properties.create(Material.IRON, MaterialColor.BLUE)
                .hardnessAndResistance(5.0f,6.0f)
                .sound(SoundType.METAL)
                .slipperiness(0.98f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE));
    }
    @Override
    public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon)
    {
        return true;
    }
}
