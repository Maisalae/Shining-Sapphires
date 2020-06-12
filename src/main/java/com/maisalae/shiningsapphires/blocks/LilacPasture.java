package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

public class LilacPasture extends GrassBlock implements IGrowable {


    public LilacPasture() {
        super(Properties.create(Material.ORGANIC, MaterialColor.PURPLE_TERRACOTTA)
                .hardnessAndResistance(0.5f,2.5f)
                .harvestLevel(0)
                .harvestTool(ToolType.SHOVEL)
                .sound(SoundType.PLANT));
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        BlockState plant = plantable.getPlant(world, pos.offset(facing));
        net.minecraftforge.common.PlantType plantType = plantable.getPlantType(world, pos.offset(facing));
        Block plantBlock = plant.getBlock();
        // sort out the tag for this so you don't have to check individually
        if(plantBlock == RegistryHandler.LILAC_BLOSSOM_SAPLING.get() || plantBlock == RegistryHandler.LILAC_GRASS.get())
            return true;
        if (plantType == ShiningSapphires.LILAC)
            return true;
        return false;
    }
    // MAKE THIS SPREADABLE IT DOESNT SPREAD!!!!
    /*
    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return false;
    }
    */
    @Override
    public boolean canBeReplacedByLeaves(BlockState state, IWorldReader world, BlockPos pos) {
        return false;
    }
}