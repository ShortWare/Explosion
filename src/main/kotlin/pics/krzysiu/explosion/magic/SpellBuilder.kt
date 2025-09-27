package pics.krzysiu.explosion.magic

import net.minecraft.entity.Entity
import net.minecraft.entity.SpawnReason
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.server.world.ServerWorld
import net.minecraft.util.math.BlockPos
import pics.krzysiu.explosion.ModEntities

class SpellBuilder {

    companion object {

        fun castSpell(spell: Spells, projectile: Boolean = false, caster: PlayerEntity, serverWorld: ServerWorld, target: Entity? = null) {

            if (projectile) {
                val projectile = ModEntities.MAGIC_PROJECTILE_ENTITY.spawn(
                    serverWorld,
                    null,
                    BlockPos(caster.eyePos.x.toInt(), caster.eyePos.y.toInt(), caster.eyePos.z.toInt()),
                    SpawnReason.COMMAND,
                    true,
                    false
                )
                projectile ?: return

                projectile.spell = spell
                projectile.caster = caster

                projectile.updatePosition(caster.eyePos.x, caster.eyePos.y, caster.eyePos.z)

                val speed = 2.0
                val lookVec = caster.rotationVecClient.multiply(speed)
                projectile.velocity = lookVec
            } else {
                SpellRegistry[spell]?.cast(caster, caster.blockPos, serverWorld, target = target)
            }
        }
    }
}