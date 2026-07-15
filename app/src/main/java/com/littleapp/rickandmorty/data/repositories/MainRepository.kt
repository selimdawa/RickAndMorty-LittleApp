package com.littleapp.rickandmorty.data.repositories

import com.littleapp.rickandmorty.data.base.BaseRepository
import com.littleapp.rickandmorty.data.local.AppDao
import com.littleapp.rickandmorty.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val api: ApiService,
    private val dao: AppDao
) : BaseRepository() {

    fun fetchCharacters(page: Int) = doRequestWithCache(
        local = { dao.getAllCharacters() },
        remote = { api.fetchCharacters(page) },
        save = { dao.insertAllCharacters(it.results) }
    )

    fun fetchEpisodes(page: Int) = doRequestWithCache(
        local = { dao.getAllEpisodes() },
        remote = { api.fetchEpisodes(page) },
        save = { dao.insertAllEpisodes(it.results) }
    )

    fun fetchLocations(page: Int) = doRequestWithCache(
        local = { dao.getAllLocations() },
        remote = { api.fetchLocations(page) },
        save = { dao.insertAllLocations(it.results) }
    )
}