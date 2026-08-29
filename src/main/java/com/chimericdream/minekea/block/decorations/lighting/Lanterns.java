package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class Lanterns implements ModThingGroup {
    @SuppressWarnings("UnstableApiUsage")
    public static final Item.Properties DEFAULT_LANTERN_SETTINGS = new Item.Properties();

    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(LanternBlock.makeId("ancient"), () -> new LanternBlock(new BlockConfig().name("Ancient Lantern").item(Items.ECHO_SHARD), "ancient"), DEFAULT_LANTERN_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(LanternBlock.makeId("doom"), () -> new LanternBlock(new BlockConfig().name("Doom Lantern").item(Items.CRIMSON_FUNGUS), "doom"), DEFAULT_LANTERN_SETTINGS));
        BLOCKS.add(REGISTRY_HELPER.registerWithItem(LanternBlock.makeId("end"), () -> new LanternBlock(new BlockConfig().name("End Lantern").item(Items.ENDER_PEARL), "end"), DEFAULT_LANTERN_SETTINGS));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((tab) -> tab.acceptAll(
                        BLOCKS.stream().map((block) -> block.get().asItem().getDefaultInstance()).toList()
                ));
    }
}
