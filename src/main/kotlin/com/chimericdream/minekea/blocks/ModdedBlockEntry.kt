package com.chimericdream.minekea.blocks

data class ModdedBlockEntry(
    val modId: String,
    val material: String,
    val materialName: String,
    val logTextureSuffix: String? = null,
)