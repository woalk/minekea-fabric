package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class BookshelfBlock extends Block {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public BookshelfBlock(BlockConfig config) {
        this(config, makeId(config.getMaterial()));
    }

    public BookshelfBlock(BlockConfig config, Identifier id) {
        super(config.getBaseSettings().setId(REGISTRY_HELPER.makeBlockRegistryKey(id)));

        BLOCK_ID = id;
        this.config = config;
    }

    public static Identifier makeId(String material) {
        return Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, String.format("furniture/bookshelves/%s", material));
    }
}
