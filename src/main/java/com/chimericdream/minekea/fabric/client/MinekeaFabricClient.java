package com.chimericdream.minekea.fabric.client;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.decorations.DecorationBlocks;
import com.chimericdream.minekea.block.decorations.FakeCakeBlock;
import com.chimericdream.minekea.block.furniture.tables.TableBlock;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.client.MinekeaClient;
import com.chimericdream.minekea.fabric.client.render.block.FabricGlassJarBlockEntityRenderer;
import com.chimericdream.minekea.item.tools.BlockPainterItem;
import com.chimericdream.minekea.item.tools.HammerItem;
import com.chimericdream.minekea.network.CyclePainterColorPayload;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;
import static com.chimericdream.minekea.client.Keybindings.CYCLE_PAINTER_COLOR;

public final class MinekeaFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MinekeaClient.initializeClientRegistries();
        MinekeaClient.onInitializeClient();
        MinekeaClient.registerEntityRenderers();
        MinekeaClient.registerBlockEntityRenderers();

        initializeBlockRenderLayers();
        initializeKeybindings();
        initializeTooltips();
    }

    private void initializeTooltips() {
        ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
            if (itemStack.getItem() instanceof HammerItem hammer) {
                list.addAll(hammer.getTooltip());
                return;
            }

            if (itemStack.getItem() instanceof BlockPainterItem painter) {
                list.addAll(painter.getTooltip(itemStack));
                return;
            }

            Holder<Item> registryEntry = itemStack.typeHolder();

            if (registryEntry.is(REGISTRY_HELPER.makeItemRegistryKey(FakeCakeBlock.BLOCK_ID))) {
                list.addAll(((FakeCakeBlock) DecorationBlocks.FAKE_CAKE.get()).getTooltip());
                return;
            }

            if (registryEntry.is(key -> key.toString().contains("minekea:") && key.toString().contains("table"))) {
                list.addAll(((TableBlock) Tables.BLOCKS.getFirst().get()).getTooltip());
                return;
            }
        });
    }

    private void initializeBlockRenderLayers() {
        BlockEntityRendererRegistry.register(
            ContainerBlocks.GLASS_JAR_BLOCK_ENTITY.get(),
            FabricGlassJarBlockEntityRenderer::new
        );
    }

    private void initializeKeybindings() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (CYCLE_PAINTER_COLOR.isDown()) {
                ClientPlayNetworking.send(new CyclePainterColorPayload(true));
            }
        });
    }
}
