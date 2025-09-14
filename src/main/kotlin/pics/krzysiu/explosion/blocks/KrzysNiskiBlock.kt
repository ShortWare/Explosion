package pics.krzysiu.explosion.blocks

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.sound.BlockSoundGroup
import pics.krzysiu.explosion.ModBlocks

class KrzysNiskiBlock(settings: Settings) : Block(settings) {
    companion object {
        val INSTANCE: Block = ModBlocks.register(
            "krzys_block",
            ::KrzysNiskiBlock,
            AbstractBlock.Settings.create()
                .sounds(BlockSoundGroup.STONE),
            shouldRegisterItem = true
        )
    }
}
