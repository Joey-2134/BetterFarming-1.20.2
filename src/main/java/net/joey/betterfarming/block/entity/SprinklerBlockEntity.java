package net.joey.betterfarming.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;

public class SprinklerBlockEntity extends BlockEntity {
    private int rotation = 0;

    public SprinklerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SPRINKLER_BLOCK_ENTITY, pos, state);
    }

    public void tick() {
        if (world != null && !world.isClient) {
            rotation = (rotation + 1) % 360;
            world.setBlockState(pos, getCachedState().with(Properties.ROTATION, rotation), 3);
        }
    }

    public int getRotation() {
        return rotation;
    }
}
