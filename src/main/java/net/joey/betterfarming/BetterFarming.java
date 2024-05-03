package net.joey.betterfarming;

import net.fabricmc.api.ModInitializer;

import net.joey.betterfarming.block.ModBlocks;
import net.joey.betterfarming.item.ModItemGroups;
import net.joey.betterfarming.item.ModItems;
import net.joey.betterfarming.sound.ModSounds;
import net.joey.betterfarming.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterFarming implements ModInitializer {
	public static final String MOD_ID = "betterfarming";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModSounds.registerSounds();
		//ModRecipes.registerRecipes();
		ModWorldGeneration.generateModWorldGen();
	}
}