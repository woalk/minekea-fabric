package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.block.decorations.candles.VotiveCandles;
import com.chimericdream.minekea.block.decorations.lighting.EndlessRodBlock;
import com.chimericdream.minekea.block.decorations.lighting.Lanterns;
import com.chimericdream.minekea.util.ModThingGroup;
import dev.architectury.registry.registries.RegistrySupplier;
import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.chimericdream.minekea.MinekeaMod.REGISTRY_HELPER;

public class DecorationBlocks implements ModThingGroup {
    public static final List<RegistrySupplier<Block>> BLOCKS = new ArrayList<>();

    public static final RegistrySupplier<Block> ENDLESS_ROD = REGISTRY_HELPER.registerWithItem(EndlessRodBlock.BLOCK_ID, EndlessRodBlock::new, new Item.Properties());
    public static final RegistrySupplier<Block> FAKE_CAKE = REGISTRY_HELPER.registerWithItem(FakeCakeBlock.BLOCK_ID, FakeCakeBlock::new, new Item.Properties());

    static {
        BLOCKS.add(ENDLESS_ROD);
        BLOCKS.add(FAKE_CAKE);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS)
                .register((tab) -> tab.accept(ENDLESS_ROD.get().asItem().getDefaultInstance()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
                .register((tab) -> tab.accept(FAKE_CAKE.get().asItem().getDefaultInstance()));

        BLOCKS.addAll(Lanterns.BLOCKS);
        BLOCKS.addAll(VotiveCandles.BLOCKS);
    }
}
