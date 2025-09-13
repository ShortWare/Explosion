package pics.krzysiu.explosion

import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier

object ModItems {
    val KRZYS_NISKI: Item =
        register("krzys_jest_niski", ::Item, Item.Settings())

    fun initialize() {
    }

    fun register(
        name: String,
        itemFactory: (Item.Settings) -> Item,
        settings: Item.Settings
    ): Item {
        val itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Explosion.MOD_ID, name))
        val item = itemFactory(settings.registryKey(itemKey))
        Registry.register(Registries.ITEM, itemKey, item)
        return item
    }
}
