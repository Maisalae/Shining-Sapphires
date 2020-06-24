package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class StrippableFireLog extends LogBlock {
    private Random rand = new Random();
    private double sapProbability = 0.0625;
    private BlockState oozingState = null;
    private BlockState strippedState = null;
    public StrippableFireLog(MaterialColor colorIn, Properties properties) {
        super(colorIn, properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
                                             Hand handIn, BlockRayTraceResult hit) {
        if(player.getHeldItem(handIn) != ItemStack.EMPTY) {
            Item item = player.getHeldItem(handIn).getItem();
            if(item == Items.DIAMOND_AXE || item == Items.IRON_AXE || item == Items.GOLDEN_AXE || item == Items.WOODEN_AXE
                    || item == Items.STONE_AXE || item == RegistryHandler.SAPPHIRE_AXE.get()
                    || item == RegistryHandler.AMETHYST_AXE.get()) {
                if (state.get(AXIS) == Direction.Axis.X){
                    System.out.println("X axis");
                    oozingState = RegistryHandler.OOZING_FIRE_BLOSSOM_LOG.get().getDefaultState().with(AXIS, Direction.Axis.X);
                    strippedState = RegistryHandler.STRIPPED_FIRE_BLOSSOM_LOG.get().getDefaultState().with(AXIS, Direction.Axis.X);
                } else if (state.get(AXIS) == Direction.Axis.Z){
                    System.out.println("Z axis");
                    oozingState =  RegistryHandler.OOZING_FIRE_BLOSSOM_LOG.get().getDefaultState().with(AXIS, Direction.Axis.Z);
                    strippedState = RegistryHandler.STRIPPED_FIRE_BLOSSOM_LOG.get().getDefaultState().with(AXIS, Direction.Axis.Z);
                } else {
                    System.out.println("Y axis");
                    oozingState = RegistryHandler.OOZING_FIRE_BLOSSOM_LOG.get().getDefaultState();
                    strippedState = RegistryHandler.STRIPPED_FIRE_BLOSSOM_LOG.get().getDefaultState();
                }
                // if a randomly generated number between 0 and 1 is less than the sap probability,
                // then the stripped log is an oozing log instead
                if(rand.nextDouble()<=sapProbability){
                    worldIn.setBlockState(pos, oozingState);
                } else {
                    worldIn.setBlockState(pos, strippedState);
                }
                worldIn.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 0.7F, 1F);
            }
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

}