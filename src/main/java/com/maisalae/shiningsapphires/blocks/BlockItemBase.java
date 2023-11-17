package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.ShiningSapphires;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block blockIn) {
        /*
        constructor for basic block item
        specific block items will be instances of this, and it specifies which tab
        the items should appear in within the creative mode inventory
         */
        super(blockIn, new Properties().group(ShiningSapphires.TAB));
    }
}
