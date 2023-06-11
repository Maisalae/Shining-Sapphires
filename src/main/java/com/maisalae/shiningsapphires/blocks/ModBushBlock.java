package com.maisalae.shiningsapphires.blocks;

import com.maisalae.shiningsapphires.ShiningSapphires;
import com.maisalae.shiningsapphires.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.PlantType;

public class ModBushBlock extends Block implements net.minecraftforge.common.IPlantable {
    private PlantType plantType;
    public ModBushBlock(Block.Properties properties, PlantType plantTypeIn) {
        super(properties);
        this.plantType = plantTypeIn;
    }

    @Override
    public PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return plantType;
    }

    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        // if the plant is of a given type, it can only be planted on its corresponding pasture type.
        // if the player attempts to plant it on another block, then this returns false.
        Block block = state.getBlock();
        if(plantType == ShiningSapphires.SKY){
            return block == RegistryHandler.SKY_PASTURE.get();
        } else if (plantType == ShiningSapphires.LILAC) {
            return block == RegistryHandler.LILAC_PASTURE.get();
        } else if (plantType == ShiningSapphires.FIRE) {
            return block == RegistryHandler.FIRE_PASTURE.get();
        } else {
            return false;
        }
    }
    @Override
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        return !stateIn.isValidPosition(worldIn, currentPos) ? Blocks.AIR.getDefaultState() : super.updatePostPlacement(stateIn, facing, facingState, worldIn, currentPos, facingPos);
    }
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
            return worldIn.getBlockState(blockpos).canSustainPlant(worldIn, blockpos, Direction.UP, this);
        return this.isValidGround(worldIn.getBlockState(blockpos), worldIn, blockpos);
    }

    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        return true;
    }

    @Override
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        return type == PathType.AIR && !this.blocksMovement ? true : super.allowsMovement(state, worldIn, pos, type);
    }

    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }
}