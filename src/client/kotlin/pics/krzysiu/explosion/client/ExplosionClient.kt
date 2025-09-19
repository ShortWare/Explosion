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
import pics.krzysiu.explosion.client.entities.chomusuke.ChomusukeModel
import pics.krzysiu.explosion.client.entities.chomusuke.ChomusukeRenderer
import pics.krzysiu.explosion.client.entities.krzysniskientity.KrzysNiskiEntityModel
import pics.krzysiu.explosion.client.entities.krzysniskientity.KrzysNiskiEntityRenderer
import pics.krzysiu.explosion.client.entities.magic_projectile.MagicProjectileModel
import pics.krzysiu.explosion.client.entities.magic_projectile.MagicProjectileRenderer
import pics.krzysiu.explosion.entities.ChomusukeEntity
import pics.krzysiu.explosion.entities.KrzysNiskiEntity
import pics.krzysiu.explosion.entities.MagicProjectileEntity
import pics.krzysiu.explosion.networking.PlaySoundS2CPayload


class ExplosionClient : ClientModInitializer {

    override fun onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver<PlaySoundS2CPayload>(
            PlaySoundS2CPayload.ID
        ) { payload: PlaySoundS2CPayload?, context: ClientPlayNetworking.Context? ->
            MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(payload?.sound, 1f, 3f));
        }









        /*

          ______ _   _ _______ _____ _______ _____ ______  _____
         |  ____| \ | |__   __|_   _|__   __|_   _|  ____|/ ____|
         | |__  |  \| |  | |    | |    | |    | | | |__  | (___
         |  __| | . ` |  | |    | |    | |    | | |  __|  \___ \
         | |____| |\  |  | |   _| |_   | |   _| |_| |____ ____) |
         |______|_| \_|  |_|  |_____|  |_|  |_____|______|_____/

        */

        // krzys_niski_entity
        EntityModelLayerRegistry.registerModelLayer(
            KrzysNiskiEntityModel.MAIN_LAYER
        ) { KrzysNiskiEntityModel.getTexturedModelData() }

        EntityRendererRegistry.register<KrzysNiskiEntity>(
            ModEntities.KRZYS_NISKI_ENTITY
        ) { context ->
            KrzysNiskiEntityRenderer(context)
        }


        // chomusuke
        EntityModelLayerRegistry.registerModelLayer(
            ChomusukeModel.MAIN_LAYER
        ) { ChomusukeModel.getTexturedModelData() }

        EntityRendererRegistry.register<ChomusukeEntity>(
            ModEntities.CHOMUSUKE_ENTITY
        ) { context ->
            ChomusukeRenderer(context)
        }


        // magic_projectile
        EntityModelLayerRegistry.registerModelLayer(
            MagicProjectileModel.MAIN_LAYER
        ) { MagicProjectileModel.getTexturedModelData() }

        EntityRendererRegistry.register<MagicProjectileEntity>(
            ModEntities.MAGIC_PROJECTILE_ENTITY
        ) { context ->
            MagicProjectileRenderer(context)
        }
    }
}
