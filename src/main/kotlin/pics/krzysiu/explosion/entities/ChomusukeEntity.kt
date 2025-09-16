package pics.krzysiu.explosion.entities

import net.minecraft.entity.EntityType
import net.minecraft.entity.attribute.DefaultAttributeContainer
import net.minecraft.entity.attribute.EntityAttributes
import net.minecraft.entity.mob.MobEntity
import net.minecraft.entity.passive.AnimalEntity
import net.minecraft.entity.passive.PassiveEntity
import net.minecraft.item.ItemStack
import net.minecraft.server.world.ServerWorld
import net.minecraft.world.World

class ChomusukeEntity(
    entityType: EntityType<ChomusukeEntity>,
    world: World
) : AnimalEntity(entityType, world) {

    override fun isBreedingItem(stack: ItemStack): Boolean {
        return false
    }

    override fun createChild(world: ServerWorld, entity: PassiveEntity): PassiveEntity? {
        return null
    }

    companion object {
        fun createAttributes(): DefaultAttributeContainer.Builder {
            return createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 200.0)
                .add(EntityAttributes.MOVEMENT_SPEED, 1.0)
        }
    }
}