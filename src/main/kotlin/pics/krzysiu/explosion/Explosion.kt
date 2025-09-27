package pics.krzysiu.explosion

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents
import net.fabricmc.fabric.api.`object`.builder.v1.entity.FabricDefaultAttributeRegistry
import net.fabricmc.loader.api.metadata.ModEnvironment
import net.minecraft.nbt.NbtCompound
import net.minecraft.server.world.ServerWorld
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pics.krzysiu.explosion.entities.ChomusukeEntity
import pics.krzysiu.explosion.entities.KrzysNiskiEntity
import pics.krzysiu.explosion.entities.MagicProjectileEntity
import pics.krzysiu.explosion.magic.ManaHandler
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload

interface IEntityDataSaver {
    fun getPersistentData(): NbtCompound
}

class Explosion : ModInitializer {
    val LOGGER: Logger? = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.initialize()
        ModBlocks.initialize()
        ModSounds.initialize()



        ModEntities.initialize()

        FabricDefaultAttributeRegistry.register(ModEntities.KRZYS_NISKI_ENTITY, KrzysNiskiEntity.createAttributes())
        FabricDefaultAttributeRegistry.register(ModEntities.CHOMUSUKE_ENTITY, ChomusukeEntity.createAttributes())







        PayloadTypeRegistry.playS2C().register(
            PlaySoundS2CPayload.ID,
            PlaySoundS2CPayload.CODEC);




        var oneSecUpdateCounter = 0
        ServerTickEvents.END_WORLD_TICK.register { world: ServerWorld ->
            if (world.players.isEmpty()) return@register

            oneSecUpdateCounter++
            if (oneSecUpdateCounter < 20) return@register
            oneSecUpdateCounter = 0

            for (player in world.players) {
                ManaHandler.alterMana(player as IEntityDataSaver, 10)
            }
        }



        LOGGER?.info("Krzyś jest niski!")
    }

    companion object {
        @JvmField
        val MOD_ID: String = "explosion"
    }
}
