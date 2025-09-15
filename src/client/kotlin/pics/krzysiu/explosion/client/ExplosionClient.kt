package pics.krzysiu.explosion.client

import net.fabricmc.api.ClientModInitializer
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry
import net.fabricmc.loader.api.metadata.ModEnvironment
import net.minecraft.client.MinecraftClient
import net.minecraft.client.render.entity.EntityRenderer
import net.minecraft.client.sound.PositionedSoundInstance
import net.minecraft.entity.EntityType
import pics.krzysiu.explosion.ModEntities
import pics.krzysiu.explosion.client.entities.krzysniskientity.KrzysNiskiEntityModel
import pics.krzysiu.explosion.client.entities.krzysniskientity.KrzysNiskiEntityRenderer
import pics.krzysiu.explosion.entities.KrzysNiskiEntity
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload


class ExplosionClient : ClientModInitializer {

    override fun onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver<PlaySoundS2CPayload>(
            PlaySoundS2CPayload.ID
        ) { payload: PlaySoundS2CPayload?, context: ClientPlayNetworking.Context? ->
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(payload?.sound, 1f, 3f));
        }









        EntityModelLayerRegistry.registerModelLayer(
            KrzysNiskiEntityModel.MAIN_LAYER
        ) { KrzysNiskiEntityModel.getTexturedModelData() }

        EntityRendererRegistry.register<KrzysNiskiEntity>(
            ModEntities.KRZYS_NISKI_ENTITY
        ) { context ->
            KrzysNiskiEntityRenderer(context)
        }
    }
}
