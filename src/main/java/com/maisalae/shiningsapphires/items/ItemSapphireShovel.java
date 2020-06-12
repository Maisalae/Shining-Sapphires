package com.maisalae.shiningsapphires.items;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.crafting.Ingredient;

public class ItemSapphireShovel extends ShovelItem {
    public ItemSapphireShovel() {
        super(new IItemTier() {
            @Override
            public int getMaxUses() {
                return 1796;
            }

            @Override
            public float getEfficiency() {
                return 9;
            }

            @Override
            public float getAttackDamage() {
                return 2;
            }

            @Override
            public int getHarvestLevel() {
                return 3;
            }

            @Override
            public int getEnchantability() {
                return 25;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return Ingredient.fromItems(RegistryHandler.SAPPHIRE.get());
            }
        }, 3, -3.0f, new Properties().group(ShiningSapphires.TAB));
    }
}
