package com.vitorsousa.moviescatalog.ui.movieDetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.vitorsousa.moviescatalog.databinding.FragmentMovieDetailsBinding
import com.vitorsousa.moviescatalog.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MovieViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.carousel.registerLifecycle(this)

        binding.backFloatingButton.setOnClickListener { findNavController().popBackStack() }

        initObservers()
        return binding.root
    }


    private fun initObservers() {
        viewModel.movieLiveData.observe(viewLifecycleOwner) { movie ->
            movie?.genres?.let { genreList ->
                genreList.forEach {
                    it.name?.let { name -> binding.chipGroupGenres.addChip(requireContext(), name) }
                }
            }
        }
    }


    private fun ChipGroup.addChip(context: Context, label: String){
        Chip(context).apply {
            id = View.generateViewId()
            text = label
            isClickable = false
            isCheckable = true
            isChecked = true
            isCheckedIconVisible = false
            isFocusable = false
            addView(this)
        }
    }

}