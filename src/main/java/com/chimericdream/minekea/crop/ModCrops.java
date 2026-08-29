package com.chimericdream.minekea.crop;

import com.chimericdream.minekea.block.containers.GlassJarBlock;
import dev.architectury.registry.registries.RegistrySupplier;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class ModCrops {
    public static final RegistrySupplier<Block> WARPED_WART_PLANT_BLOCK = REGISTRY_HELPER.registerBlock(WarpedWartPlantBlock.BLOCK_ID, WarpedWartPlantBlock::new);
    public static final RegistrySupplier<Item> WARPED_WART_ITEM = REGISTRY_HELPER.registerItem(WarpedWartItem.ITEM_ID, WarpedWartItem::new);

    static {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS)
                .register((tab) -> tab.accept(WARPED_WART_ITEM.get().getDefaultInstance()));
    }

    public static void init() {
    }

    public static void postInit() {
        GlassJarBlock.ALLOWED_ITEMS.add(WARPED_WART_ITEM.get());
    }
}
