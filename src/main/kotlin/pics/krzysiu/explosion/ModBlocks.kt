package pics.krzysiu.explosion

import net.minecraft.block.AbstractBlock
import net.minecraft.block.Block
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.blocks.KrzysNiskiBlock


object ModBlocks {
    fun initialize() {
        KrzysNiskiBlock.INSTANCE
    }

    fun register(
        name: String,
        blockFactory: (AbstractBlock.Settings) -> Block,
        settings: AbstractBlock.Settings,
        shouldRegisterItem: Boolean = true
    ): Block {
        val blockKey = keyOfBlock(name)
        val block = blockFactory(settings.registryKey(blockKey))

        if (shouldRegisterItem) {
            val itemKey = keyOfItem(name)
            val blockItem = BlockItem(block, Item.Settings().registryKey(itemKey))
            Registry.register(Registries.ITEM, itemKey, blockItem)
        }

        return Registry.register(Registries.BLOCK, blockKey, block)
    }

    private fun keyOfBlock(name: String): RegistryKey<Block> {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Explosion.MOD_ID, name))
    }

    private fun keyOfItem(name: String): RegistryKey<Item> {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Explosion.MOD_ID, name))
    }
}
