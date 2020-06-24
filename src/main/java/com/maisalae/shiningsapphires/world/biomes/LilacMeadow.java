package com.maisalae.shiningsapphires.world.biomes;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import com.maisalae.shiningsapphires.world.feature.LilacBlossomTree;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LilacMeadow extends Biome {
    public final BlockClusterFeatureConfig grassConfig = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.LILAC_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).tries(32).build();

    public LilacMeadow() {
        super(new Builder()
                .scale(0.25f).waterColor(15103710).waterFogColor(15767523).temperature(0.5f).precipitation(RainType.RAIN).category(Category.PLAINS)
                .surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(RegistryHandler.LILAC_PASTURE.get().getDefaultState(),
                        Blocks.DIRT.getDefaultState(), Blocks.SAND.getDefaultState())).downfall(0.1f).depth(0.12f).parent(null));

        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.OCELOT, 5, 2, 5));
        this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
        DefaultBiomeFeatures.addExtraEmeraldOre(this);
        DefaultBiomeFeatures.addOres(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.RANDOM_PATCH.withConfiguration(grassConfig).withPlacement(
                        Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
                Feature.ACACIA_TREE.withConfiguration(LilacBlossomTree.LILAC_BLOSSOM_TREE_CONFIG).withPlacement(
                        Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(4, 0.1f, 1))));
    }

    @Override
    public boolean doesWaterFreeze(IWorldReader worldIn, BlockPos pos) {
        return false;
    }

    @Override
    public boolean doesSnowGenerate(IWorldReader worldIn, BlockPos pos) {
        return false;
    }

    @OnlyIn(Dist.CLIENT)
    public int getSkyColor() {
        return 15103710;
    }
}

