data class Pokemon(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Pokemon>
)

data class PokemonDetail(
    val id: Int,
    val name: String,
    val abilities: List<Ability>,
    val sprites: Sprites,
    // Add other fields as needed
)

data class Ability(val ability: AbilityInfo)
data class AbilityInfo(val name: String)
data class Sprites(val front_default: String)
