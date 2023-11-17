package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block {

    public SapphireOre() {
        /*
        constructor for sapphire ore block
        setting what type of material it is, what colour it shows up as on the map,
        hardness (how long it takes to mine the block), its blast resistance,
        what sort of sound it should make,
        what level of tool (i.e. wood, stone, iron, diamond) is needed to mine it,
        and what type of tool is needed to mine it (i.e. pickaxe, axe, shovel, etc.)
        */
        super(Properties.create(Material.ROCK, MaterialColor.STONE)
        .hardnessAndResistance(3.0f,6.0f)
        .harvestLevel(2)
        .harvestTool(ToolType.PICKAXE)
        .sound(SoundType.STONE)
        .lightValue(0));
    }
}
