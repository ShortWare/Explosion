package pics.krzysiu.explosion.magic
import net.minecraft.block.Blocks
import net.minecraft.entity.Entity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.world.World



open class Spell(val cost: Int) {
    open fun cast(caster: PlayerEntity, blockPos: BlockPos, world: World, target: Entity? = null): Boolean {
        return true
    }
}



private class Fireball : Spell(cost = 0) {
    override fun cast(caster: PlayerEntity, blockPos: BlockPos, world: World, target: Entity?): Boolean {
        world.setBlockState(blockPos, Blocks.FIRE.defaultState, 3)
        world.setBlockState(blockPos.offset(Direction.EAST,1), Blocks.FIRE.defaultState, 3)
        world.setBlockState(blockPos.offset(Direction.WEST,1), Blocks.FIRE.defaultState, 3)
        world.setBlockState(blockPos.offset(Direction.NORTH,1), Blocks.FIRE.defaultState, 3)
        world.setBlockState(blockPos.offset(Direction.SOUTH,1), Blocks.FIRE.defaultState, 3)

        target?.fireTicks = 20*10

        return true
    }
}


enum class Spells {
    FIREBALL
}

val SpellRegistry: Map<Spells, Spell> = mapOf(
    Pair(Spells.FIREBALL, Fireball())
)
