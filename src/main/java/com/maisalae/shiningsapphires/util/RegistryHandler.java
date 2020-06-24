package com.maisalae.shiningsapphires.util;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.blocks.*;
import com.maisalae.shiningsapphires.items.*;
import com.maisalae.shiningsapphires.world.feature.FireBlossomTree;
import com.maisalae.shiningsapphires.world.feature.LilacBlossomTree;
import com.maisalae.shiningsapphires.world.feature.SkyBlossomTree;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ShiningSapphires.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ShiningSapphires.MOD_ID);



    public static void init() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    // Items
    // -----------------------------------------------------------------------------------------------------------------
    // Sapphire
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", ItemSapphire::new);
    public static final RegistryObject<Item> SAPPHIRE_ROD = ITEMS.register("sapphire_rod", ItemBase::new);
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", ItemSapphireSword::new);
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", ItemSapphirePickaxe::new);
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", ItemSapphireAxe::new);
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",ItemSapphireShovel::new);
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", ItemSapphireHoe::new);
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet",
            () -> new ItemArmor(ModArmorMaterial.SAPPHIRE,EquipmentSlotType.HEAD, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate",
            () -> new ItemArmor(ModArmorMaterial.SAPPHIRE,EquipmentSlotType.CHEST, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings",
            () -> new ItemArmor(ModArmorMaterial.SAPPHIRE,EquipmentSlotType.LEGS, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots",
            () -> new ItemArmor(ModArmorMaterial.SAPPHIRE,EquipmentSlotType.FEET, new Item.Properties().group(ShiningSapphires.TAB)));
    // Amethyst
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst",ItemAmethyst::new);
    public static final RegistryObject<Item> AMETHYST_ROD = ITEMS.register("amethyst_rod", ItemBase::new);
    public static final RegistryObject<Item> AMETHYST_SWORD = ITEMS.register("amethyst_sword", ItemAmethystSword::new);
    public static final RegistryObject<Item> AMETHYST_PICKAXE = ITEMS.register("amethyst_pickaxe", ItemAmethystPickaxe::new);
    public static final RegistryObject<Item> AMETHYST_AXE = ITEMS.register("amethyst_axe", ItemAmethystAxe::new);
    public static final RegistryObject<Item> AMETHYST_SHOVEL = ITEMS.register("amethyst_shovel",ItemAmethystShovel::new);
    public static final RegistryObject<Item> AMETHYST_HOE = ITEMS.register("amethyst_hoe", ItemAmethystHoe::new);
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new ItemArmor(ModArmorMaterial.AMETHYST,EquipmentSlotType.HEAD, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new ItemArmor(ModArmorMaterial.AMETHYST,EquipmentSlotType.CHEST, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new ItemArmor(ModArmorMaterial.AMETHYST,EquipmentSlotType.LEGS, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new ItemArmor(ModArmorMaterial.AMETHYST,EquipmentSlotType.FEET, new Item.Properties().group(ShiningSapphires.TAB)));
    // Topaz
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz",ItemTopaz::new);
    public static final RegistryObject<Item> TOPAZ_SAPPHIRE_CHESTPLATE = ITEMS.register("topaz_sapphire_chestplate",
            () -> new ItemArmor(ModArmorMaterial.TOPAZ_SAPPHIRE,EquipmentSlotType.CHEST, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> TOPAZ_AMETHYST_CHESTPLATE = ITEMS.register("topaz_amethyst_chestplate",
            () -> new ItemArmor(ModArmorMaterial.TOPAZ_AMETHYST,EquipmentSlotType.CHEST, new Item.Properties().group(ShiningSapphires.TAB)));
    public static final RegistryObject<Item> TOPAZ_SAPPHIRE_SWORD = ITEMS.register("topaz_sapphire_sword", ItemTopazSapphireSword::new);
    public static final RegistryObject<Item> TOPAZ_AMETHYST_SWORD = ITEMS.register("topaz_amethyst_sword", ItemTopazAmethystSword::new);
    // Blossom Trees
    public static final RegistryObject<Item> SAPPHIRE_SAP = ITEMS.register("sapphire_sap",ItemBase::new);
    public static final RegistryObject<Item> AMETHYST_SAP = ITEMS.register("amethyst_sap",ItemBase::new);
    public static final RegistryObject<Item> TOPAZ_SAP = ITEMS.register("topaz_sap", ItemBase::new);

    // Blocks
    // -----------------------------------------------------------------------------------------------------------------
    // Sapphire
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", SapphireBlock::new);
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", SapphireOre::new);
    // Amethyst
    public static final RegistryObject<Block> AMETHYST_BLOCK = BLOCKS.register("amethyst_block", AmethystBlock::new);
    public static final RegistryObject<Block> AMETHYST_ORE = BLOCKS.register("amethyst_ore", AmethystOre::new);
    // Topaz
    public static final RegistryObject<Block> TOPAZ_BLOCK = BLOCKS.register("topaz_block", TopazBlock::new);
    public static final RegistryObject<Block> TOPAZ_ORE = BLOCKS.register("topaz_ore", TopazOre::new);
    // Sky Blossom
    public static final RegistryObject<Block> SKY_PASTURE = BLOCKS.register("sky_pasture",
            SkyPasture::new);
    public static final RegistryObject<Block> SKY_GRASS = BLOCKS.register("sky_grass",
            () -> new ModBushBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.LIGHT_BLUE_TERRACOTTA).doesNotBlockMovement()));
    public static final RegistryObject<Block> SKY_BLOSSOM_PLANKS = BLOCKS.register("sky_blossom_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> SKY_BLOSSOM_LOG = BLOCKS.register("sky_blossom_log",
            () -> new StrippableSkyLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_SKY_BLOSSOM_LOG = BLOCKS.register("stripped_sky_blossom_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> OOZING_SKY_BLOSSOM_LOG = BLOCKS.register("oozing_sky_blossom_log", OozingSkyLog::new);
    public static final RegistryObject<Block> SKY_BLOSSOM_LEAVES = BLOCKS.register("sky_blossom_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> SKY_BLOSSOM_SAPLING = BLOCKS.register("sky_blossom_sapling",
            () -> new ModSaplingBlock(SkyBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING), SKY_PASTURE.get()));
    // Lilac Blossom
    public static final RegistryObject<Block> LILAC_PASTURE = BLOCKS.register("lilac_pasture", LilacPasture::new);
    public static final RegistryObject<Block> LILAC_GRASS = BLOCKS.register("lilac_grass",
            () -> new ModBushBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.PURPLE_TERRACOTTA).doesNotBlockMovement()));
    public static final RegistryObject<Block> LILAC_BLOSSOM_PLANKS = BLOCKS.register("lilac_blossom_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> LILAC_BLOSSOM_LOG = BLOCKS.register("lilac_blossom_log",
            () -> new StrippableLilacLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_LILAC_BLOSSOM_LOG = BLOCKS.register("stripped_lilac_blossom_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> OOZING_LILAC_BLOSSOM_LOG = BLOCKS.register("oozing_lilac_blossom_log", OozingLilacLog::new);
    public static final RegistryObject<Block> LILAC_BLOSSOM_LEAVES = BLOCKS.register("lilac_blossom_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> LILAC_BLOSSOM_SAPLING = BLOCKS.register("lilac_blossom_sapling",
            () -> new ModSaplingBlock(LilacBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING), LILAC_PASTURE.get()));
    // Fire Blossom
    public static final RegistryObject<Block> FIRE_PASTURE = BLOCKS.register("fire_pasture",FirePasture::new);
    public static final RegistryObject<Block> FIRE_GRASS = BLOCKS.register("fire_grass",
            () -> new ModBushBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.ORANGE_TERRACOTTA).doesNotBlockMovement()));
    public static final RegistryObject<Block> FIRE_BLOSSOM_PLANKS = BLOCKS.register("fire_blossom_planks",
            () -> new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> FIRE_BLOSSOM_LOG = BLOCKS.register("fire_blossom_log",
            () -> new StrippableFireLog(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_FIRE_BLOSSOM_LOG = BLOCKS.register("stripped_fire_blossom_log",
            () -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> OOZING_FIRE_BLOSSOM_LOG = BLOCKS.register("oozing_fire_blossom_log", OozingFireLog::new);
    public static final RegistryObject<Block> FIRE_BLOSSOM_LEAVES = BLOCKS.register("fire_blossom_leaves",
            () -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FIRE_BLOSSOM_SAPLING = BLOCKS.register("fire_blossom_sapling",
            () -> new ModSaplingBlock(FireBlossomTree::new, Block.Properties.from(Blocks.OAK_SAPLING), FIRE_PASTURE.get()));

    // Block Items
    // -----------------------------------------------------------------------------------------------------------------
    // Sapphire
    public static final RegistryObject<Item> SAPPHIRE_BLOCK_ITEM = ITEMS.register("sapphire_block", () -> new BlockItemBase(SAPPHIRE_BLOCK.get()));
    public static final RegistryObject<Item> SAPPHIRE_ORE_ITEM = ITEMS.register("sapphire_ore", () -> new BlockItemBase(SAPPHIRE_ORE.get()));
    // Amethyst
    public static final RegistryObject<Item> AMETHYST_BLOCK_ITEM = ITEMS.register("amethyst_block", () -> new BlockItemBase(AMETHYST_BLOCK.get()));
    public static final RegistryObject<Item> AMETHYST_ORE_ITEM = ITEMS.register("amethyst_ore", () -> new BlockItemBase(AMETHYST_ORE.get()));
    // Topaz
    public static final RegistryObject<Item> TOPAZ_BLOCK_ITEM = ITEMS.register("topaz_block", () -> new BlockItemBase(TOPAZ_BLOCK.get()));
    public static final RegistryObject<Item> TOPAZ_ORE_ITEM = ITEMS.register("topaz_ore", () -> new BlockItemBase(TOPAZ_ORE.get()));
    // Sky Blossom
    public static final RegistryObject<Item> SKY_BLOSSOM_PLANKS_ITEM = ITEMS.register("sky_blossom_planks",
            () -> new BlockItemBase(SKY_BLOSSOM_PLANKS.get()));
    public static final RegistryObject<Item> SKY_BLOSSOM_LOG_ITEM = ITEMS.register("sky_blossom_log",
            () -> new BlockItemBase(SKY_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_SKY_BLOSSOM_LOG_ITEM = ITEMS.register("stripped_sky_blossom_log",
            () -> new BlockItemBase(STRIPPED_SKY_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> OOZING_SKY_BLOSSOM_LOG_ITEM = ITEMS.register("oozing_sky_blossom_log",
            ()-> new BlockItemBase(OOZING_SKY_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> SKY_BLOSSOM_LEAVES_ITEM = ITEMS.register("sky_blossom_leaves",
            () -> new BlockItemBase(SKY_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> SKY_BLOSSOM_SAPLING_ITEM = ITEMS.register("sky_blossom_sapling",
            ()-> new BlockItemBase(SKY_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> SKY_PASTURE_ITEM = ITEMS.register("sky_pasture",
        () -> new BlockItemBase(SKY_PASTURE.get()));
    public static final RegistryObject<Item> SKY_GRASS_ITEM = ITEMS.register("sky_grass",
            () -> new BlockItemBase(SKY_GRASS.get()));
    // Lilac Blossom
    public static final RegistryObject<Item> LILAC_BLOSSOM_PLANKS_ITEM = ITEMS.register("lilac_blossom_planks",
            () -> new BlockItemBase(LILAC_BLOSSOM_PLANKS.get()));
    public static final RegistryObject<Item> LILAC_BLOSSOM_LOG_ITEM = ITEMS.register("lilac_blossom_log",
            () -> new BlockItemBase(LILAC_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_LILAC_BLOSSOM_LOG_ITEM = ITEMS.register("stripped_lilac_blossom_log",
            () -> new BlockItemBase(STRIPPED_LILAC_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> OOZING_LILAC_BLOSSOM_LOG_ITEM = ITEMS.register("oozing_lilac_blossom_log",
            ()-> new BlockItemBase(OOZING_LILAC_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> LILAC_BLOSSOM_LEAVES_ITEM = ITEMS.register("lilac_blossom_leaves",
            () -> new BlockItemBase(LILAC_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> LILAC_BLOSSOM_SAPLING_ITEM = ITEMS.register("lilac_blossom_sapling",
            ()-> new BlockItemBase(LILAC_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> LILAC_PASTURE_ITEM = ITEMS.register("lilac_pasture",
            () -> new BlockItemBase(LILAC_PASTURE.get()));
    public static final RegistryObject<Item> LILAC_GRASS_ITEM = ITEMS.register("lilac_grass",
            () -> new BlockItemBase(LILAC_GRASS.get()));
    // Fire Blossom
    public static final RegistryObject<Item> FIRE_BLOSSOM_PLANKS_ITEM = ITEMS.register("fire_blossom_planks",
            () -> new BlockItemBase(FIRE_BLOSSOM_PLANKS.get()));
    public static final RegistryObject<Item> FIRE_BLOSSOM_LOG_ITEM = ITEMS.register("fire_blossom_log",
            () -> new BlockItemBase(FIRE_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> STRIPPED_FIRE_BLOSSOM_LOG_ITEM = ITEMS.register("stripped_fire_blossom_log",
            () -> new BlockItemBase(STRIPPED_FIRE_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> OOZING_FIRE_BLOSSOM_LOG_ITEM = ITEMS.register("oozing_fire_blossom_log",
            ()-> new BlockItemBase(OOZING_FIRE_BLOSSOM_LOG.get()));
    public static final RegistryObject<Item> FIRE_BLOSSOM_LEAVES_ITEM = ITEMS.register("fire_blossom_leaves",
            () -> new BlockItemBase(FIRE_BLOSSOM_LEAVES.get()));
    public static final RegistryObject<Item> FIRE_BLOSSOM_SAPLING_ITEM = ITEMS.register("fire_blossom_sapling",
            ()-> new BlockItemBase(FIRE_BLOSSOM_SAPLING.get()));
    public static final RegistryObject<Item> FIRE_PASTURE_ITEM = ITEMS.register("fire_pasture",
            () -> new BlockItemBase(FIRE_PASTURE.get()));
    public static final RegistryObject<Item> FIRE_GRASS_ITEM = ITEMS.register("fire_grass",
            () -> new BlockItemBase(FIRE_GRASS.get()));

    // Armor Material
    // -----------------------------------------------------------------------------------------------------------------
    public enum ModArmorMaterial implements IArmorMaterial {

        SAPPHIRE(ShiningSapphires.MOD_ID+":sapphire", 49, new int[] {3,6,8,3},25,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> {
            return Ingredient.fromItems(com.maisalae.shiningsapphires.util.RegistryHandler.SAPPHIRE.get());
        }),
        AMETHYST(ShiningSapphires.MOD_ID+":amethyst", 44, new int[] {3,6,8,3},36,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0f, () -> {
            return Ingredient.fromItems(com.maisalae.shiningsapphires.util.RegistryHandler.AMETHYST.get());
        }),
        TOPAZ_SAPPHIRE(ShiningSapphires.MOD_ID+":topaz_sapphire", 59, new int[] {3,6,8,3},45,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0f, () -> {
            return Ingredient.fromItems(com.maisalae.shiningsapphires.util.RegistryHandler.TOPAZ.get());
        }),
        TOPAZ_AMETHYST(ShiningSapphires.MOD_ID+":topaz_amethyst", 54, new int[] {3,6,8,3},56,SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0f, () -> {
            return Ingredient.fromItems(com.maisalae.shiningsapphires.util.RegistryHandler.TOPAZ.get());
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {8,11,10,9};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

         ModArmorMaterial(String nameIn, int maxDamageFactorIn,
                                 int[] damageReductionAmountIn, int enchantabilityIn,
                                 SoundEvent soundEventIn, float toughnessIn,
                                 Supplier<Ingredient> repairMaterialIn){
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantabilityIn;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            // gets the max damage value for the particular slot (i.e. helmet, chest etc.)
            // then multiplies by max damage factor to get durability
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()]*this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public SoundEvent getSoundEvent() {
            return this.soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public float getToughness() {
            return this.toughness;
        }
    }
}
