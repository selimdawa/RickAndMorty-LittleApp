package com.littleapp.rickandmorty.data.remote.apiservices

import com.littleapp.rickandmorty.models.RickAndMortyResponse
import com.littleapp.rickandmorty.models.character.CharacterModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterApiService {

    @GET("character")
    suspend fun fetchCharacter(
        @Query("page") page: Int,
    ): Response<RickAndMortyResponse<CharacterModel>>
}