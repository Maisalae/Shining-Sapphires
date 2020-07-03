package com.maisalae.shiningsapphires;

import com.maisalae.shiningsapphires.config.Config;
import com.maisalae.shiningsapphires.init.BiomeInit;
// import com.maisalae.shiningsapphires.init.DimensionInit;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.maisalae.shiningsapphires.world.gen.TutorialOreGen.*;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("shiningsapphires")
@Mod.EventBusSubscriber(modid = ShiningSapphires.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ShiningSapphires {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "shiningsapphires";
    public static final PlantType SKY = PlantType.create("sky");
    public static final PlantType LILAC = PlantType.create("lilac");
    public static final PlantType FIRE = PlantType.create("fire");

    public ShiningSapphires() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        BiomeInit.BIOMES.register(modEventBus);
        // DimensionInit.MOD_DIMENSIONS.register(modEventBus);

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.server_config);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.client_config);

        Config.loadConfig(Config.client_config, FMLPaths.CONFIGDIR.get().resolve("shiningsapphires-client.toml").toString());
        Config.loadConfig(Config.server_config, FMLPaths.CONFIGDIR.get().resolve("shiningsapphires-server.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);
    }
    
    private void setup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event){
        BiomeInit.registerBiomes();
    }

    @SubscribeEvent
    public void doClientStuff(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(RegistryHandler.SKY_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.SKY_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.SKY_GRASS.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.LILAC_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.LILAC_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.LILAC_GRASS.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.FIRE_BLOSSOM_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.FIRE_BLOSSOM_LEAVES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.FIRE_GRASS.get(),RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.SWIRLING_VINES.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.BLAZE_SPROUT.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(RegistryHandler.VIOLET_BLOOM.get(), RenderType.getCutout());
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {

        generateOre();
    }

    public static final ItemGroup TAB = new ItemGroup("ShinyTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RegistryHandler.SAPPHIRE.get());
        }
    };
}