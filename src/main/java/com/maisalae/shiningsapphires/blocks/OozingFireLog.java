package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class OozingFireLog extends LogBlock {
    private BlockState logState = null;
    public OozingFireLog() {
        super(MaterialColor.ORANGE_TERRACOTTA, Properties.from(Blocks.STRIPPED_OAK_LOG));
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack topazStack = new ItemStack(RegistryHandler.TOPAZ_SAP.get());
        ItemStack bottleStack = player.getHeldItem(handIn);
        if (bottleStack.getItem()==Items.GLASS_BOTTLE) {
            bottleStack.grow(-1);
            if(bottleStack.isEmpty()) {
                if (handIn == Hand.MAIN_HAND) {
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, topazStack);
                } else {
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, topazStack);
                }
            } else {
                if (handIn == Hand.MAIN_HAND) {
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, bottleStack);
                }
                else {
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, bottleStack);
                }
                if (!player.addItemStackToInventory(topazStack)) {
                    player.dropItem(topazStack,false);
                }
                player.addStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
            }
            worldIn.setBlockState(pos, RegistryHandler.STRIPPED_FIRE_BLOSSOM_LOG.get().getDefaultState());
        }
            return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
