package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;

public class OozingFireLog extends LogBlock {
    public OozingFireLog() {
        super(MaterialColor.ORANGE_TERRACOTTA, Properties.from(Blocks.STRIPPED_OAK_LOG));
    }
}
