package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.resources.Identifier;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class WallBlock extends net.minecraft.world.level.block.WallBlock {
    public Identifier BLOCK_ID;
    public final BlockConfig config;

    public WallBlock(BlockConfig config) {
        this(config, makeId(config.getMaterial()));
    }

    public WallBlock(BlockConfig config, Identifier id) {
        super(config.getBaseSettings().setId(REGISTRY_HELPER.makeBlockRegistryKey(id)));

        BLOCK_ID = id;
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, String.format("building/walls/%s", material));
    }
}
