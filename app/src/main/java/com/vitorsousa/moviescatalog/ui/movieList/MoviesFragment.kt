package com.vitorsousa.moviescatalog.ui.movieList

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.vitorsousa.moviescatalog.ui.MovieViewModel
import com.vitorsousa.moviescatalog.databinding.FragmentMoviesListBinding

/**
 * A fragment representing a list of Movies.
 */
class MoviesFragment : Fragment(), MovieItemListener {

    private val viewModel: MovieViewModel by activityViewModels()
    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var adapter: MyMovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        val view = binding.root as RecyclerView
        adapter = MyMovieRecyclerViewAdapter(this)

        view.apply {
            this.adapter = this@MoviesFragment.adapter
            this.layoutManager = LinearLayoutManager(context)
        }



        initObservers()
        return view
    }

    private fun initObservers() {
        viewModel.movieListLiveData.observe(viewLifecycleOwner) {
            adapter.updateList(it)
        }
        viewModel.navigationToDetailsLive.observe(viewLifecycleOwner) {
            val action = MoviesFragmentDirections.actionMoviesFragmentToMovieDetailsFragment()
            findNavController().navigate(action)
        }
    }

    override fun onItemSelected(position: Int) {
        viewModel.onHQSelected(position)
    }

}