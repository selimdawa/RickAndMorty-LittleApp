package com.littleapp.rickandmorty.ui.locations

import com.littleapp.rickandmorty.ui.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: MainRepository) :
    BaseViewModel() {

    fun fetchLocations(page: Int) = repository.fetchLocations(page)
}