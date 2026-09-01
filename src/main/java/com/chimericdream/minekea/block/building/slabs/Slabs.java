package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.LogWoodFamilies;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Slabs implements ModThingGroup {
    public static final Item.Properties DEFAULT_SLAB_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> SLAB_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> BOOKSHELF_SLAB_BLOCKS = new ArrayList<>();

    static {
        // basalt-brick-family plain slabs now come from BasaltBrickFamilies (chimeric-lib BlockFamily)
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("potent_sulfur"), () -> new SlabBlock(new BlockConfig().material("potent_sulfur").materialName("Potent Sulfur").ingredient(Blocks.POTENT_SULFUR)), DEFAULT_SLAB_SETTINGS));

        LogWoodFamilies.ALL.forEach(entry -> {
            SLAB_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    SlabBlock.makeId(entry.material()),
                    () -> new SlabBlock(entry.newConfig()),
                    DEFAULT_SLAB_SETTINGS
                )
            );
        });

        Blocks.WOOL.forEach(wool -> {
            final var woolId = BuiltInRegistries.BLOCK.getKey(wool);
            SLAB_BLOCKS.add(
                    REGISTRY_HELPER.registerWithItem(
                            SlabBlock.makeId(woolId.getPath()),
                            () -> new SlabBlock(new BlockConfig().material(woolId.getPath()).materialName(wool.getName().getString()).ingredient(wool)),
                            DEFAULT_SLAB_SETTINGS
                    )
            );
        });

        Bookshelves.BOOKSHELF_CONFIGS.forEach((material, config) -> {
            BOOKSHELF_SLAB_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(BookshelfSlabBlock.makeId(material),
                    () -> new BookshelfSlabBlock(config),
                    DEFAULT_SLAB_SETTINGS
                )
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((tab) -> {
            tab.acceptAll(SLAB_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
            tab.acceptAll(BOOKSHELF_SLAB_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
        });
    }
}
