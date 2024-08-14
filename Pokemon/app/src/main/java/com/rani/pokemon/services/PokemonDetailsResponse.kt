package com.rani.pokemon.services

import java.lang.reflect.Type

data class PokemonDetailsResponse(
    val abilities: List<Ability>,
    val base_experience: Int,
    val cries: Cries,
    val forms: List<Form>,
    val game_indices: List<GameIndex>,
    val height: Int,
    val held_items: List<HeldItem>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int, // Changed from Type to String
    val species: Species,
    val sprites: Sprites,
    val types: List<TypeEntry>,  // Changed from Type to String
    val weight: Int
)

data class TypeEntry(   // New data class to match the "types" structure
    val slot: Int,
    val type: TypeDetails
)

data class TypeDetails(
    val name: String,
    val url: String
)

data class Ability(
    val ability: AbilityDetails,
    val is_hidden: Boolean,
    val slot: Int
)

data class AbilityDetails(
    val name: String,
    val url: String
)

data class Cries(
    val latest: String,
    val legacy: String
)

data class Form(
    val name: String,
    val url: String
)

data class GameIndex(
    val game_index: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)

data class Item(
    val name: String,
    val url: String
)

data class VersionDetail(
    val rarity: Int,
    val version: Version
)

data class Move(
    val move: MoveDetails,
    val version_group_details: List<VersionGroupDetail>
)

data class MoveDetails(
    val name: String,
    val url: String
)

data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)

data class MoveLearnMethod(
    val name: String,
    val url: String
)

data class VersionGroup(
    val name: String,
    val url: String
)

data class Species(
    val name: String,
    val url: String
)

data class Sprites(
    val back_default: String,
    val back_female: String?,
    val back_shiny: String,
    val back_shiny_female: String?,
    val front_default: String,
    val front_female: String?,
    val front_shiny: String,
    val front_shiny_female: String?,
    val other: OtherSprites,
    val versions: VersionsSprites
)

data class OtherSprites(
    val dream_world: DreamWorld,
    val home: Home,
    val official_artwork: OfficialArtwork,
    val showdown: Showdown
)

data class DreamWorld(
    val front_default: String,
    val front_female: String?
)

data class Home(
    val front_default: String,
    val front_female: String?,
    val front_shiny: String,
    val front_shiny_female: String?
)

data class OfficialArtwork(
    val front_default: String,
    val front_shiny: String
)

data class Showdown(
    val back_default: String,
    val back_female: String?,
    val back_shiny: String,
    val back_shiny_female: String?,
    val front_default: String,
    val front_female: String?,
    val front_shiny: String,
    val front_shiny_female: String?
)

data class VersionsSprites(
    val generation_i: GenerationISprites,
    val generation_ii: GenerationISprites,
    val generation_iii: GenerationISprites,
    val generation_iv: GenerationISprites,
    val generation_v: GenerationISprites,
    val generation_vi: GenerationISprites,
    val generation_vii: GenerationISprites,
    val generation_viii: GenerationISprites
)

data class GenerationISprites(
    val red_blue: RedBlue,
    val yellow: Yellow
)

data class RedBlue(
    val back_default: String,
    val back_gray: String,
    val back_transparent: String,
    val front_default: String,
    val front_gray: String,
    val front_transparent: String
)

data class Yellow(
    val back_default: String,
    val back_gray: String,
    val back_transparent: String,
    val front_default: String,
    val front_gray: String,
    val front_transparent: String
)

// Define other generations similarly...

