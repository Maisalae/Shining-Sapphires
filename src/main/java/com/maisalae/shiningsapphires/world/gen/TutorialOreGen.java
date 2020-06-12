package com.maisalae.shiningsapphires.world.gen;

import com.maisalae.shiningsapphires.config.OreGenConfig;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

public class TutorialOreGen {

    private static final CountRangeConfig SAPPHIRE = new CountRangeConfig(OreGenConfig.sapphire_chance.get(), 4, 0, 20);
    private static final CountRangeConfig TOPAZ = new CountRangeConfig(OreGenConfig.topaz_chance.get(), 3, 0, 16);
    private static final CountRangeConfig AMETHYST = new CountRangeConfig(OreGenConfig.amethyst_chance.get(), 4, 0, 20);

    static ConfiguredPlacement<CountRangeConfig> customConfig = null;

    public static void generateOre() {

        for (Biome biome : ForgeRegistries.BIOMES) {


            if(OreGenConfig.generate_sapphire.get()) {
                customConfig = Placement.COUNT_RANGE.func_227446_a_(SAPPHIRE);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.SAPPHIRE_ORE.get().getDefaultState(), MathHelper.nextInt(new Random(), 3, 8))).func_227228_a_(customConfig));
            }

            if(OreGenConfig.generate_topaz.get()) {
                customConfig = Placement.COUNT_RANGE.func_227446_a_(TOPAZ);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.TOPAZ_ORE.get().getDefaultState(), MathHelper.nextInt(new Random(), 2, 3))).func_227228_a_(customConfig));
            }

            if(OreGenConfig.generate_amethyst.get()) {
                customConfig = Placement.COUNT_RANGE.func_227446_a_(AMETHYST);
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .func_225566_b_(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, RegistryHandler.AMETHYST_ORE.get().getDefaultState(), MathHelper.nextInt(new Random(), 3, 8))).func_227228_a_(customConfig));
            }

        }
    }
}


