package com.littleapp.rickandmorty.data.repositories

import com.littleapp.rickandmorty.base.BaseRepository
import com.littleapp.rickandmorty.data.remote.apiservices.LocationApiService
import javax.inject.Inject

class LocationRepository @Inject constructor(private val service: LocationApiService) :
    BaseRepository() {

    fun fetchLocation(page: Int) = doRequest {
        service.fetchLocation(page)
    }
}