package org.nano.guidance.util.item.container

import org.bukkit.NamespacedKey
import org.bukkit.inventory.meta.ItemMeta
import org.bukkit.persistence.PersistentDataContainer
import org.bukkit.persistence.PersistentDataType
import org.nano.guidance.Guidance

@Suppress("UNCHECKED_CAST")
abstract class ItemContainer<T : ItemContainer<T>>{
    protected lateinit var meta: ItemMeta
    protected val persist: PersistentDataContainer
        get() = meta.persistentDataContainer

    fun setData(key: String, value: String): T {
        val keyRef = NamespacedKey(Guidance.getProvidingPlugin(Guidance::class.java), key)
        persist.set(keyRef, PersistentDataType.STRING, value)
        return this as T
    }

    fun removeData(key: String): T {
        val keyRef = NamespacedKey(Guidance.getProvidingPlugin(Guidance::class.java), key)
        persist.remove(keyRef)
        return this as T
    }

    fun initData(): T {
        persist.keys.forEach { key ->
            persist.remove(key)
        }
        return this as T
    }
    fun complete(): T{
        return this as T
    }
}