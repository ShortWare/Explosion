package pics.krzysiu.explosion

import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier

object ModSounds {
    val KRZYSIU_AI_ID = Identifier.of("explosion", "krzysiuai")
    val KRZYSIU_AI: SoundEvent = Registry.register(
        Registries.SOUND_EVENT,
        KRZYSIU_AI_ID,
        SoundEvent.of(KRZYSIU_AI_ID)
    )

    fun initialize() {

    }
}