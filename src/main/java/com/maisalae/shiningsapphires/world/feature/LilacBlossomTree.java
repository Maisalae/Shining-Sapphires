package com.maisalae.shiningsapphires.world.feature;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class LilacBlossomTree extends Tree {
    public static final TreeFeatureConfig LILAC_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.LILAC_BLOSSOM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.LILAC_BLOSSOM_LEAVES.get().getDefaultState()),
            new AcaciaFoliagePlacer(2, 0)))
            .baseHeight(5).heightRandA(2).heightRandB(2).trunkHeight(0).ignoreVines()
            .setSapling((IPlantable)RegistryHandler.LILAC_BLOSSOM_SAPLING.get()).build();
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.ACACIA_TREE.withConfiguration(LILAC_BLOSSOM_TREE_CONFIG);
    }
}
