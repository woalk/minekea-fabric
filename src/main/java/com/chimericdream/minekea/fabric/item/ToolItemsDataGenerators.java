package com.chimericdream.minekea.fabric.item;

import com.chimericdream.minekea.fabric.data.ChimericLibItemDataGenerator;
import com.chimericdream.minekea.fabric.item.tools.BlockPainterItemDataGenerator;
import com.chimericdream.minekea.fabric.item.tools.WrenchItemDataGenerator;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;

import java.util.ArrayList;
import java.util.List;

public class ToolItemsDataGenerators implements ItemDataGeneratorGroup {
    protected static final List<ChimericLibItemDataGenerator> ITEM_GENERATORS = new ArrayList<>();

    static {
        ITEM_GENERATORS.add(new BlockPainterItemDataGenerator());
        ITEM_GENERATORS.add(new WrenchItemDataGenerator());
    }

    @Override
    public List<ChimericLibItemDataGenerator> getItemGenerators() {
        return ITEM_GENERATORS;
    }
}
