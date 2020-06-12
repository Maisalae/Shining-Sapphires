package com.maisalae.shiningsapphires.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OreGenConfig {
    public static ForgeConfigSpec.IntValue sapphire_chance, topaz_chance, amethyst_chance;
    public static ForgeConfigSpec.BooleanValue generate_sapphire, generate_topaz, generate_amethyst;

    public static void init(ForgeConfigSpec.Builder server, ForgeConfigSpec.Builder client) {

        server.comment("OreGen Config");

        sapphire_chance = server.comment("Maximum number of ore veins of sapphire ore that can spawn in one chunk").defineInRange("oregen.sapphire_chance", 3, 1, 6);
        topaz_chance = server.comment("Maximum number of ore veins of topaz ore that can spawn in one chunk").defineInRange("oregen.topaz_chance", 2, 1, 4);
        amethyst_chance = server.comment("Maximum number of ore veins of amethyst ore that can spawn in one chunk").defineInRange("oregen.amethyst_chance", 3, 1, 6);

        generate_sapphire = server.comment("Decide if you want sapphire ore to spawn in the overworld").define("oregen.generate_sapphire", true);
        generate_topaz = server.comment("Decide if you want topaz ore to spawn in the overworld").define("oregen.generate_topaz", true);
        generate_amethyst = server.comment("Decide if you want amethyst ore to spawn in the overworld").define("oregen.generate_amethyst", true);

    }
}