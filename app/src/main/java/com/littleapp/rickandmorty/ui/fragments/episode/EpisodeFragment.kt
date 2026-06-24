package com.littleapp.rickandmorty.ui.fragments.episode

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.rickandmorty.databinding.FragmentEpisodeBinding
import com.littleapp.rickandmorty.base.BaseFragment
import com.littleapp.rickandmorty.common.Resource
import com.littleapp.rickandmorty.ui.adapters.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding, EpisodeViewModel>(
    FragmentEpisodeBinding::inflate
) {

    override val viewModel: EpisodeViewModel by viewModels()
    private val adapter = EpisodeAdapter(arrayListOf())
    private var count = 1
    private var isLoading = false

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribe() {
        subscribeToEpisode()
    }

    private fun setupRecyclerView() {
        binding.rvEpisode.adapter = adapter
        binding.rvEpisode.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1) && !isLoading) {
                    Toast.makeText(requireContext(), "Loading next page...", Toast.LENGTH_SHORT).show()
                    ++count
                    subscribeToEpisode()
                }
            }
        })
    }

    private fun subscribeToEpisode() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.fetchEpisode(page = count).collectLatest { resource ->
                    when (resource) {
                        is Resource.Loading -> {
                            isLoading = true
                        }
                        is Resource.Success -> {
                            isLoading = false
                            resource.data?.results?.let { items ->
                                adapter.addNewItems(items)
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