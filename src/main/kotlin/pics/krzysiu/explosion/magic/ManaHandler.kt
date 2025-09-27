package pics.krzysiu.explosion.magic

import net.minecraft.nbt.NbtCompound
import pics.krzysiu.explosion.Explosion
import pics.krzysiu.explosion.IEntityDataSaver

object ManaHandler {
    val manaKey = "${Explosion.MOD_ID}:mana"

    fun alterMana(player: IEntityDataSaver, ammount: Int): Int {
        val nbt: NbtCompound = player.getPersistentData()
        var mana: Int = nbt.getInt(manaKey).orElse(100)

        mana = Math.clamp(mana.toLong() + ammount, 0, 100)

        nbt.putInt(manaKey, mana)

        return mana
    }

    fun getMana(player: IEntityDataSaver): Int {
        val nbt: NbtCompound = player.getPersistentData()
        val mana: Int = nbt.getInt(manaKey).orElse(0)

        return mana;
    }
}