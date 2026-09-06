package com.chimericdream.minekea.item;

import com.chimericdream.minekea.client.screen.BlockPainterScreenHandler;
import com.chimericdream.minekea.item.tools.BlockPainterItem;
import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Tools implements ModThingGroup {
    public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();

    public static final RegistrySupplier<Item> BLOCK_PAINTER_ITEM = REGISTRY_HELPER.registerItem(BlockPainterItem.ITEM_ID, BlockPainterItem::new);
    public static final RegistrySupplier<Item> WRENCH_ITEM = REGISTRY_HELPER.registerItem(WrenchItem.ITEM_ID, WrenchItem::new);

    public static final RegistrySupplier<MenuType<BlockPainterScreenHandler>> BLOCK_PAINTER_SCREEN_HANDLER = REGISTRY_HELPER.registerScreenHandler(BlockPainterScreenHandler.SCREEN_ID, () -> new MenuType<>(BlockPainterScreenHandler::new, FeatureFlagSet.of()));

    static {
        ITEMS.add(BLOCK_PAINTER_ITEM);
        ITEMS.add(WRENCH_ITEM);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((tab) -> tab.acceptAll(
                        ITEMS.stream().map((item) -> item.get().asItem().getDefaultInstance()).toList()
                ));
    }
}
