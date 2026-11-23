package com.example.aluminumconstruct.client;

import com.example.aluminumconstruct.AluminumConstruct;
import com.example.aluminumconstruct.entity.AluminumGolemEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.IronGolemEntityModel;
import net.minecraft.util.Identifier;

public class AluminumConstructClient implements ClientModInitializer {
    private static final Identifier TEXTURE = Identifier.of(AluminumConstruct.MOD_ID, "textures/entity/aluminum_golem.png");
    @Override public void onInitializeClient() {
        EntityRendererRegistry.register(AluminumConstruct.ALUMINUM_GOLEM, context ->
                new MobEntityRenderer<>(context, new IronGolemEntityModel<AluminumGolemEntity>(context.getPart(EntityModelLayers.IRON_GOLEM)), 0.7f) {
                    @Override public Identifier getTexture(AluminumGolemEntity entity) { return TEXTURE; }
                });
    }
}
