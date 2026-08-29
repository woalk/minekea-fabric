package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Bookshelves implements ModThingGroup {
    @SuppressWarnings("UnstableApiUsage")
    public static final Item.Properties DEFAULT_BOOKSHELF_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();
    public static final Map<String, RegistrySupplier<Block>> BOOKSHELVES = new LinkedHashMap<>();
    public static final Map<String, BlockConfig> BOOKSHELF_CONFIGS = new LinkedHashMap<>();

    static {
        BOOKSHELF_CONFIGS.put("acacia", new BlockConfig().material("acacia").materialName("Acacia").flammable().ingredient(Blocks.ACACIA_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("bamboo", new BlockConfig().material("bamboo").materialName("Bamboo").flammable().ingredient(Blocks.BAMBOO_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("birch", new BlockConfig().material("birch").materialName("Birch").flammable().ingredient(Blocks.BIRCH_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("cherry", new BlockConfig().material("cherry").materialName("Cherry").flammable().ingredient(Blocks.CHERRY_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("crimson", new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("dark_oak", new BlockConfig().material("dark_oak").materialName("Dark Oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("jungle", new BlockConfig().material("jungle").materialName("Jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("mangrove", new BlockConfig().material("mangrove").materialName("Mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("pale_oak", new BlockConfig().material("pale_oak").materialName("Pale Oak").flammable().ingredient(Blocks.PALE_OAK_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("spruce", new BlockConfig().material("spruce").materialName("Spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS).tool(Tool.AXE));
        BOOKSHELF_CONFIGS.put("warped", new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).tool(Tool.AXE));

        BOOKSHELF_CONFIGS.put("polished_blackstone", new BlockConfig().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE));
        BOOKSHELF_CONFIGS.put("polished_diorite", new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE));

        BOOKSHELF_CONFIGS.forEach((key, value) -> BOOKSHELVES.put(key, REGISTRY_HELPER.registerWithItem(BookshelfBlock.makeId(key), () -> new BookshelfBlock(value), DEFAULT_BOOKSHELF_SETTINGS)));

        BLOCKS.addAll(BOOKSHELVES.values());

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((tab) -> tab.acceptAll(
                        BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList()
                ));
    }
}