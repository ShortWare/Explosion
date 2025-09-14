package pics.krzysiu.explosion.blocks

import com.mojang.serialization.MapCodec
import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.HorizontalFacingBlock
import net.minecraft.item.ItemPlacementContext
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.state.StateManager
import net.minecraft.state.property.Properties
import net.minecraft.util.math.Direction
import pics.krzysiu.explosion.ModBlocks

class KrzysNiskiBlock(settings: Settings) : HorizontalFacingBlock(settings) {
    override fun getCodec(): MapCodec<out KrzysNiskiBlock> = CODEC
    override fun appendProperties(builder: StateManager.Builder<Block?, BlockState?>?) {
        builder?.add(Properties.HORIZONTAL_FACING)
    }

    override fun getPlacementState(ctx: ItemPlacementContext?): BlockState? {
        return super.getPlacementState(ctx)!!
            .with(Properties.HORIZONTAL_FACING, ctx?.horizontalPlayerFacing?.opposite)
    }
    init {
        defaultState = defaultState.with(Properties.HORIZONTAL_FACING, Direction.NORTH)
    }
    companion object {
        val CODEC: MapCodec<KrzysNiskiBlock> = createCodec(::KrzysNiskiBlock)
        val INSTANCE: Block = ModBlocks.register(
            "krzys_block",
            ::KrzysNiskiBlock,
            AbstractBlock.Settings.create()
                .sounds(BlockSoundGroup.STONE),
            shouldRegisterItem = true
        )
    }
}
