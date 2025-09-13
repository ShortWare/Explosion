package pics.krzysiu.explosion.items

import net.minecraft.component.type.TooltipDisplayComponent
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Rarity
import pics.krzysiu.explosion.ModItems
import java.util.function.Consumer


class KrzysNiskiItem(settings: Settings) : Item(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        context: TooltipContext?,
        displayComponent: TooltipDisplayComponent?,
        textConsumer: Consumer<Text?>,
        type: TooltipType?
    ) {
        textConsumer.accept(
            Text.translatable("explosion.krzys_jest_niski.description").formatted(Formatting.GOLD)
        )
    }

    companion object {
        val INSTANCE: Item = ModItems.register(
            "krzys_jest_niski",
            ::KrzysNiskiItem,
            Item.Settings()
                .maxCount(17)
                .rarity(Rarity.EPIC)
        )
    }
}
