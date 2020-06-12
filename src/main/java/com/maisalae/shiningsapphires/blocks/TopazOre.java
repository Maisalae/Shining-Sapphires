package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class TopazOre extends Block {

    public TopazOre() {
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
        .hardnessAndResistance(4.0f,6.0f)
        .harvestLevel(3)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.STONE)
        .lightValue(15));
    }
}
