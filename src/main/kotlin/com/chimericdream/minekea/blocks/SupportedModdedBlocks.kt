package com.chimericdream.minekea.blocks

object SupportedModdedBlocks {
    object BetterEnd {
        const val MOD_ID = "betterend"

        @JvmStatic
        val woods = ArrayList<ModdedBlockEntry>()

        val helixTree = registerWood(ModdedBlockEntry(MOD_ID, "helix_tree", "Helix Tree", "_side"))

        private fun registerWood(entry: ModdedBlockEntry): ModdedBlockEntry {
            woods.add(entry)
            return entry
        }
    }
}