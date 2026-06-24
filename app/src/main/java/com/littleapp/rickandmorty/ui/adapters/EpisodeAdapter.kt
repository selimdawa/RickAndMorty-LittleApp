package com.littleapp.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.rickandmorty.databinding.ItemEpisodeBinding
import com.littleapp.rickandmorty.models.episode.EpisodeModel

class EpisodeAdapter(private val list: ArrayList<EpisodeModel>) :
    RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EpisodeViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class EpisodeViewHolder(private val binding: ItemEpisodeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: EpisodeModel) {
            binding.tvNameEpisode.text = model.name
            binding.tvEpisode.text = model.episode
            binding.tvDate.text = model.airDate
            binding.tvCreated.text = model.created
        }
    }

    fun addNewItems(episodeModel: List<EpisodeModel>) {
        val startPosition = list.size
        list.addAll(episodeModel)
        notifyItemRangeInserted(startPosition, episodeModel.size)
    }
}