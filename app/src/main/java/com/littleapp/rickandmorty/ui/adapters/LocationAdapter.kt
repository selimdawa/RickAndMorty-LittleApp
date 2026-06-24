package com.littleapp.rickandmorty.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.rickandmorty.models.location.LocationModel
import com.littleapp.rickandmorty.databinding.ItemLocationBinding

class LocationAdapter(private val list: ArrayList<LocationModel>) :
    RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LocationViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class LocationViewHolder(private val binding: ItemLocationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: LocationModel) {
            binding.tvLocation.text = model.name
            binding.tvUrl.text = model.url
        }
    }

    fun addNewItems(locationModel: List<LocationModel>) {
        val startPosition = list.size
        list.addAll(locationModel)
        notifyItemRangeInserted(startPosition, locationModel.size)
    }
}