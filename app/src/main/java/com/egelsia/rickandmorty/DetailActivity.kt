package com.egelsia.rickandmorty

import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.egelsia.rickandmorty.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    companion object {
        const val IMAGE = "character_image"
        const val NAME = "character_name"
        const val STATUS = "character_status"
        const val SPECIES = "character_species"
        const val GENDER = "character_gender"
        const val EPISODE = "character_episode"
        const val ORIGIN = "character_origin"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_detail
        )

        val characterName = intent.getStringExtra(NAME)
        val characterImgId = intent.getIntExtra(IMAGE, 1)
        val characterStatus = intent.getStringExtra(STATUS)
        val characterGender = intent.getStringExtra(GENDER)
        val characterOrigin = intent.getStringExtra(ORIGIN)
        val characterEpisodes = intent.getIntExtra(EPISODE, -1)
        val characterSpecies = intent.getStringExtra(SPECIES)

        binding.characterName.text = characterName
        binding.episodesValue.text = characterEpisodes.toString()
        binding.originValue.text = characterOrigin
        binding.speciesValue.text = characterSpecies
        binding.statusValue.text = characterStatus
        binding.genderValue.text = characterGender
        binding.imageView.setImageURI(Uri.parse("android.resource://com.egelsia.rickandmorty/drawable/character_${characterImgId}"))

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}