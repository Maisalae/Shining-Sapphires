package com.maisalae.shiningsapphires.world.feature;

import java.util.Random;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;

public class SkyBlossomTree extends Tree {
    public static final TreeFeatureConfig SKY_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.SKY_BLOSSOM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.SKY_BLOSSOM_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))).baseHeight(5).heightRandA(3).foliageHeight(3).ignoreVines()
            .setSapling((IPlantable) RegistryHandler.SKY_BLOSSOM_SAPLING.get()).build();

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean b) {
        return Feature.NORMAL_TREE.withConfiguration(SKY_BLOSSOM_TREE_CONFIG);
    }

}