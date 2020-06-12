package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block {

    public SapphireOre() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
        .hardnessAndResistance(3.0f,6.0f)
        .harvestLevel(2)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.STONE)
        .lightValue(0));
    }
}
