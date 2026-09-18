package com.chimericdream.minekea.fabric.data;

import com.chimericdream.lib.fabric.data.JarAccess;
import com.chimericdream.lib.fabric.data.TextureGenerator;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.fabric.block.ModBlockDataGenerators;
import com.chimericdream.minekea.fabric.item.ModItemDataGenerators;
import com.chimericdream.minekea.fabric.registry.ModRegistryDataGenerator;
import com.chimericdream.minekea.fabric.util.BlockDataGeneratorGroup;
import com.chimericdream.minekea.fabric.util.ItemDataGeneratorGroup;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentInitializers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(MinekeaModelGenerator::new);
        pack.addProvider(MinekeaBlockLootTables::new);
        pack.addProvider(MinekeaRecipeProvider::new);
        pack.addProvider(MinekeaEnglishLangProvider::new);
        pack.addProvider(MinekeaBlockTagGenerator::new);
        pack.addProvider(MinekeaItemTagGenerator::new);

        if (JarAccess.canLoad()) {
            new TextureGenerator(pack, ModInfo.MOD_ID);

            ModBlockDataGenerators.BLOCK_GROUPS.forEach(BlockDataGeneratorGroup::generateTextures);
            ModItemDataGenerators.ITEM_GROUPS.forEach(ItemDataGeneratorGroup::generateTextures);
        }
    }

    private static class MinekeaRecipeProvider extends FabricRecipeProvider {
        public MinekeaRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
            return new RecipeProvider(registryLookup, exporter) {
                @Override
                public void buildRecipes() {
                    // MC 26.2 binds item data components lazily during a ReloadableServerResources reload rather
                    // than at bootstrap, so during datagen Item.components() (e.g. getDefaultMaxStackSize) throws
                    // "Components not bound yet". Bind them here the same way the server reload does, before any
                    // recipe reads them. The lookup is lenient because third-party mods loaded in the dev run
                    // (e.g. BetterEnd's music discs) reference dynamic registry entries (jukebox songs) that only
                    // exist once their data packs are loaded, which never happens during minekea's datagen.
                    BuiltInRegistries.DATA_COMPONENT_INITIALIZERS.build(lenientLookup(registryLookup))
                        .forEach(DataComponentInitializers.PendingComponents::apply);

                    for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                        group.configureRecipes(registryLookup, exporter, this);
                    }

                    for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                        group.configureRecipes(registryLookup, exporter, this);
                    }

//                    MinekeaMod.ITEMS.configureRecipes(exporter);
                }
            };
        }

        @Override
        public @NotNull String getName() {
            return "MinekeaRecipeProvider";
        }

        /**
         * Wraps a registry lookup so that missing elements resolve to unbound stand-alone holders instead of
         * throwing. Data component initializers only store these holders (they are never dereferenced during
         * minekea's datagen), so this keeps the component bind from crashing on other mods' datapack entries.
         */
        private static HolderLookup.Provider lenientLookup(HolderLookup.Provider parent) {
            return new HolderLookup.Provider() {
                @Override
                public @NotNull Stream<ResourceKey<? extends Registry<?>>> listRegistryKeys() {
                    return parent.listRegistryKeys();
                }

                @Override
                public <T> @NotNull Optional<? extends HolderLookup.RegistryLookup<T>> lookup(ResourceKey<? extends Registry<? extends T>> registryRef) {
                    return parent.lookup(registryRef).map(registry -> new HolderLookup.RegistryLookup.Delegate<T>() {
                        @Override
                        public HolderLookup.@NotNull RegistryLookup<T> parent() {
                            return registry;
                        }

                        @Override
                        public @NotNull Optional<Holder.Reference<T>> get(ResourceKey<T> key) {
                            return registry.get(key).or(() -> Optional.of(Holder.Reference.createStandAlone(registry, key)));
                        }
                    });
                }
            };
        }
    }

    private static class MinekeaBlockTagGenerator extends FabricTagsProvider.BlockTagsProvider {
        public MinekeaBlockTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockTags(arg, this::builder);
            }

//            MinekeaMod.ITEMS.configureBlockTags(arg, this::getOrCreateTagBuilder);
        }
    }

    private static class MinekeaItemTagGenerator extends FabricTagsProvider.ItemTagsProvider {
        public MinekeaItemTagGenerator(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureItemTags(arg, this::builder);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureItemTags(arg, this::builder);
            }

//            MinekeaMod.ITEMS.configureItemTags(arg, this::getOrCreateTagBuilder);
        }
    }

    private static class MinekeaEnglishLangProvider extends FabricLanguageProvider {
        protected MinekeaEnglishLangProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureTranslations(registryLookup, translationBuilder);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureTranslations(registryLookup, translationBuilder);
            }

            ModRegistryDataGenerator.configureTranslations(registryLookup, translationBuilder);

//            MinekeaMod.ITEMS.configureTranslations(registryLookup, translationBuilder);
        }
    }

    private static class MinekeaBlockLootTables extends FabricBlockLootSubProvider {
        private final HolderLookup.Provider registryLookup;

        protected MinekeaBlockLootTables(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
            super(dataOutput, registryLookup);
            this.registryLookup = registryLookup.join();
        }

        @Override
        public void generate() {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockLootTables(this, this.registryLookup);
            }

//            MinekeaMod.ITEMS.configureBlockLootTables(this.registryLookup, this);
        }
    }

    private static class MinekeaModelGenerator extends FabricModelProvider {
        private MinekeaModelGenerator(FabricPackOutput generator) {
            super(generator);
        }

        @Override
        public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureBlockStateModels(blockStateModelGenerator);
            }

//            MinekeaMod.ITEMS.configureBlockStateModels(blockStateModelGenerator);
        }

        @Override
        public void generateItemModels(ItemModelGenerators itemModelGenerator) {
            for (BlockDataGeneratorGroup group : ModBlockDataGenerators.BLOCK_GROUPS) {
                group.configureItemModels(itemModelGenerator);
            }

            for (ItemDataGeneratorGroup group : ModItemDataGenerators.ITEM_GROUPS) {
                group.configureItemModels(itemModelGenerator);
            }

//            MinekeaMod.ITEMS.configureItemModels(itemModelGenerator);
        }

        @Override
        public @NotNull String getName() {
            return "MinekeaModelGenerator";
        }
    }
}
