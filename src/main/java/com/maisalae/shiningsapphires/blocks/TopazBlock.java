package com.maisalae.shiningsapphires.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class TopazBlock extends Block {

    public TopazBlock() {
        /*
        constructor for topaz block
        setting what type of material it is, what colour it shows up as on the map,
        hardness (how long it takes to mine the block), its blast resistance,
        what sort of sound it should make,
        what level of tool (i.e. wood, stone, iron, diamond) is needed to mine it,
        and what type of tool is needed to mine it (i.e. pickaxe, axe, shovel, etc.)

        also specifies the light level given off by the block, since this block glows
        */
        super(Properties.create(Material.IRON, MaterialColor.ORANGE_TERRACOTTA)
                .hardnessAndResistance(7.0f,6.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .lightValue(15));
    }
    @Override // overriding this method allows the block to be used as a beacon base block
    public boolean isBeaconBase(BlockState state, IWorldReader world, BlockPos pos, BlockPos beacon)
    {
        return true;
    }
}
