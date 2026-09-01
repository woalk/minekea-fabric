package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.BlockConfigExtKt;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Doors implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> BOOKSHELF_DOOR_BLOCKS = new ArrayList<>();

    static {
        BOOKSHELF_DOOR_BLOCKS.add(REGISTRY_HELPER.registerWithItem(BookshelfDoorBlock.makeId("oak"), () -> new BookshelfDoorBlock(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.BOOKSHELF).ingredient("planks", Blocks.OAK_PLANKS)), getItemSettings("oak")));

        for (var bConfig : Bookshelves.BOOKSHELF_CONFIGS.values()) {
            final var material = bConfig.getMaterial();
            final var configCopy = BlockConfigExtKt.copy(bConfig).ingredient(Bookshelves.BOOKSHELVES.get(material)).ingredient("planks", bConfig.getIngredient());
            if (material == null) continue;
            BOOKSHELF_DOOR_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    BookshelfDoorBlock.makeId(material),
                    () -> new BookshelfDoorBlock(
                            BlockSetType.values()
                                    .filter((it) -> it.name().equals(material))
                                    .findFirst()
                                    .orElse(BlockSetType.STONE),
                            configCopy
                    ),
                    getItemSettings(material)
                )
            );
        }

        BLOCKS.addAll(BOOKSHELF_DOOR_BLOCKS);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.REDSTONE_BLOCKS)
                .register((tab) -> tab.acceptAll(
                        BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList()
                ));
    }

    public static Item.Properties getItemSettings(String material) {
        return new Item.Properties();
    }
}
