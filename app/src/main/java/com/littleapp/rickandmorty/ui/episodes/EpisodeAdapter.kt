package com.littleapp.rickandmorty.ui.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import com.littleapp.rickandmorty.ui.base.BaseAdapter
import com.littleapp.rickandmorty.databinding.ItemEpisodeBinding
import com.littleapp.rickandmorty.data.models.EpisodeModel

class EpisodeAdapter : BaseAdapter<EpisodeModel, Int, ItemEpisodeBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemEpisodeBinding.inflate(inflater, parent, false)

    override fun bind(binding: ItemEpisodeBinding, item: EpisodeModel) {
        binding.tvNameEpisode.text = item.name
        binding.tvEpisode.text = item.episode
        binding.tvDate.text = item.airDate
        binding.tvCreated.text = item.created
    }
}