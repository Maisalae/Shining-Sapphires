package com.maisalae.shiningsapphires.world.feature;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.trees.BigTree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class LargeSkyBlossomTree extends BigTree {

    public static final HugeTreeFeatureConfig LARGE_SKY_BLOSSOM_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.SKY_BLOSSOM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.SKY_BLOSSOM_LEAVES.get().getDefaultState())).baseHeight(6)
            .setSapling((net.minecraftforge.common.IPlantable)RegistryHandler.SKY_BLOSSOM_SAPLING.get()).build());

    @Nullable
    @Override
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random p_225547_1_) {
        return Feature.DARK_OAK_TREE.withConfiguration(LARGE_SKY_BLOSSOM_TREE_CONFIG);
    }

    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return null;
    }
}
