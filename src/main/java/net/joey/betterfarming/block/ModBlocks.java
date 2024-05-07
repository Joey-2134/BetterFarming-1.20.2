package net.joey.betterfarming.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.custom.FertileFarmlandBlock;
import net.joey.betterfarming.block.custom.SprinklerBlock;
import net.joey.betterfarming.block.custom.TomatoCropBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block TOMATO_CROP = Registry.register(Registries.BLOCK, new Identifier(BetterFarming.MOD_ID, "tomato_crop"),
            new TomatoCropBlock(FabricBlockSettings.copyOf(Blocks.POTATOES)));

    public static final Block SPRINKLER = registerBlock("sprinkler",
            new SprinklerBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.METAL).nonOpaque()));

    public static final Block FERTILE_FARMLAND = registerBlock("fertile_farmland",
            new FertileFarmlandBlock(FabricBlockSettings.copyOf(Blocks.FARMLAND).ticksRandomly()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(BetterFarming.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(BetterFarming.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        BetterFarming.LOGGER.info("Registering ModBlocks for " + BetterFarming.MOD_ID);
    }
}
