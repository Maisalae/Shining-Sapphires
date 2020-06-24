package com.maisalae.shiningsapphires.init;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.world.biomes.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
    public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, ShiningSapphires.MOD_ID);

    public static final RegistryObject<Biome> SKY_MEADOW = BIOMES.register("sky_meadow", SkyMeadow::new);
    public static final RegistryObject<Biome> LILAC_MEADOW = BIOMES.register("lilac_meadow", LilacMeadow::new);
    public static final RegistryObject<Biome> FIRE_MEADOW = BIOMES.register("fire_meadow", FireMeadow::new);
    public static final RegistryObject<Biome> SKY_FLOWER_MEADOW = BIOMES.register("sky_flower_meadow", SkyFlowerMeadow::new);
    public static final RegistryObject<Biome> SKY_MEADOW_PLAINS = BIOMES.register("sky_meadow_plains", SkyMeadowPlains::new);


    public static void registerBiomes() {
        registerCoolBiome(SKY_MEADOW.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.FOREST);
        registerCoolBiome(LILAC_MEADOW.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.FOREST);
        registerHotBiome(FIRE_MEADOW.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.FOREST);
        registerCoolBiome(SKY_FLOWER_MEADOW.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.LUSH, BiomeDictionary.Type.PLAINS);
        registerCoolBiome(SKY_MEADOW_PLAINS.get(), BiomeDictionary.Type.OVERWORLD, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.PLAINS);
    }

    private static void registerCoolBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome,types);
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome,100));
        BiomeManager.addSpawnBiome(biome);
    }
    private static void registerHotBiome(Biome biome, BiomeDictionary.Type... types) {
        BiomeDictionary.addTypes(biome,types);
        BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome,100));
        BiomeManager.addSpawnBiome(biome);
    }
}
