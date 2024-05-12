package net.joey.betterfarming.block.entity.renderer;

import net.joey.betterfarming.block.entity.SprinklerBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import org.joml.Quaternionf;

public class SprinklerBlockEntityRenderer implements BlockEntityRenderer<SprinklerBlockEntity> {
    public SprinklerBlockEntityRenderer(BlockEntityRendererFactory.Context context) {

    }

    @Override
    public void render(SprinklerBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        
    }
}
