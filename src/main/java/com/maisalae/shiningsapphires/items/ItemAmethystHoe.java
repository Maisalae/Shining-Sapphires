package com.maisalae.shiningsapphires.items;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public class ItemAmethystHoe extends HoeItem {
    public ItemAmethystHoe() {
        super(new IItemTier() {
            @Override
            public int getMaxUses() {
                return 1729;
            }

            @Override
            public float getEfficiency() {
                return 9;
            }

            @Override
            public float getAttackDamage() {
                return 1;
            }

            @Override
            public int getHarvestLevel() {
                return 3;
            }

            @Override
            public int getEnchantability() {
                return 36;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return Ingredient.fromItems(RegistryHandler.AMETHYST.get());
            }
        }, 0, new Properties().group(ShiningSapphires.TAB));
    }
}
