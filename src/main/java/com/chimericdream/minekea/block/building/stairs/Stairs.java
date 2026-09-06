package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.LogWoodFamilies;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockIds;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Stairs implements ModThingGroup {
    public static final Item.Properties DEFAULT_STAIRS_SETTINGS = new Item.Properties();
    public static final Item.Properties DEFAULT_VERTICAL_STAIRS_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> STAIRS_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_STAIRS_BLOCKS = new ArrayList<>();

    public static final List<RegistrySupplier<Block>> BOOKSHELF_STAIRS_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> VERTICAL_BOOKSHELF_STAIRS_BLOCKS = new ArrayList<>();

    static {
        // basalt-brick-family plain stairs now come from BasaltBrickFamilies (chimeric-lib BlockFamily)

        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("acacia_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("acacia_planks").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("birch_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("birch_planks").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("cherry_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("cherry_planks").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("crimson_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("crimson_planks").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("dark_oak_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("dark_oak_planks").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("jungle_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("jungle_planks").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("mangrove_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("mangrove_planks").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("oak_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("oak_planks").materialName("Oak").ingredient(Blocks.OAK_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("pale_oak_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("pale_oak_planks").materialName("Pale Oak").ingredient(Blocks.PALE_OAK_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("spruce_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("spruce_planks").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).flammable().tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("warped_planks"), () -> new VerticalStairsBlock(new BlockConfig().material("warped_planks").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("bamboo_mosaic"), () -> new VerticalStairsBlock(new BlockConfig().material("bamboo_mosaic").materialName("Bamboo Mosaic").ingredient(Blocks.BAMBOO_MOSAIC).tool(Tool.AXE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("bricks").materialName("Brick").ingredient(Blocks.BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("calcite"), () -> new VerticalStairsBlock(new BlockConfig().material("calcite").materialName("Calcite").ingredient(Blocks.CALCITE)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("nether_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("nether_bricks").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("quartz_block_bottom"), () -> new VerticalStairsBlock(new BlockConfig().material("quartz_block_bottom").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("stone_bricks"), () -> new VerticalStairsBlock(new BlockConfig().material("stone_bricks").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(VerticalStairsBlock.makeId("gold_block"), () -> new VerticalStairsBlock(new BlockConfig().material("gold_block").materialName("Block of Gold").ingredient(Blocks.GOLD_BLOCK)), DEFAULT_VERTICAL_STAIRS_SETTINGS));

        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("potent_sulfur"), () -> new StairsBlock(new BlockConfig().material("potent_sulfur").materialName("Potent Sulfur").ingredient(Blocks.POTENT_SULFUR)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("gold_block"), () -> new StairsBlock(new BlockConfig().material("gold_block").materialName("Gold Block").ingredient(Blocks.GOLD_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("dirt"), () -> new StairsBlock(new BlockConfig().material("dirt").materialName("Dirt").ingredient(Blocks.DIRT)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("sand"), () -> new StairsBlock(new BlockConfig().material("sand").materialName("Sand").ingredient(Blocks.SAND)), DEFAULT_STAIRS_SETTINGS));

        LogWoodFamilies.ALL.forEach(entry -> {
            STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    StairsBlock.makeId(entry.material()),
                    () -> new StairsBlock(entry.newConfig()),
                    DEFAULT_STAIRS_SETTINGS
                )
            );

            VERTICAL_STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    VerticalStairsBlock.makeId(entry.material()),
                    () -> new VerticalStairsBlock(entry.newConfig()),
                    DEFAULT_VERTICAL_STAIRS_SETTINGS
                )
            );
        });

        Blocks.WOOL.forEach(wool -> {
            final var woolId = BuiltInRegistries.BLOCK.getKey(wool);
            STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    StairsBlock.makeId(woolId.getPath()),
                    () -> new StairsBlock(new BlockConfig().material(woolId.getPath()).materialName(wool.getName().getString()).ingredient(wool)),
                    DEFAULT_STAIRS_SETTINGS
                )
            );
            VERTICAL_STAIRS_BLOCKS.add(
                    REGISTRY_HELPER.registerWithItem(
                            VerticalStairsBlock.makeId(woolId.getPath()),
                            () -> new VerticalStairsBlock(new BlockConfig().material(woolId.getPath()).materialName(wool.getName().getString()).ingredient(wool)),
                            DEFAULT_STAIRS_SETTINGS
                    )
            );
        });

        final var oakConfig = new BlockConfig()
                .material("oak")
                .materialName("Oak")
                .ingredient(Blocks.OAK_PLANKS)
                .flammable()
                .tool(Tool.AXE);
        final var oakBookshelfId = BuiltInRegistries.BLOCK.getKey(Blocks.BOOKSHELF);
        BOOKSHELF_STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(BookshelfStairsBlock.makeId("oak"),
                        () -> new BookshelfStairsBlock(oakConfig, oakBookshelfId),
                        DEFAULT_STAIRS_SETTINGS
                )
        );
        VERTICAL_BOOKSHELF_STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(VerticalBookshelfStairsBlock.makeId("oak"),
                        () -> new VerticalBookshelfStairsBlock(oakConfig, oakBookshelfId),
                        DEFAULT_STAIRS_SETTINGS
                )
        );
        Bookshelves.BOOKSHELF_CONFIGS.forEach((material, config) -> {
            BOOKSHELF_STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(BookshelfStairsBlock.makeId(material),
                    () -> new BookshelfStairsBlock(config),
                    DEFAULT_STAIRS_SETTINGS
                )
            );

            VERTICAL_BOOKSHELF_STAIRS_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(VerticalBookshelfStairsBlock.makeId(material),
                    () -> new VerticalBookshelfStairsBlock(config),
                    DEFAULT_VERTICAL_STAIRS_SETTINGS
                )
            );
        });

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register((tab) -> {
            tab.acceptAll(STAIRS_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
            tab.acceptAll(VERTICAL_STAIRS_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
            tab.acceptAll(BOOKSHELF_STAIRS_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
            tab.acceptAll(VERTICAL_BOOKSHELF_STAIRS_BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
        });
    }
}
