package net.joey.betterfarming.mixin;

import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FarmlandBlock.class)
public class MixinFarmlandBlock {
    @Inject(method = "isWaterNearby", at = @At("HEAD"), cancellable = true)
    private static void onIsWaterNearby(WorldView world, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-1, 1, -1), pos.add(1, 1, 1))) {
            if (world.getBlockState(blockPos).isOf(ModBlocks.SPRINKLER)) {
                cir.setReturnValue(true);
                break;
            }
        }
    }
}
