package com.littleapp.rickandmorty.ui.fragments.location

import com.littleapp.rickandmorty.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(private val repository: LocationRepository) :
    BaseViewModel() {

    fun fetchLocation(page: Int) = repository.fetchLocation(page)
}