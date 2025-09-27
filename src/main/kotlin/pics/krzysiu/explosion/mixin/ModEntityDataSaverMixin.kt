package pics.krzysiu.explosion.mixin

import net.minecraft.entity.Entity
import net.minecraft.nbt.NbtCompound
import org.spongepowered.asm.mixin.Mixin
import pics.krzysiu.explosion.IEntityDataSaver

@Mixin(Entity::class)
class ModEntityDataSaverMixin: IEntityDataSaver {
    var _persistentData: NbtCompound? = null

    override fun getPersistentData(): NbtCompound {
        if (_persistentData == null) {
            _persistentData = NbtCompound()
        }

        return _persistentData!!
    }
}