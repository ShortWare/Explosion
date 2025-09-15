package pics.krzysiu.explosion.client.entities.krzysniskientity

import net.minecraft.client.model.Dilation
import net.minecraft.client.model.ModelData
import net.minecraft.client.model.ModelPart
import net.minecraft.client.model.ModelPartBuilder
import net.minecraft.client.model.ModelTransform
import net.minecraft.client.model.TexturedModelData
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.state.EntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion


class KrzysNiskiEntityModel(root: ModelPart) : EntityModel<EntityRenderState>(root) {
    companion object {
        val MAIN_LAYER: EntityModelLayer = EntityModelLayer(Identifier.of(Explosion.MOD_ID,"krzys_niski_entity"),"main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.getRoot()
            val bb_main = modelPartData.addChild(
                "bb_main",
                ModelPartBuilder.create().uv(0, 0).cuboid(-1.0f, -2.0f, -1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.origin(0.0f, 24.0f, 0.0f)
            )
            return TexturedModelData.of(modelData, 16, 16)
        }
    }

    private var bb_main: ModelPart? = null
    fun krzysniskientity(root: ModelPart) {
        this.bb_main = root.getChild("bb_main")
    }

    fun renderCustom(
        matrices: MatrixStack,
        vertices: VertexConsumer,
        light: Int,
        overlay: Int,
        color: Int
    ) {
        bb_main?.render(matrices, vertices, light, overlay, color)
    }



//    public override fun render(
//        matrices: MatrixStack?,
//        vertexConsumer: VertexConsumer?,
//        light: Int,
//        overlay: Int,
//        color: Int
//    ) {
//        bb_main?.render(matrices, vertexConsumer, light, overlay, color)
//    }
}