package pics.krzysiu.explosion.items

import com.google.common.base.CharMatcher
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking
import net.minecraft.component.type.FoodComponent
import net.minecraft.component.type.TooltipDisplayComponent
import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.equipment.ArmorMaterial
import net.minecraft.item.equipment.EquipmentType
import net.minecraft.item.tooltip.TooltipType
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.server.command.ServerCommandSource
import net.minecraft.sound.SoundCategory
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents
import net.minecraft.text.Text
import net.minecraft.util.Formatting
import net.minecraft.util.Identifier
import net.minecraft.util.Rarity
import net.minecraft.util.packrat.ParseResults
import pics.krzysiu.explosion.ModItems
import pics.krzysiu.explosion.ModSounds
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload
import java.util.Map
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
            Text.translatableWithFallback("explosion.krzys_jest_niski.description","Bardzo niski Krzyś").formatted(Formatting.GOLD)
        )
    }

    override fun postHit(
        stack: ItemStack,
        target: LivingEntity,
        attacker: LivingEntity
    ) {
        if (attacker is net.minecraft.server.network.ServerPlayerEntity) {
            attacker.sendMessage(
                Text.literal("§a[Krzyś] AAAAAA"),
                false
            )

            ServerPlayNetworking.send(attacker, PlaySoundS2CPayload(ModSounds.KRZYSIU_AI));
        }

        return super.postHit(stack, target, attacker)
    }

    companion object {
        val INSTANCE: Item = ModItems.register(
            "krzys_jest_niski",
            ::KrzysNiskiItem,
            Item.Settings()
                .maxCount(17)
                .rarity(Rarity.EPIC)
                .food(FoodComponent.Builder().nutrition(20).alwaysEdible().build())
        )
    }
}
