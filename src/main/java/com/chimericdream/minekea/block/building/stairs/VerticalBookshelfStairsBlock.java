package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.BookshelfBlock;
import net.minecraft.resources.Identifier;

public class VerticalBookshelfStairsBlock extends VerticalStairsBlock {
    public final Identifier BASE_BLOCK_ID;

    public VerticalBookshelfStairsBlock(BlockConfig config) {
        this(config, makeId(config.getMaterial()), BookshelfBlock.makeId(config.getMaterial()));
    }

    public VerticalBookshelfStairsBlock(BlockConfig config, Identifier baseBlockId) {
        this(config, makeId(config.getMaterial()), baseBlockId);
    }

    public VerticalBookshelfStairsBlock(BlockConfig config, Identifier id, Identifier baseBlockId) {
        super(config, id);

        BASE_BLOCK_ID = baseBlockId;
    }

    public static Identifier makeId(String material) {
        return Identifier.fromNamespaceAndPath(ModInfo.MOD_ID, String.format("building/stairs/bookshelves/vertical/%s", material));
    }
}
