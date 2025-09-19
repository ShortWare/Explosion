package pics.krzysiu.explosion.client.entities.magic_projectile

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.state.EntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion


class MagicProjectileModel(root: ModelPart) : EntityModel<EntityRenderState>(root) {
    private val bb_main: ModelPart = root.getChild("bb_main")

    fun renderCustom(
        matrices: MatrixStack,
        vertices: VertexConsumer,
        light: Int,
        overlay: Int
    ) {
        bb_main.render(matrices, vertices, light, overlay)
    }

    companion object {
        val MAIN_LAYER: EntityModelLayer = EntityModelLayer(Identifier.of(Explosion.MOD_ID, "magic_projectile"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.getRoot()
            val bb_main = modelPartData.addChild(
                "bb_main",
                ModelPartBuilder.create().uv(0, 0).cuboid(-3.0f, -3.0f, -3.0f, 6.0f, 6.0f, 6.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 3f, 0.0f,0f,0f,0f)
            )
            return TexturedModelData.of(modelData, 32, 32)
        }


    }
}