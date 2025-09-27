package pics.krzysiu.explosion.entities

import net.minecraft.entity.Entity
import net.minecraft.entity.EntityType
import net.minecraft.entity.data.DataTracker
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.entity.projectile.PersistentProjectileEntity
import net.minecraft.item.ItemStack
import net.minecraft.sound.SoundEvent
import net.minecraft.util.hit.HitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World
import pics.krzysiu.explosion.magic.SpellRegistry
import pics.krzysiu.explosion.magic.Spells
import kotlin.math.floor

class MagicProjectileEntity(
    entityType: EntityType<MagicProjectileEntity>,
    world: World
) : PersistentProjectileEntity(entityType, world) {

    var spell: Spells? = null
    var caster: PlayerEntity? = null

    override fun initDataTracker(builder: DataTracker.Builder) {
        super.initDataTracker(builder)
    }

    override fun getDefaultItemStack(): ItemStack? {
        return ItemStack.EMPTY
    }

    override fun playSound(sound: SoundEvent?, volume: Float, pitch: Float) {

    }

    override fun onCollision(hitResult: HitResult) {
        caster ?: return
        spell ?: return

        if (hitResult.type == HitResult.Type.ENTITY) {
            val entityHit = (hitResult as? net.minecraft.util.hit.EntityHitResult)?.entity
            if (entityHit == caster) return
        }

        val blockPos = BlockPos(floor(pos.x).toInt(), floor(pos.y).toInt(), floor(pos.z).toInt())
        val target: Entity? = (hitResult as? net.minecraft.util.hit.EntityHitResult)?.entity

        SpellRegistry[spell]?.cast(caster!!, blockPos, world, target = target)

        remove(RemovalReason.DISCARDED)
    }
}