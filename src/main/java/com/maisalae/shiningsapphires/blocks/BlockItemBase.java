package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.ShiningSapphires;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block blockIn) {
        super(blockIn, new Properties().group(ShiningSapphires.TAB));
    }
}
