package com.chimericdream.minekea.blocks

import net.minecraft.resources.Identifier

data class ModdedBlockEntry(
    val modId: String,
    val material: String,
    val materialName: String,
    val logMaterial: String = "log",
    val logTextureSuffix: String = logMaterial,
    val hasBookshelf: Boolean = false,
) {
    val bookshelf: Identifier?
        get() = if (hasBookshelf) {
            Identifier.fromNamespaceAndPath(modId, material + "_bookshelf")
        } else null
}