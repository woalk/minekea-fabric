package com.chimericdream.minekea.blocks

import com.chimericdream.lib.blocks.BlockConfig
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.function.Supplier

class LazyBlockConfig: BlockConfig() {
    typealias IngredientSupplier = (key: String?) -> Block?
    typealias TagIngredientSupplier = (key: String?) -> TagKey<Item>?

    var ingredientKeyedSupplier: IngredientSupplier? = null
    var tagIngredientKeyedSupplier: TagIngredientSupplier? = null

    fun ingredientFunc(supplier: IngredientSupplier): LazyBlockConfig {
        ingredientKeyedSupplier = supplier
        return this
    }

    fun tagIngredientFunc(supplier: TagIngredientSupplier): LazyBlockConfig {
        tagIngredientKeyedSupplier = supplier
        return this
    }

    override fun material(material: String): LazyBlockConfig {
        return super.material(material) as LazyBlockConfig
    }

    override fun materialName(materialName: String?): LazyBlockConfig {
        return super.materialName(materialName) as LazyBlockConfig
    }

    override fun getIngredient(): Block? = ingredientKeyedSupplier?.invoke(null) ?: super.ingredient

    override fun getIngredient(key: String): Block? = ingredientKeyedSupplier?.invoke(key) ?: super.getIngredient(key)

    override fun getTagIngredient(): TagKey<Item>? = tagIngredientKeyedSupplier?.invoke(null) ?: super.tagIngredient

    override fun getTagIngredient(key: String?): TagKey<Item>? = tagIngredientKeyedSupplier?.invoke(key) ?: super.getTagIngredient(key)
}