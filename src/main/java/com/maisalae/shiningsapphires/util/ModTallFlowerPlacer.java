package com.maisalae.shiningsapphires.util;


import com.google.common.collect.ImmutableMap;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.blockplacer.BlockPlacer;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;

public class ModTallFlowerPlacer extends BlockPlacer {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public ModTallFlowerPlacer() {
        super(BlockPlacerType.SIMPLE_BLOCK);
    }

    public <T> ModTallFlowerPlacer(Dynamic<T> p_i225829_1_) {
        this();
    }
    // note to self: next time you do something like this, fucking comment it properly, Yas. it took so long for you to
    // figure this out and you didn't comment it so now future you is still none the wiser. the functions never
    // got de-obfuscated so still got no idea what these are doing. I know I used to know, but that doesn't help me now.
    // stop being a silly little sausage and comment properly next time!!!!
    public void func_225567_a_(IWorld worldIn, BlockPos pos, BlockState state, Random random) {
        worldIn.setBlockState(pos, state.with(HALF, DoubleBlockHalf.LOWER), 2);
        worldIn.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 2);
    }
    public <T> T serialize(DynamicOps<T> p_218175_1_) {
        return (new Dynamic<>(p_218175_1_, p_218175_1_.createMap(ImmutableMap.of(p_218175_1_.createString("type"), p_218175_1_.createString(Registry.BLOCK_PLACER_TYPE.getKey(this.field_227258_a_).toString()))))).getValue();
    }
}
