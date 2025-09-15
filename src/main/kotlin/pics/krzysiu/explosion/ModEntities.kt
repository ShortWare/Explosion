package pics.krzysiu.explosion

import net.minecraft.entity.EntityType
import net.minecraft.entity.SpawnGroup
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.registry.RegistryKey
import net.minecraft.registry.RegistryKeys
import net.minecraft.util.Identifier
import pics.krzysiu.explosion.entities.KrzysNiskiEntity

object ModEntities {

    val KRZYS_NISKI_ENTITY: EntityType<KrzysNiskiEntity> =
        Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of("explosion", "krzys_niski_entity"),
            EntityType.Builder.create<KrzysNiskiEntity>(::KrzysNiskiEntity, SpawnGroup.CREATURE)
                .dimensions(1f, 2.5f)
                .build(
                RegistryKey.of(RegistryKeys.ENTITY_TYPE,Identifier.of(Explosion.MOD_ID,"krzys_niski_entity"))
            )
        )





    fun initialize() {

    }
}