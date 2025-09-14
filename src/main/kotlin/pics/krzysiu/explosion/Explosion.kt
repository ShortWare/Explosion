package pics.krzysiu.explosion

import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload

class Explosion : ModInitializer {
    val LOGGER: Logger? = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.initialize()
        ModBlocks.initialize()
        ModSounds.initialize()

        PayloadTypeRegistry.playS2C().register(
            PlaySoundS2CPayload.ID,
            PlaySoundS2CPayload.CODEC);

        LOGGER?.info("Krzyś jest niski!")
    }

    companion object {
        @JvmField
        val MOD_ID: String = "explosion"
    }
}
