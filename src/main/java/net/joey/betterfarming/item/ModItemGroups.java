package net.joey.betterfarming.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BETTER_FARMING_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(BetterFarming.MOD_ID, "better_farming"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.better_farming"))
                    .icon(() -> new ItemStack(ModItems.TOMATO)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModBlocks.SPRINKLER);
                    }).build());


    public static void registerItemGroups() {
        BetterFarming.LOGGER.info("Registering Item Groups for " + BetterFarming.MOD_ID);
    }
}