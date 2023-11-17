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

public class SkyPasture extends GrassBlock {


    public SkyPasture() {
        /*
        constructor for fire pasture block
        setting what type of material it is, what colour it shows up as on maps,
        hardness (how long it takes to mine the block), its blast resistance,
        what sort of sound it should make,
        what level of tool (i.e. wood, stone, iron, diamond) is needed to mine it,
        and what type of tool is needed to mine it (i.e. pickaxe, axe, shovel, etc.)
        */
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
        // note  to self: add a new custom tag for sky blossom plants, so you don't have to check individually
        // it's fine for now but as more types of plant get added, it'll get out of hand fast
        if(plantBlock == RegistryHandler.SKY_BLOSSOM_SAPLING.get() || plantBlock == RegistryHandler.SKY_GRASS.get())
            return true;
        return plantType == ShiningSapphires.SKY;
    }

    @Override
    public boolean canBeReplacedByLeaves(BlockState state, IWorldReader world, BlockPos pos) {
        return false;
    }

    // i think this is the method to faff with to change what spawns from bonemeal
    /*
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = RegistryHandler.SKY_GRASS.get().getDefaultState();

        for(int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;
            int j = 0;

            while(true) {
                if (j >= i / 16) {
                    BlockState blockstate2 = worldIn.getBlockState(blockpos1);
                    if (blockstate2.getBlock() == blockstate.getBlock() && rand.nextInt(10) == 0) {
                        ((IGrowable)blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
                    }

                    if (!blockstate2.isAir()) {
                        break;
                    }

                    BlockState blockstate1;
                    if (rand.nextInt(8) == 0) {
                        List<ConfiguredFeature<?, ?>> list = worldIn.getBiome(blockpos1).getFlowers();
                        if (list.isEmpty()) {
                            break;
                        }

                        ConfiguredFeature<?, ?> configuredfeature = ((DecoratedFeatureConfig)(list.get(0)).config).feature;
                        blockstate1 = ((FlowersFeature)configuredfeature.feature).getFlowerToPlace(rand, blockpos1, configuredfeature.config);
                    } else {
                        blockstate1 = blockstate;
                    }

                    if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                        worldIn.setBlockState(blockpos1, blockstate1, 3);
                    }
                    break;
                }

                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (worldIn.getBlockState(blockpos1.down()).getBlock() != this || worldIn.getBlockState(blockpos1).isCollisionShapeOpaque(worldIn, blockpos1)) {
                    break;
                }

                ++j;
            }
        }
    }

     */
}