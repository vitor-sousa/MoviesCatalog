package com.vitorsousa.moviescatalog.ui.movieList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vitorsousa.moviescatalog.databinding.FragmentMoviesListBinding
import com.vitorsousa.moviescatalog.ui.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A fragment representing a list of Movies.
 */
@AndroidEntryPoint
class MoviesFragment : Fragment(), MovieItemListener {

    private val viewModel: MovieViewModel by activityViewModels()
    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var adapterPopularMovies: MyMovieRecyclerViewAdapter
    private lateinit var adapterTopRated: MyMovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        adapterPopularMovies = MyMovieRecyclerViewAdapter(this)
        adapterTopRated = MyMovieRecyclerViewAdapter(this)

        binding.popularMoviesList.apply {
            this.adapter = this@MoviesFragment.adapterPopularMovies
            this.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

        binding.topRatedMoviesList.apply {
            this.adapter = this@MoviesFragment.adapterTopRated
            this.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

        initObservers()
        return binding.root
    }

    private fun initObservers() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            adapterPopularMovies.updateList(it)
        }
        viewModel.movieTopRatedListLiveData.observe(viewLifecycleOwner) {
            adapterTopRated.updateList(it)
        }
        viewModel.navigationToDetailsLive.observe(viewLifecycleOwner) {
            val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onItemSelected(id: Int) {
        viewModel.onHQSelected(id)
    }


}