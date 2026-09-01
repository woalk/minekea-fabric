package com.chimericdream.minekea.util

import com.chimericdream.lib.blocks.BlockConfig

fun BlockConfig.copy(): BlockConfig {
    return BlockConfig()
        .settings(baseSettings)
        .item(item)
        .itemName(itemName)
        .material(material)
        .materialName(materialName)
        .name(name)
        .ingredient(ingredient)
        .tagIngredient(tagIngredient)
        .flammable(isFlammable)
        .tool(tool)
        .translucent(isTranslucent)
        .texture(texture)
        .renderType(renderType)
}
