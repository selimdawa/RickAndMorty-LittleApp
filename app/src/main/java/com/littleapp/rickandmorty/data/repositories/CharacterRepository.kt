package com.littleapp.rickandmorty.data.repositories

import com.littleapp.rickandmorty.base.BaseRepository
import com.littleapp.rickandmorty.data.remote.apiservices.CharacterApiService
import javax.inject.Inject

class CharacterRepository @Inject constructor(val service: CharacterApiService) :
    BaseRepository() {

    fun fetchCharacter(page: Int) = doRequest {
        service.fetchCharacter(page)
    }
}