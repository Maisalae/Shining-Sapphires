package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;

public class OozingSkyLog extends LogBlock {
    public OozingSkyLog() {
        super(MaterialColor.CYAN, Block.Properties.from(Blocks.STRIPPED_OAK_LOG));
    }
}
