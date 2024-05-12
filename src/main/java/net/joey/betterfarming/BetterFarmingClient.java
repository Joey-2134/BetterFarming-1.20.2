package net.joey.betterfarming;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.joey.betterfarming.block.ModBlocks;
import net.joey.betterfarming.block.entity.ModBlockEntities;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.joey.betterfarming.block.entity.renderer.SprinklerBlockEntityRenderer;

public class BetterFarmingClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SPRINKLER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FERTILE_FARMLAND, RenderLayer.getCutout());
        BlockEntityRendererFactories.register(ModBlockEntities.SPRINKLER_BLOCK_ENTITY, SprinklerBlockEntityRenderer::new);
    }
}
