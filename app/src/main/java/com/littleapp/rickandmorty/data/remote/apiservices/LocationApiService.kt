package com.littleapp.rickandmorty.data.remote.apiservices

import com.littleapp.rickandmorty.models.location.LocationModel
import com.littleapp.rickandmorty.models.RickAndMortyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationApiService {

    @GET("location")
    suspend fun fetchLocation(
        @Query("page") page: Int,
    ): Response<RickAndMortyResponse<LocationModel>>
}