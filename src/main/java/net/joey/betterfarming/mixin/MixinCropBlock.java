package net.joey.betterfarming.mixin;

import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CropBlock.class)
public class MixinCropBlock {
    @Inject(method = "canPlantOnTop", at = @At("HEAD"), cancellable = true)
    private void onCanPlantOnTop(BlockState floor, BlockView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (floor.isOf(Blocks.FARMLAND) || floor.isOf(ModBlocks.FERTILE_FARMLAND)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "getGrowthAmount", at = @At("HEAD"), cancellable = true)
    private void onGetGrowthAmount(World world, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(MathHelper.nextInt(world.random, 6, 7));
    }

}
