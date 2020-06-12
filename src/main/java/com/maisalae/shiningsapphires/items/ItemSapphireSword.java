package com.maisalae.shiningsapphires.items;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;

public class ItemSapphireSword extends SwordItem {
    public ItemSapphireSword() {
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
                return 4;
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
        }, 3, -2.2f, new Properties().group(ShiningSapphires.TAB));
    }
}
