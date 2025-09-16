package pics.krzysiu.explosion.client.entities.chomusuke

import net.minecraft.client.model.*
import net.minecraft.client.render.VertexConsumer
import net.minecraft.client.render.entity.model.EntityModel
import net.minecraft.client.render.entity.model.EntityModelLayer
import net.minecraft.client.render.entity.state.EntityRenderState
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.Explosion


class ChomusukeModel(root: ModelPart) : EntityModel<EntityRenderState>(root) {

    fun renderCustom(
        matrices: MatrixStack,
        vertices: VertexConsumer,
        light: Int,
        overlay: Int,
        color: Int
    ) {
        body?.render(matrices, vertices, light, overlay, color)
        leg?.render(matrices, vertices, light, overlay, color)
        leg2?.render(matrices, vertices, light, overlay, color)
        leg3?.render(matrices, vertices, light, overlay, color)
        leg4?.render(matrices, vertices, light, overlay, color)
        head?.render(matrices, vertices, light, overlay, color)
        tail?.render(matrices, vertices, light, overlay, color)
        wing?.render(matrices, vertices, light, overlay, color)
        wing2?.render(matrices, vertices, light, overlay, color)
    }


    private var body: ModelPart? = null
    private var leg: ModelPart? = null
    private var leg2: ModelPart? = null
    private var leg3: ModelPart? = null
    private var leg4: ModelPart? = null
    private var head: ModelPart? = null
    private var tail: ModelPart? = null
    private var wing: ModelPart? = null
    private var wing2: ModelPart? = null

    fun chomusuke(root: ModelPart) {
        this.body = root.getChild("body")
        this.leg = root.getChild("leg")
        this.leg2 = root.getChild("leg2")
        this.leg3 = root.getChild("leg3")
        this.leg4 = root.getChild("leg4")
        this.head = root.getChild("head")
        this.tail = root.getChild("tail")
        this.wing = root.getChild("wing")
        this.wing2 = root.getChild("wing2")
    }

    companion object {
        val MAIN_LAYER: EntityModelLayer = EntityModelLayer(Identifier.of(Explosion.MOD_ID, "chomusuke"), "main")

        fun getTexturedModelData(): TexturedModelData {
            val modelData = ModelData()
            val modelPartData = modelData.getRoot()
            val body = modelPartData.addChild(
                "body",
                ModelPartBuilder.create().uv(38, 0).cuboid(-4.0f, -8.0f, -5.0f, 1.0f, 3.0f, 6.0f, Dilation(0.0f))
                    .uv(0, 26).cuboid(-3.0f, -9.0f, -6.0f, 13.0f, 4.0f, 1.0f, Dilation(0.0f))
                    .uv(28, 12).cuboid(-3.0f, -9.0f, 1.0f, 13.0f, 4.0f, 1.0f, Dilation(0.0f))
                    .uv(0, 0).cuboid(-3.0f, -10.0f, -5.0f, 13.0f, 6.0f, 6.0f, Dilation(0.0f))
                    .uv(28, 31).cuboid(10.0f, -9.0f, -5.0f, 1.0f, 4.0f, 6.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            val leg = modelPartData.addChild(
                "leg",
                ModelPartBuilder.create().uv(38, 9).cuboid(-3.0f, -5.0f, 0.0f, 2.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(42, 36).cuboid(-3.0f, -4.0f, -2.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f))
                    .uv(28, 47).cuboid(-3.0f, -2.0f, -2.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 1.0f, 0.0f, 0.0f, 0.0f)
            )

            val leg2 = modelPartData.addChild(
                "leg2",
                ModelPartBuilder.create().uv(44, 9).cuboid(8.0f, -5.0f, 0.0f, 2.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(40, 46).cuboid(8.0f, -4.0f, -2.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f))
                    .uv(48, 17).cuboid(8.0f, -2.0f, -2.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 1.0f, 0.0f, 0.0f, 0.0f)
            )

            val leg3 = modelPartData.addChild(
                "leg3",
                ModelPartBuilder.create().uv(48, 29).cuboid(8.0f, -5.0f, 0.0f, 2.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(0, 47).cuboid(8.0f, -4.0f, 0.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f))
                    .uv(48, 21).cuboid(8.0f, -2.0f, 1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, -6.0f, 0.0f, 0.0f, 0.0f)
            )

            val leg4 = modelPartData.addChild(
                "leg4",
                ModelPartBuilder.create().uv(50, 9).cuboid(-3.0f, -5.0f, 0.0f, 2.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(10, 47).cuboid(-3.0f, -4.0f, 0.0f, 2.0f, 2.0f, 3.0f, Dilation(0.0f))
                    .uv(48, 25).cuboid(-3.0f, -2.0f, 1.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, -6.0f, 0.0f, 0.0f, 0.0f)
            )

            val head = modelPartData.addChild(
                "head",
                ModelPartBuilder.create().uv(0, 12).cuboid(-6.0f, -15.0f, -4.0f, 6.0f, 6.0f, 8.0f, Dilation(0.0f))
                    .uv(28, 17).cuboid(-5.0f, -16.0f, -3.0f, 4.0f, 1.0f, 6.0f, Dilation(0.0f))
                    .uv(28, 24).cuboid(-5.0f, -9.0f, -3.0f, 4.0f, 1.0f, 6.0f, Dilation(0.0f))
                    .uv(0, 31).cuboid(-7.0f, -14.0f, -3.0f, 1.0f, 4.0f, 6.0f, Dilation(0.0f))
                    .uv(14, 31).cuboid(0.0f, -14.0f, -3.0f, 1.0f, 4.0f, 6.0f, Dilation(0.0f))
                    .uv(40, 41).cuboid(-5.0f, -14.0f, 4.0f, 4.0f, 4.0f, 1.0f, Dilation(0.0f))
                    .uv(42, 31).cuboid(-5.0f, -14.0f, -5.0f, 4.0f, 4.0f, 1.0f, Dilation(0.0f))
                    .uv(0, 41).cuboid(-4.0f, -17.0f, 2.0f, 2.0f, 3.0f, 3.0f, Dilation(0.0f))
                    .uv(10, 41).cuboid(-3.0f, -18.0f, 3.0f, 2.0f, 3.0f, 3.0f, Dilation(0.0f))
                    .uv(30, 41).cuboid(-3.0f, -18.0f, -6.0f, 2.0f, 3.0f, 3.0f, Dilation(0.0f))
                    .uv(20, 41).cuboid(-4.0f, -17.0f, -5.0f, 2.0f, 3.0f, 3.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, -2.0f, 0.0f, 0.0f, 0.0f)
            )

            val tail = modelPartData.addChild(
                "tail",
                ModelPartBuilder.create().uv(50, 41).cuboid(10.0f, -11.0f, -3.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f))
                    .uv(20, 47).cuboid(11.0f, -15.0f, -3.0f, 2.0f, 4.0f, 2.0f, Dilation(0.0f))
                    .uv(50, 45).cuboid(10.0f, -17.0f, -3.0f, 2.0f, 2.0f, 2.0f, Dilation(0.0f))
                    .uv(50, 49).cuboid(11.0f, -9.0f, -3.0f, 1.0f, 2.0f, 2.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            val wing = modelPartData.addChild(
                "wing",
                ModelPartBuilder.create().uv(58, 60).cuboid(2.0f, -9.0f, -7.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(58, 60).cuboid(2.0f, -10.0f, -6.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(52, 60).cuboid(2.0f, -11.0f, -8.0f, 1.0f, 2.0f, 2.0f, Dilation(0.0f))
                    .uv(58, 60).cuboid(3.0f, -12.0f, -8.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(60, 56).cuboid(3.0f, -13.0f, -9.0f, 1.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 0.0f, 0.0f)
            )

            val wing2 = modelPartData.addChild(
                "wing2",
                ModelPartBuilder.create().uv(58, 60).cuboid(-3.0f, -9.0f, -3.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(58, 60).cuboid(-3.0f, -10.0f, -2.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(52, 60).cuboid(-3.0f, -11.0f, -4.0f, 1.0f, 2.0f, 2.0f, Dilation(0.0f))
                    .uv(58, 60).cuboid(-4.0f, -12.0f, -4.0f, 1.0f, 1.0f, 1.0f, Dilation(0.0f))
                    .uv(60, 56).cuboid(-4.0f, -13.0f, -5.0f, 1.0f, 3.0f, 1.0f, Dilation(0.0f)),
                ModelTransform.of(0.0f, 24.0f, 0.0f, 0.0f, 3.1416f, 0.0f)
            )
            return TexturedModelData.of(modelData, 64, 64)
        }
    }
}