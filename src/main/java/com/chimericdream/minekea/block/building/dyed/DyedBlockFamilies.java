package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.family.BlockFamily;
import com.chimericdream.lib.blocks.family.BlockFamilyVariant;
import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.resource.TextureUtils;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.registry.ModItemGroups;
import com.chimericdream.minekea.util.ModThingGroup;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

/**
 * The stairs/slab/wall trio for each dyed block, declared once via chimeric-lib's
 * {@link BlockFamily} instead of individual {@code BlockConfig} declarations across
 * {@code Stairs}/{@code Slabs}/{@code Walls}. IDs are pinned to
 * {@code building/dyed/<material>/<color>} so existing worlds, recipes, and loot tables
 * are unaffected.
 */
public class DyedBlockFamilies implements ModThingGroup {
    private static final Item.Properties DEFAULT_SETTINGS = new Item.Properties();

    public static final List<BlockFamily> ALL = new ArrayList<>();

    static {
        DyedBlocks.BLOCKS_TO_DYE.forEach(data -> {
            String material = data.id();
            String materialName = data.name();
            Block ingredient = data.block();

            for (DyeColor color : DyeColor.values()) {
                BlockFamily family = family(
                        material,
                        "%s Dyed %s".formatted(ColorHelpers.getName(color), materialName),
                        ingredient, color, false);
                ALL.add(family);
            }
        });

        DyedBlocks.PILLAR_BLOCKS_TO_DYE.forEach(data -> {
            String material = data.id();
            String materialName = data.name();
            Block ingredient = data.block();

            for (DyeColor color : DyeColor.values()) {
                BlockFamily family = family(
                        material,
                        "%s Dyed %s".formatted(ColorHelpers.getName(color), materialName),
                        ingredient, color, true);
                ALL.add(family);
            }
        });
    }

    private static BlockFamily family(String material, String materialName, Block ingredient, DyeColor color, boolean pillar) {
        String colorName = color.getName();
        String baseId = String.format("building/dyed/%s/%s", material, colorName);
        String textureId = "block/" + baseId + (pillar ? "_end" : "");
        return BlockFamily.builder(REGISTRY_HELPER, material + "_" + colorName, new BlockConfig()
                .materialName(materialName)
                .ingredient(ingredient)
                .texture(Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, textureId)))
            .variants(BlockFamilyVariant.STAIRS, BlockFamilyVariant.SLAB, BlockFamilyVariant.WALL)
            .itemSettings(DEFAULT_SETTINGS)
            .stairsId(Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, baseId + "_stairs"))
            .slabId(Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, baseId + "_slab"))
            .wallId(Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, baseId + "_wall"))
            .build();
    }

    static {
        CreativeModeTabEvents.modifyOutputEvent(ModItemGroups.DYED_BLOCK_ITEM_GROUP.getKey())
                .register((tab) -> ALL.forEach((family) -> {
                    tab.acceptAll(family.getSlab().stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
                    tab.acceptAll(family.getStairs().stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
                    tab.acceptAll(family.getWall().stream().map((block) -> block.get().asItem().getDefaultInstance()).toList());
                }));
    }
}
