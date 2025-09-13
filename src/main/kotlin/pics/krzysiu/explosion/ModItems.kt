package pics.krzysiu.explosion

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.text.Text
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.items.KrzysNiskiItem
import java.util.function.Supplier


object ModItems {
    fun initialize() {
        KrzysNiskiItem.INSTANCE

        val itemGroupKey = RegistryKey.of<ItemGroup?>(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of("explosion", "item_group")
        )
        val itemGroup = FabricItemGroup.builder()
            .icon(Supplier { ItemStack(KrzysNiskiItem.INSTANCE) })
            .displayName(Text.of("Explosion"))
            .build()

        Registry.register(Registries.ITEM_GROUP, itemGroupKey, itemGroup)
        ItemGroupEvents.modifyEntriesEvent(itemGroupKey)
            .register(ModifyEntries { itemGroup: FabricItemGroupEntries? ->
                itemGroup?.add(KrzysNiskiItem.INSTANCE)
            })
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
