package com.chimericdream.minekea.blocks

import com.chimericdream.lib.blocks.BlockConfig
import dev.architectury.registry.registries.RegistrySupplier
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.Identifier
import net.minecraft.world.level.block.Block
import java.util.function.Supplier

class LazyBlockConfig: BlockConfig() {
    typealias IngredientSupplier = (key: String?) -> Block?

    var ingredientKeyedSupplier: IngredientSupplier? = null

    fun ingredientFunc(supplier: IngredientSupplier): LazyBlockConfig {
        ingredientKeyedSupplier = supplier
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
}