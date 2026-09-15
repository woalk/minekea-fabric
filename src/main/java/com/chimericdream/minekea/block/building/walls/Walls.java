package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

/**
 * All wall materials were basalt-brick-family and now come from
 * {@link com.chimericdream.minekea.block.building.BasaltBrickFamilies}.
 */
public class Walls implements ModThingGroup {
    private static final Item.Properties DEFAULT_WALL_SETTINGS = new Item.Properties();
    public static final List<RegistrySupplier<Block>> WALL_BLOCKS = new ArrayList<>();

    static {
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("obsidian"), () -> new WallBlock(new BlockConfig().material("obsidian").materialName("Obsidian").ingredient(Blocks.OBSIDIAN)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("amethyst"), () -> new WallBlock(new BlockConfig().material("amethyst").materialName("Amethyst").ingredient(Blocks.AMETHYST_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("crying_obsidian"), () -> new WallBlock(new BlockConfig().material("crying_obsidian").materialName("Crying Obsidian").ingredient(Blocks.CRYING_OBSIDIAN)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("deepslate"), () -> new WallBlock(new BlockConfig().material("deepslate").materialName("Deepslate").ingredient(Blocks.DEEPSLATE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("polished_basalt"), () -> new WallBlock(new BlockConfig().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture(TextureUtils.block(Blocks.POLISHED_BASALT, "_top")).texture("side", TextureUtils.block(Blocks.POLISHED_BASALT, "_side"))), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("cracked_deepslate_tile"), () -> new WallBlock(new BlockConfig().material("cracked_deepslate_tile").materialName("Cracked Deepslate Tile").ingredient(Blocks.CRACKED_DEEPSLATE_TILES)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("smooth_basalt"), () -> new WallBlock(new BlockConfig().material("smooth_basalt").materialName("Smooth Basalt").ingredient(Blocks.SMOOTH_BASALT)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("diamond_block"), () -> new WallBlock(new BlockConfig().material("diamond_block").materialName("Diamond Block").ingredient(Blocks.DIAMOND_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("iron_block"), () -> new WallBlock(new BlockConfig().material("iron_block").materialName("Iron Block").ingredient(Blocks.IRON_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("copper_block"), () -> new WallBlock(new BlockConfig().material("copper_block").materialName("Copper Block").ingredient(Blocks.COPPER_BLOCK.weathering().unaffected())), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("netherite_block"), () -> new WallBlock(new BlockConfig().material("netherite_block").materialName("Netherite Block").ingredient(Blocks.NETHERITE_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("calcite"), () -> new WallBlock(new BlockConfig().material("calcite").materialName("Calcite").ingredient(Blocks.CALCITE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("lapis_block"), () -> new WallBlock(new BlockConfig().material("lapis_block").materialName("Lapis Block").ingredient(Blocks.LAPIS_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("redstone_block"), () -> new WallBlock(new BlockConfig().material("redstone_block").materialName("Redstone Block").ingredient(Blocks.REDSTONE_BLOCK)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("cracked_stone_brick"), () -> new WallBlock(new BlockConfig().material("cracked_stone_brick").materialName("Cracked Stone Brick").ingredient(Blocks.CRACKED_STONE_BRICKS)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("cracked_deepslate_brick"), () -> new WallBlock(new BlockConfig().material("cracked_deepslate_brick").materialName("Cracked Deepslate Brick").ingredient(Blocks.CRACKED_DEEPSLATE_BRICKS)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("basalt"), () -> new WallBlock(new BlockConfig().material("basalt").materialName("Basalt").ingredient(Blocks.BASALT).texture(TextureUtils.block(Blocks.BASALT, "_top")).texture("side", TextureUtils.block(Blocks.BASALT, "_side"))), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("polished_granite"), () -> new WallBlock(new BlockConfig().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("dark_prismarine"), () -> new WallBlock(new BlockConfig().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("stone"), () -> new WallBlock(new BlockConfig().material("stone").materialName("Stone").ingredient(Blocks.STONE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("polished_andesite"), () -> new WallBlock(new BlockConfig().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("polished_diorite"), () -> new WallBlock(new BlockConfig().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("smooth_sandstone"), () -> new WallBlock(new BlockConfig().material("smooth_sandstone").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("prismarine_brick"), () -> new WallBlock(new BlockConfig().material("prismarine_brick").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("cut_sandstone"), () -> new WallBlock(new BlockConfig().material("cut_sandstone").materialName("Cut Sandstone").ingredient(Blocks.CUT_SANDSTONE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("cut_red_sandstone"), () -> new WallBlock(new BlockConfig().material("cut_red_sandstone").materialName("Cut Red Sandstone").ingredient(Blocks.CUT_RED_SANDSTONE)), DEFAULT_WALL_SETTINGS));
        WALL_BLOCKS.add(REGISTRY_HELPER.registerWithItem(WallBlock.makeId("smooth_red_sandstone"), () -> new WallBlock(new BlockConfig().material("smooth_red_sandstone").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))), DEFAULT_WALL_SETTINGS));
    }
}
