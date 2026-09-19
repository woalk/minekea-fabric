package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.blocks.LazyBlockConfig;
import com.chimericdream.minekea.blocks.ModdedBlockEntry;
import com.chimericdream.minekea.blocks.SupportedModdedBlocks;
import com.chimericdream.minekea.registry.ModItemGroups;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.jspecify.annotations.Nullable;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Tables implements ModThingGroup {
    public static final Item.Properties DEFAULT_TABLE_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("acacia"), () -> new TableBlock(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("bamboo"), () -> new TableBlock(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("birch"), () -> new TableBlock(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("cherry"), () -> new TableBlock(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("crimson"), () -> new TableBlock(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("dark_oak"), () -> new TableBlock(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("jungle"), () -> new TableBlock(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("mangrove"), () -> new TableBlock(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("oak"), () -> new TableBlock(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("pale_oak"), () -> new TableBlock(new BlockConfig().material("pale_oak").materialName("Pale Oak").ingredient(Blocks.PALE_OAK_PLANKS).ingredient("log", Blocks.PALE_OAK_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("spruce"), () -> new TableBlock(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()), DEFAULT_TABLE_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId("warped"), () -> new TableBlock(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)), DEFAULT_TABLE_SETTINGS));

        if (FabricLoader.getInstance().isModLoaded(SupportedModdedBlocks.BetterNether.MOD_ID)) {
            SupportedModdedBlocks.BetterNether.getWoods().forEach(Tables::registerModded);
        }
        if (FabricLoader.getInstance().isModLoaded(SupportedModdedBlocks.BetterEnd.MOD_ID)) {
            SupportedModdedBlocks.BetterEnd.getWoods().forEach(Tables::registerModded);
        }

        CreativeModeTabEvents.modifyOutputEvent(ModItemGroups.FURNITURE_ITEM_GROUP.getKey()).register((tab) -> {
            tab.acceptAll(BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
        });
    }

    private static void registerModded(ModdedBlockEntry entry) {
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(TableBlock.makeId(entry.getMaterial()).withPrefix(entry.getModId() + "/"), () -> new TableBlock(
                new LazyBlockConfig()
                        .material(entry.getMaterial()).materialName(entry.getMaterialName())
                        .ingredientFunc((String key) -> {
                            if (key == null) {
                                return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(entry.getModId(), entry.getMaterial() + "_planks"));
                            } else if ("log".equals(key)) {
                                return BuiltInRegistries.BLOCK.getValue(Identifier.fromNamespaceAndPath(entry.getModId(), entry.getMaterial() + "_" + entry.getLogMaterial()));
                            } else return null;
                        })
                        .texture("log", Identifier.fromNamespaceAndPath(entry.getModId(), "block/" + entry.getMaterial() + "_" + entry.getLogTextureSuffix()))
                        .flammable().settings(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS))
        ), DEFAULT_TABLE_SETTINGS));
    }
}
