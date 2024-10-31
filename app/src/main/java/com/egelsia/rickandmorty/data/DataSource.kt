package com.egelsia.rickandmorty.data

import android.content.Context
import com.egelsia.rickandmorty.R
import com.egelsia.rickandmorty.model.Character

class DataSource(val context: Context) {

    fun getCharacterIdsList(): Array<String> {
        return context.resources.getStringArray(R.array.character_ids)
    }

    fun getCharactersNamesList(): Array<String> {
        return context.resources.getStringArray(R.array.character_names)
    }

    fun getCharacterOriginsList(): Array<String> {
        return context.resources.getStringArray(R.array.character_origins)
    }

    fun getCharacterSpeciesList(): Array<String> {
        return context.resources.getStringArray(R.array.character_species)
    }

    fun getCharacterEpisodesList(): Array<String> {
        return context.resources.getStringArray(R.array.character_episodes)
    }

    fun getCharacterStatusesList(): Array<String> {
        return context.resources.getStringArray(R.array.character_statuses)
    }

    fun getCharacterGendersList(): Array<String> {
        return context.resources.getStringArray(R.array.character_genders)
    }

    fun loadCharacters(): List<Character> {
        val idsList = getCharacterIdsList()
        val namesList = getCharactersNamesList()
        val originsList = getCharacterOriginsList()
        val speciesList = getCharacterSpeciesList()
        val episodesList = getCharacterEpisodesList()
        val statusesList = getCharacterStatusesList()
        val gendersList = getCharacterGendersList()

        val characters = mutableListOf<Character>()
        for (i in idsList.indices) {
            characters.add(
                Character(
                    image = idsList[i].toInt() ?: 1,
                    name = namesList[i] ?: "Problem occurred",
                    status = statusesList[i] ?: "Status",
                    species = speciesList[i] ?: "Species",
                    gender = gendersList[i] ?: "Gender",
                    origin = originsList[i] ?: "Origin",
                    episode = episodesList[i].toInt() ?: -1
                )
            )
        }
        return characters
    }
}