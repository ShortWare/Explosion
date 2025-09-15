package pics.krzysiu.explosion.client.entities.krzysniskientity

import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion
import pics.krzysiu.explosion.entities.KrzysNiskiEntity

class KrzysNiskiEntityRenderer(context: EntityRendererFactory.Context) :
    MobEntityRenderer<KrzysNiskiEntity, LivingEntityRenderState, KrzysNiskiEntityModel>(
        context,
        KrzysNiskiEntityModel(context.getPart(KrzysNiskiEntityModel.MAIN_LAYER)),
        0.75f
    ) {

    override fun getTexture(state: LivingEntityRenderState): Identifier? {
        return Identifier.of(Explosion.MOD_ID,"textures/entity/krzys_niski_entity/krzys.png")
    }

    override fun render(
        livingEntityRenderState: LivingEntityRenderState?,
        matrixStack: MatrixStack?,
        vertexConsumerProvider: VertexConsumerProvider?,
        i: Int
    ) {
        super.render(livingEntityRenderState, matrixStack, vertexConsumerProvider, i)
    }

    override fun createRenderState(): LivingEntityRenderState {
        return LivingEntityRenderState()
    }

}