package net.joey.betterfarming.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.joey.betterfarming.block.ModBlocks;
import net.joey.betterfarming.block.custom.TomatoCropBlock;
import net.joey.betterfarming.item.ModItems;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.predicate.StatePredicate;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, 5));
        LootPool.Builder tomatoPool = LootPool.builder()
                .with(ItemEntry.builder(ModItems.TOMATO)).conditionally(builder)
                .with(ItemEntry.builder(ModItems.TOMATO).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3)));

        LootPool.Builder seedPool = LootPool.builder()
                .with(ItemEntry.builder(ModItems.TOMATO_SEEDS))
                .conditionally(builder)
                .with(ItemEntry.builder(ModItems.TOMATO_SEEDS).apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3)));

        addDrop(ModBlocks.TOMATO_CROP, LootTable.builder().pool(tomatoPool).pool(seedPool));

    }
}
