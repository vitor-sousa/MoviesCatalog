package com.vitorsousa.moviescatalog.ui.movieDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
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

        initObservers()
        return binding.root
    }


    private fun initObservers() {
        viewModel.movieLiveData.observe(viewLifecycleOwner) { movie ->
            movie?.title?.let { changeActionBarTitle(it) }
            movie?.vote_average?.let {
                binding.ratingBar.rating = it.toFloat()
                binding.ratingText.text = "${String.format("%.1f", it)}/10"
            }
        }
    }



    private fun changeActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

}