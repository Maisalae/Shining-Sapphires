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

public class FirePasture extends GrassBlock implements IGrowable {


    public FirePasture() {
        super(Properties.create(Material.ORGANIC, MaterialColor.ORANGE_TERRACOTTA)
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
        if(plantBlock == RegistryHandler.FIRE_BLOSSOM_SAPLING.get() || plantBlock == RegistryHandler.FIRE_GRASS.get()) return true;
        return plantType == ShiningSapphires.FIRE;
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