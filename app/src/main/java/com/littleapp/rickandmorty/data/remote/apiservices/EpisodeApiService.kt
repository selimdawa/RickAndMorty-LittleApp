package com.littleapp.rickandmorty.data.remote.apiservices

import com.littleapp.rickandmorty.models.RickAndMortyResponse
import com.littleapp.rickandmorty.models.episode.EpisodeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("episode")
    suspend fun fetchEpisode(
        @Query("page") page: Int,
    ): Response<RickAndMortyResponse<EpisodeModel>>
}