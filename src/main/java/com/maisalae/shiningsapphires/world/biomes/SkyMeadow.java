package com.maisalae.shiningsapphires.world.biomes;

import com.google.common.collect.ImmutableSet;
import com.maisalae.shiningsapphires.util.RegistryHandler;
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
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SkyMeadow extends Biome {
    public final BlockClusterFeatureConfig featureConfig = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RegistryHandler.SKY_GRASS.get().getDefaultState()), new SimpleBlockPlacer())).func_227315_a_(32).func_227322_d_();
    public SkyMeadow() {
        super(new Biome.Builder()
                .scale(0.15f).waterColor(7171049).waterFogColor(9015534).temperature(0.5f).precipitation(Biome.RainType.RAIN).category(Biome.Category.PLAINS)
                .surfaceBuilder(SurfaceBuilder.DEFAULT,new SurfaceBuilderConfig(RegistryHandler.SKY_PASTURE.get().getDefaultState(),
                        Blocks.DIRT.getDefaultState(),Blocks.GRAVEL.getDefaultState())).downfall(0.1f).depth(0.1f).parent((String)null));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.CAT,5,2,5));
        this.addCarver(GenerationStage.Carving.AIR, Biome.createCarver(WorldCarver.CAVE, new ProbabilityConfig(0.14285715f)));
        DefaultBiomeFeatures.addExtraEmeraldOre(this);
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_227248_z_.func_225566_b_(featureConfig).func_227228_a_(Placement.COUNT_HEIGHTMAP_DOUBLE.func_227446_a_(new FrequencyConfig(5))));
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
    public int func_225529_c_() {
        return 0;
    }
}

