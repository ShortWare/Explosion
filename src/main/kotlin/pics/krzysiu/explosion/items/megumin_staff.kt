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

class MeguminStaff(settings: Settings) : Item(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        context: TooltipContext?,
        displayComponent: TooltipDisplayComponent?,
        textConsumer: Consumer<Text?>,
        type: TooltipType?
    ) {
        textConsumer.accept(Text.translatable("explosion.items.megumin_staff.description1").formatted(Formatting.GREEN))
        textConsumer.accept(Text.translatable("explosion.items.megumin_staff.description2").formatted(Formatting.RED))
    }

    companion object {
        val INSTANCE: Item = ModItems.register(
            "megumin_staff",
            ::MeguminStaff,
            Settings()
                .maxCount(1)
                .rarity(Rarity.EPIC)
        )
    }
}
