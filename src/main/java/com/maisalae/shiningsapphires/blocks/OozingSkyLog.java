package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.Block;
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
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

public class OozingSkyLog extends LogBlock {
    public OozingSkyLog() {
        super(MaterialColor.CYAN, Block.Properties.from(Blocks.STRIPPED_OAK_LOG));
    }
    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        ItemStack sapphireStack = new ItemStack(RegistryHandler.SAPPHIRE_SAP.get());
        ItemStack bottleStack = player.getHeldItem(handIn);
        if (bottleStack.getItem()== Items.GLASS_BOTTLE) {
            bottleStack.grow(-1);
            if(bottleStack.isEmpty()) {
                if (handIn == Hand.MAIN_HAND) {
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, sapphireStack);
                } else {
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, sapphireStack);
                }
            } else {
                if (handIn == Hand.MAIN_HAND) {
                    player.setItemStackToSlot(EquipmentSlotType.MAINHAND, bottleStack);
                }
                else {
                    player.setItemStackToSlot(EquipmentSlotType.OFFHAND, bottleStack);
                }
                if (!player.addItemStackToInventory(sapphireStack)) {
                    player.dropItem(sapphireStack,false);
                }
                player.addStat(Stats.ITEM_USED.get(Items.GLASS_BOTTLE));
            }
            worldIn.setBlockState(pos, RegistryHandler.STRIPPED_SKY_BLOSSOM_LOG.get().getDefaultState());
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }
}
