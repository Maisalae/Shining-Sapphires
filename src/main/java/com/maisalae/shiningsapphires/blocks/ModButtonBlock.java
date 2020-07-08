package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class ModButtonBlock extends AbstractButtonBlock {
    protected boolean isWooden;
    public ModButtonBlock(boolean isWoodenIn, Properties properties) {
        super(isWoodenIn, properties);
        this.isWooden = isWoodenIn;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean isOn) {
        if (isWooden){return isOn ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;}
        else{return isOn ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;}
    }
}
