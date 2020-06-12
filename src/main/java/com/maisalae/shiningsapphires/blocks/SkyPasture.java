package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DecoratedFeatureConfig;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.ToolType;

import java.util.List;
import java.util.Random;

public class SkyPasture extends GrassBlock implements IGrowable {


    public SkyPasture() {
        super(Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE_TERRACOTTA)
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
        if(plantBlock == RegistryHandler.SKY_BLOSSOM_SAPLING.get() || plantBlock == RegistryHandler.SKY_GRASS.get())
            return true;
        if (plantType == ShiningSapphires.SKY)
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