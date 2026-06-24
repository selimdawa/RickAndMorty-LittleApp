package com.littleapp.rickandmorty.ui.fragments.characters

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.rickandmorty.databinding.FragmentCharacterBinding
import com.littleapp.rickandmorty.base.BaseFragment
import com.littleapp.rickandmorty.common.Resource
import com.littleapp.rickandmorty.ui.adapters.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding, CharacterViewModel>(
    FragmentCharacterBinding::inflate
) {

    override val viewModel: CharacterViewModel by viewModels()
    private var adapter: CharacterAdapter? = null
    private var count = 1
    private var isLoading = false

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToCharacter()
    }

    private fun setupRecyclerView() {
        adapter = CharacterAdapter(requireContext(), arrayListOf())
        binding.rvCharacter.adapter = adapter
        binding.rvCharacter.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    Toast.makeText(requireContext(), "Loading next page...", Toast.LENGTH_SHORT).show()
                    ++count
                    subscribeToCharacter()
                }
            }
        })
    }

    private fun subscribeToCharacter() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchCharacters(page = count).collectLatest { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            isLoading = true
                        }
                        is Resource.Success -> {
                            isLoading = false
                            resource.data?.results?.let { items ->
                                adapter?.addNewItems(items)
                            }
                        }
                        is Resource.Error -> {
                            isLoading = false
                            Timber.e(resource.message.toString())
                        }
                    }
                }
            }
        }
    }
}