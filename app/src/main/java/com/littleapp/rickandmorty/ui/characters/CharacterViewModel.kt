package com.littleapp.rickandmorty.ui.characters

import com.littleapp.rickandmorty.ui.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: MainRepository) :
    BaseViewModel() {

    fun fetchCharacters(page: Int) = repository.fetchCharacters(page)
}