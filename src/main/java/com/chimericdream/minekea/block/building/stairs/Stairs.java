package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.LogWoodFamilies;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ColorCollection;

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

        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(
                Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, "building/stairs/vertical/stone_brick/white"), () -> new VerticalStairsBlock(
                        new BlockConfig()
                                .material("stone_bricks" + "white")
                                .texture(Identifier.fromNamespaceAndPath("minekea", "block/building/dyed/stone_bricks/white"))
                                .materialName("White Dyed Stone Brick")
                                .ingredient(DyedBlocks.BLOCK_MAP.get("stone_bricks" + "white"))
                ), DEFAULT_VERTICAL_STAIRS_SETTINGS));
        VERTICAL_STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(
                Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, "building/stairs/vertical/brick/light_gray"), () -> new VerticalStairsBlock(
                        new BlockConfig()
                                .material("bricks" + "light_gray")
                                .texture(Identifier.fromNamespaceAndPath("minekea", "block/building/dyed/bricks/light_gray"))
                                .materialName("Light Gray Dyed Bricks")
                                .ingredient(DyedBlocks.BLOCK_MAP.get("bricks" + "light_gray"))
                ), DEFAULT_VERTICAL_STAIRS_SETTINGS));

        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("potent_sulfur"), () -> new StairsBlock(new BlockConfig().material("potent_sulfur").materialName("Potent Sulfur").ingredient(Blocks.POTENT_SULFUR)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("gold_block"), () -> new StairsBlock(new BlockConfig().material("gold_block").materialName("Gold Block").ingredient(Blocks.GOLD_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("dirt"), () -> new StairsBlock(new BlockConfig().material("dirt").materialName("Dirt").ingredient(Blocks.DIRT)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("sand"), () -> new StairsBlock(new BlockConfig().material("sand").materialName("Sand").ingredient(Blocks.SAND)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("red_sand"), () -> new StairsBlock(new BlockConfig().material("red_sand").materialName("Red Sand").ingredient(Blocks.RED_SAND)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("glass"), () -> new StairsBlock(new BlockConfig().material("glass").materialName("Glass").ingredient(Blocks.GLASS)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("obsidian"), () -> new StairsBlock(new BlockConfig().material("obsidian").materialName("Obsidian").ingredient(Blocks.OBSIDIAN)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("amethyst"), () -> new StairsBlock(new BlockConfig().material("amethyst").materialName("Amethyst").ingredient(Blocks.AMETHYST_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("crying_obsidian"), () -> new StairsBlock(new BlockConfig().material("crying_obsidian").materialName("Crying Obsidian").ingredient(Blocks.CRYING_OBSIDIAN)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("deepslate"), () -> new StairsBlock(new BlockConfig().material("deepslate").materialName("Deepslate").ingredient(Blocks.DEEPSLATE)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("polished_basalt"), () -> new StairsBlock(new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture(TextureUtils.block(Blocks.POLISHED_BASALT, "_top")).texture("side", TextureUtils.block(Blocks.POLISHED_BASALT, "_side"))), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("cracked_deepslate_tile"), () -> new StairsBlock(new BlockConfig().material("cracked_deepslate_tile").materialName("Cracked Deepslate Tile").ingredient(Blocks.CRACKED_DEEPSLATE_TILES)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("packed_mud"), () -> new StairsBlock(new BlockConfig().material("packed_mud").materialName("Packed Mud").ingredient(Blocks.PACKED_MUD)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("smooth_basalt"), () -> new StairsBlock(new BlockConfig().material("smooth_basalt").materialName("Smooth Basalt").ingredient(Blocks.SMOOTH_BASALT)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("diamond_block"), () -> new StairsBlock(new BlockConfig().material("diamond_block").materialName("Diamond Block").ingredient(Blocks.DIAMOND_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("iron_block"), () -> new StairsBlock(new BlockConfig().material("iron_block").materialName("Iron Block").ingredient(Blocks.IRON_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("copper_block"), () -> new StairsBlock(new BlockConfig().material("copper_block").materialName("Copper Block").ingredient(Blocks.COPPER_BLOCK.weathering().unaffected())), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("netherite_block"), () -> new StairsBlock(new BlockConfig().material("netherite_block").materialName("Netherite Block").ingredient(Blocks.NETHERITE_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("calcite"), () -> new StairsBlock(new BlockConfig().material("calcite").materialName("Calcite").ingredient(Blocks.CALCITE)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("lapis_block"), () -> new StairsBlock(new BlockConfig().material("lapis_block").materialName("Lapis Block").ingredient(Blocks.LAPIS_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("redstone_block"), () -> new StairsBlock(new BlockConfig().material("redstone_block").materialName("Redstone Block").ingredient(Blocks.REDSTONE_BLOCK)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("cracked_stone_brick"), () -> new StairsBlock(new BlockConfig().material("cracked_stone_brick").materialName("Cracked Stone Brick").ingredient(Blocks.CRACKED_STONE_BRICKS)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("cracked_deepslate_brick"), () -> new StairsBlock(new BlockConfig().material("cracked_deepslate_brick").materialName("Cracked Deepslate Brick").ingredient(Blocks.CRACKED_DEEPSLATE_BRICKS)), DEFAULT_STAIRS_SETTINGS));
        STAIRS_BLOCKS.add(REGISTRY_HELPER.registerWithItem(StairsBlock.makeId("basalt"), () -> new StairsBlock(new BlockConfig().material("basalt").materialName("Basalt").ingredient(Blocks.BASALT).texture(TextureUtils.block(Blocks.BASALT, "_top")).texture("side", TextureUtils.block(Blocks.BASALT, "_side"))), DEFAULT_STAIRS_SETTINGS));

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
        registerBlocks(Blocks.CONCRETE);
        registerBlocks(Blocks.STAINED_GLASS);

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

    private static void registerBlocks(ColorCollection<Block> blocks) {
        blocks.forEach(block -> {
            final var blockId = BuiltInRegistries.BLOCK.getKey(block);
            STAIRS_BLOCKS.add(
                    REGISTRY_HELPER.registerWithItem(
                            StairsBlock.makeId(blockId.getPath()),
                            () -> new StairsBlock(new BlockConfig().material(blockId.getPath()).materialName(block.getName().getString()).ingredient(block)),
                            DEFAULT_STAIRS_SETTINGS
                    )
            );
        });
    }
}
