package com.littleapp.rickandmorty.ui.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.littleapp.rickandmorty.R
import com.littleapp.rickandmorty.ui.base.BaseAdapter
import com.littleapp.rickandmorty.databinding.ItemCharacterBinding
import com.littleapp.rickandmorty.data.models.CharacterModel
import com.littleapp.rickandmorty.utils.DATA
import com.littleapp.rickandmorty.utils.loadImage

class CharacterAdapter : BaseAdapter<CharacterModel, Int, ItemCharacterBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemCharacterBinding.inflate(inflater, parent, false)

    override fun bind(binding: ItemCharacterBinding, item: CharacterModel) {
        binding.image.loadImage(item.image, blurTarget = binding.imageBlur)
        binding.tvNameCharacter.text = item.name
        binding.tvStatus.text = item.status
        binding.cvIndicator.setImageResource(if (item.status == DATA.ALIVE) R.color.green else R.color.red)
        binding.tvSpecies.text = item.species
        binding.tvType.text = if (item.type.isEmpty()) DATA.UNKNOWN else item.type
        binding.tvFirstSeen.text = item.gender
    }
}