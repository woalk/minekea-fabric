package com.chimericdream.minekea.blocks

object SupportedModdedBlocks {
    object BetterNether {
        const val MOD_ID = "betternether"

        @JvmStatic
        val woods: List<ModdedBlockEntry>
            field = ArrayList()

        val netherReed = registerWood(ModdedBlockEntry(MOD_ID, "nether_reed", "Reeds", "planks", hasBookshelf = true))
        val stalagnate = registerWood(ModdedBlockEntry(MOD_ID, "stalagnate", "Stalagnate", logTextureSuffix = "bark_side", strippedLogTextureSuffix = "log_side", hasBookshelf = true))
        val willow = registerWood(ModdedBlockEntry(MOD_ID, "willow", "Willow", logTextureSuffix = "bark", strippedLogTextureSuffix = "log_side", hasBookshelf = true))
        val wart = registerWood(ModdedBlockEntry(MOD_ID, "wart", "Wart", logTextureSuffix = "bark", strippedLogTextureSuffix = "log_side", hasBookshelf = true))
        val rubeus = registerWood(ModdedBlockEntry(MOD_ID, "rubeus", "Rubeus", logTextureSuffix = "log_side", hasBookshelf = true))
        val mushroomFir = registerWood(ModdedBlockEntry(MOD_ID, "mushroom_fir", "Mushroom Fir", logTextureSuffix = "bark", strippedLogTextureSuffix = "log_side", hasBookshelf = true))
        val anchorTree = registerWood(ModdedBlockEntry(MOD_ID, "anchor_tree", "Anchor Tree", logTextureSuffix = "log_side", hasBookshelf = true))
        val netherMushroom = registerWood(ModdedBlockEntry(MOD_ID, "nether_mushroom", "Mushroom", "planks", hasBookshelf = true))
        val netherSakura = registerWood(ModdedBlockEntry(MOD_ID, "nether_sakura", "Nether Sakura", logTextureSuffix = "log_side", hasBookshelf = true))
        val gloomwood = registerWood(ModdedBlockEntry(MOD_ID, "gloomwood", "Gloomwood", logTextureSuffix = "log_side", hasBookshelf = true))
        val darkGloomwood = registerWood(ModdedBlockEntry(MOD_ID, "gloomwood_dark", "Dark Gloomwood", logTextureSuffix = "log_side", hasBookshelf = true))

        private fun registerWood(entry: ModdedBlockEntry): ModdedBlockEntry {
            woods.add(entry)
            return entry
        }
    }

    object BetterEnd {
        const val MOD_ID = "betterend"

        @JvmStatic
        val woods: List<ModdedBlockEntry>
            field = ArrayList()

        val helixTree = registerWood(ModdedBlockEntry(MOD_ID, "helix_tree", "Helix Tree", logTextureSuffix = "log_side", hasBookshelf = true))
        val mossyGlowshroom = registerWood(ModdedBlockEntry(MOD_ID, "mossy_glowshroom", "Mossy Glowshroom", logTextureSuffix = "log_side", hasBookshelf = true))
        val tenanea = registerWood(ModdedBlockEntry(MOD_ID, "tenanea", "Tenanea", logTextureSuffix = "log_side", hasBookshelf = true))
        val pythadendron = registerWood(ModdedBlockEntry(MOD_ID, "pythadendron", "Pythadendron", logTextureSuffix = "log_side", hasBookshelf = true))
        val endLotus = registerWood(ModdedBlockEntry(MOD_ID, "end_lotus", "End Lotus", logTextureSuffix = "log_side", hasBookshelf = true))
        val lacugrove = registerWood(ModdedBlockEntry(MOD_ID, "lacugrove", "Lacugrove", logTextureSuffix = "log_side", hasBookshelf = true))
        val dragonTree = registerWood(ModdedBlockEntry(MOD_ID, "dragon_tree", "Dragon Tree", logTextureSuffix = "log_side", hasBookshelf = true))
        val umbrellaTree = registerWood(ModdedBlockEntry(MOD_ID, "umbrella_tree", "Umbrella Tree", logTextureSuffix = "log_side", hasBookshelf = true))
        val jellyshroom = registerWood(ModdedBlockEntry(MOD_ID, "jellyshroom", "Jellyshroom", logTextureSuffix = "log_side", hasBookshelf = true))
        val lucernia = registerWood(ModdedBlockEntry(MOD_ID, "lucernia", "Lucernia", logTextureSuffix = "log_side", hasBookshelf = true))

        private fun registerWood(entry: ModdedBlockEntry): ModdedBlockEntry {
            woods.add(entry)
            return entry
        }
    }
}