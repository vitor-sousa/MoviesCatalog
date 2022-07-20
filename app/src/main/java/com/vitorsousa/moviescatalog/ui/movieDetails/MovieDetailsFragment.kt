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
import com.vitorsousa.moviescatalog.utils.ImageUtils
import dagger.hilt.android.AndroidEntryPoint
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

@AndroidEntryPoint
class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding
    private val viewModel: MovieViewModel by activityViewModels()
    private val listCarouselItems = mutableListOf<CarouselItem>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentMovieDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.carousel.registerLifecycle(this)

        initObservers()
        setupCarousel()
        return binding.root
    }


    private fun initObservers() {
        viewModel.movieLiveData.observe(viewLifecycleOwner) { movie ->
            movie.title?.let { changeActionBarTitle(it) }
            movie.vote_average?.let {
                binding.ratingBar.rating = it.toFloat()
                binding.ratingText.text = "${it}/10"
            }
        }
    }


    private fun setupCarousel() {
        viewModel.movieLiveData.value?.backdrop_path?.let {
            listCarouselItems.add(
                CarouselItem(
                    imageUrl = "${ImageUtils.baseImageUrl}$it"
                )
            )
        }.also {
            binding.carousel.setData(listCarouselItems)
        }
    }


    private fun changeActionBarTitle(title: String) {
        (activity as AppCompatActivity).supportActionBar?.title = title
    }

}