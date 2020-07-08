package com.maisalae.shiningsapphires.items;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import com.maisalae.shiningsapphires.util.helpers.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemTopazAmethystSword extends SwordItem {
    public ItemTopazAmethystSword() {
        super(new IItemTier() {
            @Override
            public int getMaxUses() {
                return 1929;
            }

            @Override
            public float getEfficiency() {
                return 9;
            }

            @Override
            public float getAttackDamage() {
                return 6;
            }

            @Override
            public int getHarvestLevel() {
                return 3;
            }

            @Override
            public int getEnchantability() {
                return 56;
            }

            @Override
            public Ingredient getRepairMaterial() {
                return Ingredient.fromItems(RegistryHandler.TOPAZ.get());
            }
        }, 3, -2.2f, new Properties().group(ShiningSapphires.TAB));
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        ItemStack.addEnchantmentTooltips(tooltip, getEnchantments(stack));
        if(KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("The rare "+"\u00A74"+"Flame Topaz"));
            tooltip.add(new StringTextComponent("imbued in this sword"));
            tooltip.add(new StringTextComponent("gives it a fiery kick!"));
        } else {
            tooltip.add(new StringTextComponent("Hold "+"\u00A7b"+"SHIFT"));
            tooltip.add(new StringTextComponent("for more information!"));
        }
        addFireAspect(stack);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        addFireAspect(stack);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        addFireAspect(stack);
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    public static ListNBT getEnchantments(ItemStack stack) {
        CompoundNBT compoundnbt = stack.getTag();
        return compoundnbt != null ? compoundnbt.getList("StoredEnchantments", 10) : new ListNBT();
    }

    private void addFireAspect(ItemStack stack) {
        if (!stack.isEnchanted()) {
            stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
        } else {
            if (EnchantmentHelper.getEnchantments(stack).get(Enchantments.FIRE_ASPECT) == null) {
                stack.addEnchantment(Enchantments.FIRE_ASPECT, 2);
            }
        }
    }
}
