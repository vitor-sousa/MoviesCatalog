package com.vitorsousa.moviescatalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.vitorsousa.moviescatalog.databinding.FragmentMoviesListBinding
import com.vitorsousa.moviescatalog.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class MoviesFragment : Fragment(), MovieItemListener {

    private var columnCount = 1
    lateinit var binding: FragmentMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesListBinding.inflate(layoutInflater)
        val view = binding.root

        with(view) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                else -> GridLayoutManager(context, columnCount)
            }
            adapter = MyMovieRecyclerViewAdapter(PlaceholderContent.ITEMS, this@MoviesFragment)
        }

        return view
    }

    override fun onItemSelected(position: Int) {
        findNavController().navigate(R.id.action_moviesFragment_to_movieDetailsFragment)
    }



    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            MoviesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}