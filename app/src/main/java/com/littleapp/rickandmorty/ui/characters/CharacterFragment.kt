package com.littleapp.rickandmorty.ui.characters

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.littleapp.rickandmorty.R
import com.littleapp.rickandmorty.ui.base.BaseFragment
import com.littleapp.rickandmorty.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    FragmentCharacterBinding::inflate,
) {
    override val viewModel: CharacterViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private val adapter = CharacterAdapter()
    private var count = 1
    private var isLoading = false

    override fun initialize() {
        binding.rvCharacter.adapter = adapter
        binding.rvCharacter.onScrollEnd(isLoading) {
            viewModel.fetchCharacters(++count).collectResource { adapter.submitList(it) }
        }
    }

    override fun setupSubscribe() {
        viewModel.fetchCharacters(count).collectResource(
            onLoading = { isLoading = it },
            onError = { Timber.e(it) }
        ) { adapter.submitList(it) }
    }
}