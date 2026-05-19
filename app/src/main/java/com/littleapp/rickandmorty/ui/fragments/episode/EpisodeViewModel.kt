package com.littleapp.rickandmorty.ui.fragments.episode

import com.littleapp.rickandmorty.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.EpisodeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(private val repository: EpisodeRepository) :
    BaseViewModel() {

    fun fetchEpisode(page: Int) = repository.fetchEpisode(page)
}