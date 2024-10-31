package com.egelsia.rickandmorty.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.egelsia.rickandmorty.DetailActivity
import com.egelsia.rickandmorty.R
import com.egelsia.rickandmorty.model.Character

class CharacterAdapter(private val data: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {
    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private lateinit var character: Character
        val imgView: ImageView = view.findViewById(R.id.characterImageView)
        val nameView: TextView = view.findViewById(R.id.nameTextView)
        val species: TextView = view.findViewById(R.id.detailTextView)
        private val cardView: CardView = view.findViewById(R.id.characterCard)

        init {
            cardView.setOnClickListener {
                val context = itemView.context
                val characterIntent = Intent(context, DetailActivity::class.java)
                characterIntent.putExtra(DetailActivity.IMAGE, character.image)
                characterIntent.putExtra(DetailActivity.NAME, character.name)
                characterIntent.putExtra(DetailActivity.STATUS, character.status)
                characterIntent.putExtra(DetailActivity.SPECIES, character.species)
                characterIntent.putExtra(DetailActivity.GENDER, character.gender)
                characterIntent.putExtra(DetailActivity.EPISODE, character.episode)
                characterIntent.putExtra(DetailActivity.ORIGIN, character.origin)
                context.startActivity(characterIntent)
            }
        }
        fun dataBinder(character: Character) {
            this.character = character
            // I know it is not a good design, but if I don't do it like that I am forced to use
            // getIdentifier, which is a discouraged method. I found this usage from here:
            // https://stackoverflow.com/questions/75227494/android-getresources-getidentifier-replacement
            imgView.setImageURI(Uri.parse("android.resource://com.egelsia.rickandmorty/drawable/character_${character.image}"))
            nameView.text = character.name
            species.text = "${character.species.uppercase()} • ${character.status.uppercase()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_row, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = data[position]
        holder.dataBinder(character)
    }
}