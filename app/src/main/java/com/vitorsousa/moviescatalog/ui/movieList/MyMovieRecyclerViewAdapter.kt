package com.vitorsousa.moviescatalog.ui.movieList

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.databinding.FragmentMoviesItemBinding

interface MovieItemListener {
    fun onItemSelected(position: Int)
}

interface ShareMovieListener {
    fun shareItemClicked(movie: Movie)
}

class MyMovieRecyclerViewAdapter(
    private val listener: MovieItemListener,
    private val shareMovieListener: ShareMovieListener
) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    private var values: List<Movie> = ArrayList()

    fun updateList(movies: List<Movie>) {
        values = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentMoviesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.bindItem(item)
        holder.view.setOnClickListener {
            listener.onItemSelected(position)
        }
        holder.shareButton.setOnClickListener {
            shareMovieListener.shareItemClicked(item)
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentMoviesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val view: View = binding.root
        val shareButton = binding.shareButton

        fun bindItem(item: Movie) {
            binding.movie = item
            binding.executePendingBindings()
        }
    }

}