package com.vitorsousa.moviescatalog.ui.movieDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.vitorsousa.moviescatalog.ui.MovieViewModel
import com.vitorsousa.moviescatalog.databinding.FragmentMovieDetailsBinding
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
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        initObservers()
        return binding.root
    }


    private fun initObservers() {
        viewModel.movieLiveData.observe(viewLifecycleOwner) { movie ->
            movie.title?.let { changeActionBarTitle(it) }
        }
    }

    private fun changeActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

}