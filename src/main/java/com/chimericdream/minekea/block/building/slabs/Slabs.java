package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.lib.util.Tool;
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
import net.minecraft.world.level.block.ColorCollection;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Slabs implements ModThingGroup {
    public static final Item.Properties DEFAULT_SLAB_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> SLAB_BLOCKS = new ArrayList<>();
    public static final List<RegistrySupplier<Block>> BOOKSHELF_SLAB_BLOCKS = new ArrayList<>();

    static {
        // basalt-brick-family plain slabs now come from BasaltBrickFamilies (chimeric-lib BlockFamily)
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("potent_sulfur"), () -> new SlabBlock(new BlockConfig().material("potent_sulfur").materialName("Potent Sulfur").ingredient(Blocks.POTENT_SULFUR)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("dirt"), () -> new SlabBlock(new BlockConfig().material("dirt").materialName("Dirt").ingredient(Blocks.DIRT)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("sand"), () -> new SlabBlock(new BlockConfig().material("sand").materialName("Sand").ingredient(Blocks.SAND)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("red_sand"), () -> new SlabBlock(new BlockConfig().material("red_sand").materialName("Red Sand").ingredient(Blocks.RED_SAND)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("gold_block"), () -> new SlabBlock(new BlockConfig().material("gold_block").materialName("Gold Block").ingredient(Blocks.GOLD_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("glass"), () -> new SlabBlock(new BlockConfig().material("glass").materialName("Glass").ingredient(Blocks.GLASS)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("obsidian"), () -> new SlabBlock(new BlockConfig().material("obsidian").materialName("Obsidian").ingredient(Blocks.OBSIDIAN)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("amethyst"), () -> new SlabBlock(new BlockConfig().material("amethyst").materialName("Amethyst").ingredient(Blocks.AMETHYST_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("crying_obsidian"), () -> new SlabBlock(new BlockConfig().material("crying_obsidian").materialName("Crying Obsidian").ingredient(Blocks.CRYING_OBSIDIAN)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("deepslate"), () -> new SlabBlock(new BlockConfig().material("deepslate").materialName("Deepslate").ingredient(Blocks.DEEPSLATE)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("polished_basalt"), () -> new SlabBlock(new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture(TextureUtils.block(Blocks.POLISHED_BASALT, "_top")).texture("side", TextureUtils.block(Blocks.POLISHED_BASALT, "_side"))), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("cracked_deepslate_tile"), () -> new SlabBlock(new BlockConfig().material("cracked_deepslate_tile").materialName("Cracked Deepslate Tile").ingredient(Blocks.CRACKED_DEEPSLATE_TILES)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("packed_mud"), () -> new SlabBlock(new BlockConfig().material("packed_mud").materialName("Packed Mud").ingredient(Blocks.PACKED_MUD)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("smooth_basalt"), () -> new SlabBlock(new BlockConfig().material("smooth_basalt").materialName("Smooth Basalt").ingredient(Blocks.SMOOTH_BASALT)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("diamond_block"), () -> new SlabBlock(new BlockConfig().material("diamond_block").materialName("Diamond Block").ingredient(Blocks.DIAMOND_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("iron_block"), () -> new SlabBlock(new BlockConfig().material("iron_block").materialName("Iron Block").ingredient(Blocks.IRON_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("copper_block"), () -> new SlabBlock(new BlockConfig().material("copper_block").materialName("Copper Block").ingredient(Blocks.COPPER_BLOCK.weathering().unaffected())), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("netherite_block"), () -> new SlabBlock(new BlockConfig().material("netherite_block").materialName("Netherite Block").ingredient(Blocks.NETHERITE_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("calcite"), () -> new SlabBlock(new BlockConfig().material("calcite").materialName("Calcite").ingredient(Blocks.CALCITE)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("lapis_block"), () -> new SlabBlock(new BlockConfig().material("lapis_block").materialName("Lapis Block").ingredient(Blocks.LAPIS_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("redstone_block"), () -> new SlabBlock(new BlockConfig().material("redstone_block").materialName("Redstone Block").ingredient(Blocks.REDSTONE_BLOCK)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("cracked_stone_brick"), () -> new SlabBlock(new BlockConfig().material("cracked_stone_brick").materialName("Cracked Stone Brick").ingredient(Blocks.CRACKED_STONE_BRICKS)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("cracked_deepslate_brick"), () -> new SlabBlock(new BlockConfig().material("cracked_deepslate_brick").materialName("Cracked Deepslate Brick").ingredient(Blocks.CRACKED_DEEPSLATE_BRICKS)), DEFAULT_SLAB_SETTINGS));
        SLAB_BLOCKS.add(REGISTRY_HELPER.registerWithItem(SlabBlock.makeId("basalt"), () -> new SlabBlock(new BlockConfig().material("basalt").materialName("Basalt").ingredient(Blocks.BASALT).texture(TextureUtils.block(Blocks.BASALT, "_top")).texture("side", TextureUtils.block(Blocks.BASALT, "_side"))), DEFAULT_SLAB_SETTINGS));

        LogWoodFamilies.ALL.forEach(entry -> {
            SLAB_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    SlabBlock.makeId(entry.material()),
                    () -> new SlabBlock(entry.newConfig()),
                    DEFAULT_SLAB_SETTINGS
                )
            );
        });
        
        registerBlocks(Blocks.STAINED_GLASS);
        registerBlocks(Blocks.CONCRETE);
        registerBlocks(Blocks.WOOL);

        final var oakConfig = new BlockConfig()
                .material("oak")
                .materialName("Oak")
                .ingredient(Blocks.OAK_PLANKS)
                .flammable()
                .tool(Tool.AXE);
        final var oakBookshelfId = BuiltInRegistries.BLOCK.getKey(Blocks.BOOKSHELF);
        BOOKSHELF_SLAB_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(BookshelfSlabBlock.makeId("oak"),
                        () -> new BookshelfSlabBlock(oakConfig, oakBookshelfId),
                        DEFAULT_SLAB_SETTINGS
                )
        );
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

    private static void registerBlocks(ColorCollection<Block> blocks) {
        blocks.forEach(block -> {
            final var blockId = BuiltInRegistries.BLOCK.getKey(block);
            SLAB_BLOCKS.add(
                REGISTRY_HELPER.registerWithItem(
                    SlabBlock.makeId(blockId.getPath()),
                    () -> new SlabBlock(new BlockConfig().material(blockId.getPath()).materialName(block.getName().getString()).ingredient(block)),
                    DEFAULT_SLAB_SETTINGS
                )
            );
        });
    }
}
