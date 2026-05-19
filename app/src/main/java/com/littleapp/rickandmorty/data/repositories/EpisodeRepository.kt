package com.littleapp.rickandmorty.data.repositories

import com.littleapp.rickandmorty.base.BaseRepository
import com.littleapp.rickandmorty.data.remote.apiservices.EpisodeApiService
import javax.inject.Inject

class EpisodeRepository @Inject constructor(private val service: EpisodeApiService) :
    BaseRepository() {

    fun fetchEpisode(page: Int) = doRequest {
        service.fetchEpisode(page)
    }
}