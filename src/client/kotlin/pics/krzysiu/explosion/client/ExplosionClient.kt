package pics.krzysiu.explosion.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.minecraft.client.MinecraftClient
import net.minecraft.client.sound.PositionedSoundInstance
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload


class ExplosionClient : ClientModInitializer {

    override fun onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver<PlaySoundS2CPayload>(
            PlaySoundS2CPayload.ID
        ) { payload: PlaySoundS2CPayload?, context: ClientPlayNetworking.Context? ->
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(payload?.sound, 1f, 3f));
        }
    }
}
