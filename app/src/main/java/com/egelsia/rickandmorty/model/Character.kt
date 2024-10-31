package com.egelsia.rickandmorty.model

data class Character(
    val image: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: String,
    val episode: Int
)