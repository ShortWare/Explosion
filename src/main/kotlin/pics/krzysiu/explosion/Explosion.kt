package pics.krzysiu.explosion

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Explosion : ModInitializer {
    val LOGGER: Logger? = LoggerFactory.getLogger(MOD_ID)

    override fun onInitialize() {
        ModItems.initialize()
        ModBlocks.initialize()
        ModSounds.initialize()
        LOGGER?.info("Krzyś jest niski!")
    }

    companion object {
        @JvmField
        val MOD_ID: String = "explosion"
    }
}
