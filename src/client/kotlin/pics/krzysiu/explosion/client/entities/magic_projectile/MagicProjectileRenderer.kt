package pics.krzysiu.explosion.client.entities.magic_projectile

import net.minecraft.client.render.OverlayTexture
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexConsumerProvider
import net.minecraft.client.render.entity.EntityRendererFactory
import net.minecraft.client.render.entity.MobEntityRenderer
import net.minecraft.client.render.entity.ProjectileEntityRenderer
import net.minecraft.client.render.entity.state.LivingEntityRenderState
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion
import pics.krzysiu.explosion.entities.ChomusukeEntity
import pics.krzysiu.explosion.entities.MagicProjectileEntity

class MagicProjectileRenderer(context: EntityRendererFactory.Context) :
    ProjectileEntityRenderer<MagicProjectileEntity, ProjectileEntityRenderState>(
        context
    ) {

    val model = MagicProjectileModel(context.getPart(MagicProjectileModel.MAIN_LAYER))
    override fun render(
        state: ProjectileEntityRenderState,
        matrices: MatrixStack,
        vertexConsumers: VertexConsumerProvider,
        light: Int
    ) {
        val texture = Identifier.of(Explosion.MOD_ID, "textures/entity/magic_projectile/projectile.png")
        model.renderCustom(
            matrices,
            vertexConsumers.getBuffer(RenderLayer.getEntityCutout(texture)),
            light,
            OverlayTexture.DEFAULT_UV
        )
    }

    override fun createRenderState(): ProjectileEntityRenderState {
        return ProjectileEntityRenderState()
    }

    override fun getTexture(state: ProjectileEntityRenderState?): Identifier? {
        TODO("Not yet implemented")
    }

}