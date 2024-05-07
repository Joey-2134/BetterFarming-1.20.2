package net.joey.betterfarming.item.custom;

import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class Fertiliser extends Item {
    public Fertiliser(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            BlockState block = context.getWorld().getBlockState(positionClicked);

            if (block.getBlock() == Blocks.FARMLAND) {
                context.getWorld().setBlockState(positionClicked, ModBlocks.FERTILE_FARMLAND.getDefaultState()); //TODO REPLACE SAND WITH FERTILE FARMLAND
            }

        }

        context.getStack().damage(1, context.getPlayer(),
                playerEntity -> playerEntity.sendToolBreakStatus(playerEntity.getActiveHand()));

        return ActionResult.SUCCESS;
    }
}
