package com.chimericdream.minekea.blocks

object SupportedModdedBlocks {
    object BetterEnd {
        const val MOD_ID = "betterend"

        @JvmStatic
        val woods = ArrayList<ModdedBlockEntry>()

        val helixTree = registerWood(ModdedBlockEntry(MOD_ID, "helix_tree", "Helix Tree", "_side"))
        val mossyGlowshroom = registerWood(ModdedBlockEntry(MOD_ID, "mossy_glowshroom", "Mossy Glowshroom", "_side"))
        val tenanea = registerWood(ModdedBlockEntry(MOD_ID, "tenanea", "Tenanea", "_side"))
        val pythadendron = registerWood(ModdedBlockEntry(MOD_ID, "pythadendron", "Pythadendron", "_side"))
        val endLotus = registerWood(ModdedBlockEntry(MOD_ID, "end_lotus", "End Lotus", "_side"))
        val lacugrove = registerWood(ModdedBlockEntry(MOD_ID, "lacugrove", "Lacugrove", "_side"))
        val dragonTree = registerWood(ModdedBlockEntry(MOD_ID, "dragon_tree", "Dragon Tree", "_side"))
        val umbrellaTree = registerWood(ModdedBlockEntry(MOD_ID, "umbrella_tree", "Umbrella Tree", "_side"))
        val jellyshroom = registerWood(ModdedBlockEntry(MOD_ID, "jellyshroom", "Jellyshroom", "_side"))
        val lucernia = registerWood(ModdedBlockEntry(MOD_ID, "lucernia", "Lucernia", "_side"))

        private fun registerWood(entry: ModdedBlockEntry): ModdedBlockEntry {
            woods.add(entry)
            return entry
        }
    }
}