package net.joey.betterfarming.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.joey.betterfarming.BetterFarming;
import net.joey.betterfarming.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<SprinklerBlockEntity> SPRINKLER_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(BetterFarming.MOD_ID, "sprinkler_be"),
                    FabricBlockEntityTypeBuilder.create(SprinklerBlockEntity::new,
                            ModBlocks.SPRINKLER).build());

    public static void registerBlockEntities() {
        BetterFarming.LOGGER.info("Registering block entities for " + BetterFarming.MOD_ID);
    }
}
