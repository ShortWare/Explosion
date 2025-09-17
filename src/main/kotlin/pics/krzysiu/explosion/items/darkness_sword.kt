package pics.krzysiu.explosion.items

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.component.type.TooltipDisplayComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.ToolMaterial
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Rarity
import pics.krzysiu.explosion.ModItems
import pics.krzysiu.explosion.ModSounds
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload
import java.util.function.Consumer

class DarknessSword(settings: Settings) : Item(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        context: TooltipContext?,
        displayComponent: TooltipDisplayComponent?,
        textConsumer: Consumer<Text?>,
        type: TooltipType?
    ) {
        textConsumer.accept(Text.translatable("explosion.items.darkness_sword.description1").formatted(Formatting.RED))
        textConsumer.accept(Text.translatable("explosion.items.darkness_sword.description2").formatted(Formatting.GREEN))
    }

    companion object {
        val INSTANCE: Item = ModItems.register(
            "darkness_sword",
            ::DarknessSword,
            Settings()
                .maxCount(1)
                .rarity(Rarity.EPIC)
                .sword(ToolMaterial.NETHERITE, 3f, -2.4f)
        )
    }
}
