import java.util.*

// enum classes
enum class EntityType {
    HELP, EASY, MEDIUM, HARD;

    fun getFormattedName() = name.lowercase()
        .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
}

object EntityFactory {
    fun create(type: EntityType): Entity {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EntityType.EASY -> type.name // or "Easy"
            EntityType.MEDIUM -> type.getFormattedName()
            EntityType.HARD -> type.name
            EntityType.HELP -> type.getFormattedName()
        }
        return when(type) {
            EntityType.EASY -> Entity.Easy(id, name)
            EntityType.MEDIUM -> Entity.Medium(id, name)
            EntityType.HARD -> Entity.Hard(id, name, 2f)
            EntityType.HELP -> Entity.Help
        }
    }
}

sealed class Entity () {
    object Help :Entity() {
        val name = "Help"
    } // object class
    data class Easy (val id: String, val name: String): Entity()
    data class Medium (val id: String, val name: String): Entity()
    data class Hard (val id: String, val name: String, val multiplier: Float): Entity()
    // they all extend from Entity but have different property
    // system performs smart casting, different from enum class
    // we can create different types of classes as well eg not data class
}

fun Entity.Medium.printInfo(){
    println ("Medium class: $id")
} // extension function

val Entity.Medium.info: String
    get() = "Some info"
// extension property

fun main() {
    Entity.Medium("id", "name").printInfo()
    var entity1 = Entity.Easy("id", "name")
    var entity2 = EntityFactory.create(EntityType.MEDIUM)
    if (entity2 is Entity.Medium) {
        entity2.printInfo()
        entity2.info
    }
}