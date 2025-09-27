package pics.krzysiu.explosion

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.event.player.AttackEntityCallback
import net.fabricmc.fabric.api.event.player.UseItemCallback
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents.ModifyEntries
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.server.network.ServerPlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.text.Text
import net.minecraft.util.ActionResult
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.blocks.KrzysNiskiBlock
import pics.krzysiu.explosion.items.DarknessSword
import pics.krzysiu.explosion.items.KrzysNiskiItem
import pics.krzysiu.explosion.items.MeguminStaff
import pics.krzysiu.explosion.magic.SpellBuilder
import pics.krzysiu.explosion.magic.Spells
import java.util.function.Supplier
import kotlin.random.Random


object ModItems {
    fun initialize() {
        KrzysNiskiItem.INSTANCE







        MeguminStaff.INSTANCE
        UseItemCallback.EVENT.register(UseItemCallback { player, world, hand ->
            if (world.isClient) return@UseItemCallback ActionResult.PASS

            val serverWorld = world as ServerWorld
            val stack = player.getStackInHand(hand)

            if (stack.item is MeguminStaff) {
                SpellBuilder.castSpell(Spells.FIREBALL,projectile = true,player,serverWorld)
            }


            ActionResult.SUCCESS
        })






        DarknessSword.INSTANCE
        AttackEntityCallback.EVENT.register(AttackEntityCallback { player, world, hand, entity, _ ->
            val stack = player.getStackInHand(hand)

            if (stack.item is DarknessSword && Random.nextBoolean()) {
                player.sendMessage(Text.translatable("explosion.items.darkness_sword.miss"), false)
                return@AttackEntityCallback ActionResult.FAIL
            }

            ActionResult.PASS
        })
        ServerTickEvents.END_SERVER_TICK.register { server ->
            server.playerManager.playerList.forEach { player ->
                if (player is ServerPlayerEntity) {
                    val stack = player.mainHandStack
                    if (stack.item is DarknessSword) {
                        val health = player.health

                        player.removeStatusEffect(StatusEffects.STRENGTH)

                        when {
                            health < 5f -> player.addStatusEffect(
                                StatusEffectInstance(
                                    StatusEffects.STRENGTH,
                                    60,
                                    2,
                                    false,
                                    false,
                                    true
                                )
                            ) // Strength III
                            health < 10f -> player.addStatusEffect(StatusEffectInstance(StatusEffects.STRENGTH, 1, 1, false, false, true)) // Strength II
                            health < 15f -> player.addStatusEffect(StatusEffectInstance(StatusEffects.STRENGTH, 1, 0, false, false, true)) // Strength I
                        }
                    }
                }
            }
        }




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
                itemGroup?.add(KrzysNiskiBlock.INSTANCE)
                itemGroup?.add(DarknessSword.INSTANCE)
                itemGroup?.add(MeguminStaff.INSTANCE)
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
