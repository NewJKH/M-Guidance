package org.nano.guidance.util.item.builder

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import org.nano.guidance.util.item.container.ItemContainer
import org.nano.guidance.util.message.color.ColorUtil

class ItemBuilder : ItemContainer<ItemBuilder>() {
    private lateinit var item: ItemStack

    fun create(material: Material): ItemBuilder {
        item = ItemStack(material)
        meta = item.itemMeta
        return this
    }

    fun material(material: Material): ItemBuilder {
        item = ItemStack.of(material)
        return this
    }

    fun display(display: String): ItemBuilder {
        meta.displayName(ColorUtil.format(display))
        return this
    }

    fun setLore(line: Int, lore: String): ItemBuilder {
        val loreList: MutableList<Component> = meta.lore()?.takeIf { it.isNotEmpty() }?.toMutableList() ?: mutableListOf()

        while(loreList.size < line ){
            loreList.add(Component.text(""))
        }

        loreList[line-1] = ColorUtil.format(lore)
        meta.lore(loreList)
        return this
    }

    fun appendLore(line: Int, lore: String): ItemBuilder {
        val loreList: MutableList<Component> = meta.lore()?.takeIf { it.isNotEmpty() }?.toMutableList() ?: mutableListOf()

        while(loreList.size < line ){
            loreList.add(Component.text(""))
        }

        loreList[line-1].append(ColorUtil.format(lore))
        meta.lore(loreList)
        return this
    }

    fun ea(ea: Int): ItemBuilder {
        item.amount = ea
        return this
    }

    fun model(customModelData: Int): ItemBuilder {
        meta.setCustomModelData(customModelData)
        return this
    }

    fun addUnsafeEnchant(enchantment: Enchantment, lv: Int): ItemBuilder{
        item.addUnsafeEnchantment(enchantment,lv)
        return this
    }

    fun removeEnchant(enchantment: Enchantment): ItemBuilder{
        meta.removeEnchant(enchantment)
        return this
    }


    fun build(): ItemStack{
        item.setItemMeta(meta)
        return item
    }

}