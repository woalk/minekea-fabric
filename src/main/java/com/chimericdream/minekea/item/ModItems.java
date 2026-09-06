package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.containers.ContainerItems;
import com.chimericdream.minekea.util.ModThingGroup;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
    public static final List<ModThingGroup> ITEM_GROUPS = new ArrayList<>();

    public static final ContainerItems CONTAINER_ITEMS;
    public static final NuggetBags NUGGET_BAGS;
    public static final Tools TOOLS;

    static {
        CONTAINER_ITEMS = new ContainerItems();
        NUGGET_BAGS = new NuggetBags();
        TOOLS = new Tools();

        ITEM_GROUPS.add(CONTAINER_ITEMS);
        ITEM_GROUPS.add(NUGGET_BAGS);
        ITEM_GROUPS.add(TOOLS);
    }

    public static void init() {
    }

    public static void postInit() {
    }
}
