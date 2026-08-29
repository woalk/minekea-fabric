package com.chimericdream.minekea.item.containers;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.containers.GlassJarBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class ContainerItems implements ModThingGroup {
    public static final List<RegistrySupplier<Item>> ITEMS = new ArrayList<>();

    public static final RegistrySupplier<Item> GLASS_JAR_ITEM = REGISTRY_HELPER.registerItem(GlassJarBlock.BLOCK_ID, () -> new GlassJarItem(ContainerBlocks.GLASS_JAR, new Item.Properties().stacksTo(8)));

    static {
        ITEMS.add(GLASS_JAR_ITEM);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((tab) -> tab.acceptAll(
                        ITEMS.stream().map((item) -> item.get().asItem().getDefaultInstance()).toList()
                ));
    }
}
