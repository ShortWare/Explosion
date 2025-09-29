package pics.krzysiu.explosion.networking

import net.minecraft.network.RegistryByteBuf
import net.minecraft.network.codec.PacketCodec
import net.minecraft.network.codec.PacketCodecs
import net.minecraft.network.packet.CustomPayload
import net.minecraft.sound.SoundEvent
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion
import java.util.function.Function

@JvmRecord
data class PlaySoundS2CPayload(val sound: SoundEvent?) : CustomPayload {
    override fun getId(): CustomPayload.Id<out CustomPayload?> {
        return ID
    }

    companion object {
        val PLAY_SOUND_PAYLOAD_ID: Identifier? = Identifier.of(Explosion.MOD_ID, "play_sound")
        val ID: CustomPayload.Id<PlaySoundS2CPayload?> = CustomPayload.Id<PlaySoundS2CPayload?>(PLAY_SOUND_PAYLOAD_ID)
        val CODEC: PacketCodec<RegistryByteBuf?, PlaySoundS2CPayload?> =
            PacketCodec.tuple<RegistryByteBuf?, PlaySoundS2CPayload?, SoundEvent?>(
                SoundEvent.PACKET_CODEC,
                PlaySoundS2CPayload::sound
            ) { sound: SoundEvent? -> PlaySoundS2CPayload(sound) }
    }
}

@JvmRecord
data class UpdateManaS2CPayload(val value: Int?) : CustomPayload {
    override fun getId(): CustomPayload.Id<out CustomPayload?> {
        return ID
    }

    companion object {
        val UPDATE_MANA_PAYLOAD_ID: Identifier? = Identifier.of(Explosion.MOD_ID, "update_mana")
        val ID: CustomPayload.Id<UpdateManaS2CPayload?> = CustomPayload.Id<UpdateManaS2CPayload?>(UPDATE_MANA_PAYLOAD_ID)
        val CODEC: PacketCodec<RegistryByteBuf?, UpdateManaS2CPayload?> =
            PacketCodec.tuple<RegistryByteBuf?, UpdateManaS2CPayload?, Int?>(
                PacketCodecs.INTEGER,
                UpdateManaS2CPayload::value
            ) { value: Int? -> UpdateManaS2CPayload(value) }
    }
}