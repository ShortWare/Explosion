package pics.krzysiu.explosion.items

import net.minecraft.item.Item
import net.minecraft.util.Rarity
import pics.krzysiu.explosion.ModItems

object KrzysNiskiItem {
    val INSTANCE: Item = ModItems.register(
        "krzys_jest_niski",
        ::Item,
        Item.Settings()
            .maxCount(17)
            .rarity(Rarity.EPIC)
    )
}
