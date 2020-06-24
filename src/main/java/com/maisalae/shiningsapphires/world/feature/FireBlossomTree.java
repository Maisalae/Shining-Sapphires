package com.maisalae.shiningsapphires.world.feature;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class FireBlossomTree extends Tree {
    public static final TreeFeatureConfig FIRE_BLOSSOM_TREE_CONFIG = (new TreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(RegistryHandler.FIRE_BLOSSOM_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(RegistryHandler.FIRE_BLOSSOM_LEAVES.get().getDefaultState()),
            new PineFoliagePlacer(1, 0))).baseHeight(7).heightRandA(4)
            .trunkTopOffset(1).foliageHeight(3).foliageHeightRandom(1).ignoreVines()
            .setSapling((IPlantable) RegistryHandler.FIRE_BLOSSOM_SAPLING.get()).build();
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.withConfiguration(FIRE_BLOSSOM_TREE_CONFIG);
    }
}
