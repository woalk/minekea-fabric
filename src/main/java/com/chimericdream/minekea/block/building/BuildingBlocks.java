package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlockFamilies;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.building.framed.FramedBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.ChiseledBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.block.building.slabs.Slabs;
import com.chimericdream.minekea.block.building.stairs.Stairs;
import com.chimericdream.minekea.block.building.storage.StorageBlocks;
import com.chimericdream.minekea.block.building.walls.Walls;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class BuildingBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    public static final Item.Properties DEFAULT_SETTINGS = new Item.Properties();

    public static final RegistrySupplier<Block> BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(BasaltBricksBlock.BLOCK_ID, BasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CHISELED_BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(ChiseledBasaltBricksBlock.BLOCK_ID, ChiseledBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CRACKED_BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(CrackedBasaltBricksBlock.BLOCK_ID, CrackedBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> CRIMSON_BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(CrimsonBasaltBricksBlock.BLOCK_ID, CrimsonBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> MOSSY_BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(MossyBasaltBricksBlock.BLOCK_ID, MossyBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> WARPED_BASALT_BRICKS = REGISTRY_HELPER.registerWithItem(WarpedBasaltBricksBlock.BLOCK_ID, WarpedBasaltBricksBlock::new, DEFAULT_SETTINGS);
    public static final RegistrySupplier<Block> WARPED_NETHER_BRICKS = REGISTRY_HELPER.registerWithItem(WarpedNetherBricksBlock.BLOCK_ID, WarpedNetherBricksBlock::new, DEFAULT_SETTINGS);

    static {
        BLOCKS.add(BASALT_BRICKS);
        BLOCKS.add(CHISELED_BASALT_BRICKS);
        BLOCKS.add(CRACKED_BASALT_BRICKS);
        BLOCKS.add(CRIMSON_BASALT_BRICKS);
        BLOCKS.add(MOSSY_BASALT_BRICKS);
        BLOCKS.add(WARPED_BASALT_BRICKS);
        BLOCKS.add(WARPED_NETHER_BRICKS);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((tab) -> tab.acceptAll(
                        BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList()
                ));

        BLOCKS.addAll(Beams.BLOCKS);
        BLOCKS.addAll(Covers.BLOCKS);
        BLOCKS.addAll(DyedBlocks.BLOCK_MAP.values());
        BLOCKS.addAll(DyedBlocks.PILLAR_BLOCK_MAP.values());
        BLOCKS.addAll(FramedBlocks.FRAMED_PLANKS);
        BLOCKS.addAll(Slabs.SLAB_BLOCKS);
        BLOCKS.addAll(Slabs.BOOKSHELF_SLAB_BLOCKS);
        BLOCKS.addAll(Stairs.STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.VERTICAL_STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.BOOKSHELF_STAIRS_BLOCKS);
        BLOCKS.addAll(Stairs.VERTICAL_BOOKSHELF_STAIRS_BLOCKS);
        BLOCKS.addAll(StorageBlocks.BLOCKS);
        BLOCKS.addAll(Walls.WALL_BLOCKS);
        BasaltBrickFamilies.ALL.forEach(family -> family.getVariants().forEach(variant -> BLOCKS.add(family.getBlock(variant).orElseThrow())));
        DyedBlockFamilies.ALL.forEach(family -> family.getVariants().forEach(variant -> BLOCKS.add(family.getBlock(variant).orElseThrow())));
    }
}
