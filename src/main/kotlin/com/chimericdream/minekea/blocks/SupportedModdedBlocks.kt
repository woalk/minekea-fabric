package com.chimericdream.minekea.blocks

object SupportedModdedBlocks {
    object BetterNether {
        const val MOD_ID = "betternether"

        @JvmStatic
        val woods: List<ModdedBlockEntry>
            field = ArrayList()

        val netherReed = registerWood(ModdedBlockEntry(MOD_ID, "nether_reed", "Reeds", "planks"))
        val stalagnate = registerWood(ModdedBlockEntry(MOD_ID, "stalagnate", "Stalagnate", logTextureSuffix = "bark_side"))
        val willow = registerWood(ModdedBlockEntry(MOD_ID, "willow", "Willow", logTextureSuffix = "bark"))
        val wart = registerWood(ModdedBlockEntry(MOD_ID, "wart", "Wart", logTextureSuffix = "bark"))
        val rubeus = registerWood(ModdedBlockEntry(MOD_ID, "rubeus", "Rubeus", logTextureSuffix = "log_side"))
        val mushroomFir = registerWood(ModdedBlockEntry(MOD_ID, "mushroom_fir", "Mushroom Fir", logTextureSuffix = "bark"))
        val anchorTree = registerWood(ModdedBlockEntry(MOD_ID, "anchor_tree", "Anchor Tree", logTextureSuffix = "log_side"))
        val netherMushroom = registerWood(ModdedBlockEntry(MOD_ID, "nether_mushroom", "Mushroom", "planks"))
        val netherSakura = registerWood(ModdedBlockEntry(MOD_ID, "nether_sakura", "Nether Sakura", logTextureSuffix = "log_side"))
        val gloomwood = registerWood(ModdedBlockEntry(MOD_ID, "gloomwood", "Gloomwood", logTextureSuffix = "log_side"))
        val darkGloomwood = registerWood(ModdedBlockEntry(MOD_ID, "gloomwood_dark", "Dark Gloomwood", logTextureSuffix = "log_side"))

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

        val helixTree = registerWood(ModdedBlockEntry(MOD_ID, "helix_tree", "Helix Tree", logTextureSuffix = "log_side"))
        val mossyGlowshroom = registerWood(ModdedBlockEntry(MOD_ID, "mossy_glowshroom", "Mossy Glowshroom", logTextureSuffix = "log_side"))
        val tenanea = registerWood(ModdedBlockEntry(MOD_ID, "tenanea", "Tenanea", logTextureSuffix = "log_side"))
        val pythadendron = registerWood(ModdedBlockEntry(MOD_ID, "pythadendron", "Pythadendron", logTextureSuffix = "log_side"))
        val endLotus = registerWood(ModdedBlockEntry(MOD_ID, "end_lotus", "End Lotus", logTextureSuffix = "log_side"))
        val lacugrove = registerWood(ModdedBlockEntry(MOD_ID, "lacugrove", "Lacugrove", logTextureSuffix = "log_side"))
        val dragonTree = registerWood(ModdedBlockEntry(MOD_ID, "dragon_tree", "Dragon Tree", logTextureSuffix = "log_side"))
        val umbrellaTree = registerWood(ModdedBlockEntry(MOD_ID, "umbrella_tree", "Umbrella Tree", logTextureSuffix = "log_side"))
        val jellyshroom = registerWood(ModdedBlockEntry(MOD_ID, "jellyshroom", "Jellyshroom", logTextureSuffix = "log_side"))
        val lucernia = registerWood(ModdedBlockEntry(MOD_ID, "lucernia", "Lucernia", logTextureSuffix = "log_side"))

        private fun registerWood(entry: ModdedBlockEntry): ModdedBlockEntry {
            woods.add(entry)
            return entry
        }
    }
}