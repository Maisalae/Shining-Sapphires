package com.maisalae.shiningsapphires.items;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemArmor extends ArmorItem {
    public ItemArmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }
    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (player.getItemStackFromSlot(EquipmentSlotType.HEAD) != ItemStack.EMPTY && player.getItemStackFromSlot(EquipmentSlotType.CHEST) != ItemStack.EMPTY &&
                player.getItemStackFromSlot(EquipmentSlotType.LEGS) != ItemStack.EMPTY && player.getItemStackFromSlot(EquipmentSlotType.FEET) != ItemStack.EMPTY) {
            ItemStack helmet = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            ItemStack plate = player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            ItemStack legs = player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            ItemStack boots = player.getItemStackFromSlot(EquipmentSlotType.FEET);

            //SAPPHIRE
            if (helmet.getItem().equals(RegistryHandler.SAPPHIRE_HELMET.get())
                    && legs.getItem().equals(RegistryHandler.SAPPHIRE_LEGGINGS.get())
                    && boots.getItem().equals(RegistryHandler.SAPPHIRE_BOOTS.get())) {
                if (plate.getItem().equals(RegistryHandler.SAPPHIRE_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,4,0));
                } else if (plate.getItem().equals(RegistryHandler.TOPAZ_SAPPHIRE_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,4,0));
                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,4,0));
                }
            }
            //AMETHYST
            if (helmet.getItem().equals(RegistryHandler.AMETHYST_HELMET.get())
                    && legs.getItem().equals(RegistryHandler.AMETHYST_LEGGINGS.get())
                    && boots.getItem().equals(RegistryHandler.AMETHYST_BOOTS.get())) {
                if (plate.getItem().equals(RegistryHandler.AMETHYST_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,4,0));
                } else if (plate.getItem().equals(RegistryHandler.TOPAZ_AMETHYST_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,4,0));
                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,4,0));
                }
            }

        }
    }
    /*
    if (player.inventory.armorItemInSlot(3) != ItemStack.EMPTY && player.inventory.armorItemInSlot(2) != ItemStack.EMPTY &&
                player.inventory.armorItemInSlot(1) != ItemStack.EMPTY && player.inventory.armorItemInSlot(0) != ItemStack.EMPTY) {
            ItemStack helmet = player.inventory.armorItemInSlot(3);
            ItemStack plate = player.inventory.armorItemInSlot(2);
            ItemStack legs = player.inventory.armorItemInSlot(1);
            ItemStack boots = player.inventory.armorItemInSlot(0);

            //SAPPHIRE
            if (helmet.getItem().equals(RegistryHandler.SAPPHIRE_HELMET.get())
                    && legs.getItem().equals(RegistryHandler.SAPPHIRE_LEGGINGS.get())
                    && boots.getItem().equals(RegistryHandler.SAPPHIRE_BOOTS.get())) {
                if (plate.getItem().equals(RegistryHandler.SAPPHIRE_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,4,0));
                } else if (plate.getItem().equals(RegistryHandler.TOPAZ_SAPPHIRE_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.STRENGTH,4,0));
                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,4,0));
                }
            }
            //AMETHYST
            if (helmet.getItem().equals(RegistryHandler.AMETHYST_HELMET.get())
                    && legs.getItem().equals(RegistryHandler.AMETHYST_LEGGINGS.get())
                    && boots.getItem().equals(RegistryHandler.AMETHYST_BOOTS.get())) {
                if (plate.getItem().equals(RegistryHandler.AMETHYST_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,4,0));
                } else if (plate.getItem().equals(RegistryHandler.TOPAZ_AMETHYST_CHESTPLATE.get())) {
                    player.addPotionEffect(new EffectInstance(Effects.RESISTANCE,4,0));
                    player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE,4,0));
                }
            }

        }
    }
     */
}
