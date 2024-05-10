package net.joey.betterfarming.mixin;

import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public abstract class MixinCropBlock extends Block {
    public MixinCropBlock(Settings settings) {
        super(settings);
    }

    @Shadow public abstract int getAge(BlockState state);

    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void onCanPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.isOf(Blocks.FARMLAND) || floor.isOf(ModBlocks.FERTILE_FARMLAND)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getGrowthAmount", at = @At("HEAD"), cancellable = true)
    private void onGetGrowthAmount(World world, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(MathHelper.nextInt(world.random, 3, 6));
    }

    @Invoker("getAvailableMoisture")
    public abstract float invokeGetAvailableMoisture(Block block, BlockView world, BlockPos pos);

    @Inject(method = "randomTick", at = @At("HEAD"))
    private void onRandomTick(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo cir) {
        float moisture = this.invokeGetAvailableMoisture((Block)(Object)this, world, pos);
        int currentAge = this.getAge(state);
        BlockState blockBelow = world.getBlockState(pos.down());

        if (shouldGrow(world, pos, currentAge, moisture, random)) {
            int growthIncrement = blockBelow.isOf(ModBlocks.FERTILE_FARMLAND) ? 2 : 1;
            growCrop(world, pos, currentAge, growthIncrement);
        }
    }

    @Unique
    private boolean shouldGrow(ServerWorld world, BlockPos pos, int currentAge, float moisture, Random random) {
        return world.getBaseLightLevel(pos, 0) >= 9
                && currentAge < this.getMaxAge()
                && random.nextInt((int)(25.0f / moisture) + 1) == 0;
    }

    @Unique
    private void growCrop(ServerWorld world, BlockPos pos, int currentAge, int growthIncrement) {
        world.setBlockState(pos, ((CropBlock)(Object)this).withAge(currentAge + growthIncrement), Block.NOTIFY_LISTENERS);
    }

    @Shadow
    public abstract int getMaxAge();

}
