package com.littleapp.rickandmorty.ui.fragments.characters

import com.littleapp.rickandmorty.base.BaseViewModel
import com.littleapp.rickandmorty.data.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val repository: CharacterRepository) :
    BaseViewModel() {

    fun fetchCharacters(page: Int) = repository.fetchCharacter(page)
}