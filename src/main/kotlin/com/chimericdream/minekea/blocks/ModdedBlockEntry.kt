package com.chimericdream.minekea.blocks

data class ModdedBlockEntry(
    val modId: String,
    val material: String,
    val materialName: String,
    val logMaterial: String = "log",
    val logTextureSuffix: String = logMaterial,
)