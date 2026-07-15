package com.littleapp.rickandmorty.ui.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import com.littleapp.rickandmorty.ui.base.BaseAdapter
import com.littleapp.rickandmorty.databinding.ItemLocationBinding
import com.littleapp.rickandmorty.data.models.LocationModel

class LocationAdapter : BaseAdapter<LocationModel, Int, ItemLocationBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, parent: ViewGroup) =
        ItemLocationBinding.inflate(inflater, parent, false)

    override fun bind(binding: ItemLocationBinding, item: LocationModel) {
        binding.tvLocation.text = item.name
        binding.tvUrl.text = item.url
    }
}