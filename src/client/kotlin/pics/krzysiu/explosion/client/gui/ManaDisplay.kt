package pics.krzysiu.explosion.client.gui

import net.minecraft.client.gui.DrawContext
import net.minecraft.client.render.RenderTickCounter
import kotlin.math.roundToInt


object ManaDisplay {
    var mana: Int = 0
    var manaLerped: Int = 0
    val lerpRatio: Float = 0.25f

    fun render(context: DrawContext, tickCounter: RenderTickCounter?) {
        val manaColor = 0xFF0000FF.toInt()
        val backgroundColor = 0xFF001F30.toInt()

        manaLerped += ((mana - manaLerped) * lerpRatio).roundToInt()

        context.fill(10, 10, 20, 110, backgroundColor)
        context.fill(10, 110-manaLerped, 20, 110, manaColor)
    }
}