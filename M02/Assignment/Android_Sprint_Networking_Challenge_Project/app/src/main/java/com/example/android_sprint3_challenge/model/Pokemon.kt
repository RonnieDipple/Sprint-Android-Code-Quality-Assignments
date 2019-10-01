package com.example.android_sprint3_challenge.model


data class Pokemon(
    val name: String,
    val sprites: Sprite,
    val id: Long,
    val abilities: ArrayList<AbilityList>,
    val types: ArrayList<TypeList>,
    val move: ArrayList<MovesList>
    )


data class Type(val name: String)

data class TypeList (val type: Type)

data class Ability(val name: String)

data class AbilityList(val ability: Ability)

data class Move(val name: String)

data class MovesList(val move: Move)

data class Sprite (val front_default: String )

data class Id (val id: Long)

