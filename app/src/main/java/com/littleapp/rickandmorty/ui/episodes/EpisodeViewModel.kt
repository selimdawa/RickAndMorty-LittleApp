package com.littleapp.rickandmorty.ui.episodes

import com.littleapp.rickandmorty.ui.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(private val repository: MainRepository) :
    BaseViewModel() {

    fun fetchEpisodes(page: Int) = repository.fetchEpisodes(page)
}