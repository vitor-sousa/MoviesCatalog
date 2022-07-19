package com.vitorsousa.moviescatalog

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.vitorsousa.moviescatalog.placeholder.PlaceholderContent.PlaceholderItem
import com.vitorsousa.moviescatalog.databinding.FragmentMoviesItemBinding

interface MovieItemListener {
    fun onItemSelected(position: Int)
}

class MyMovieRecyclerViewAdapter(
    private val listener: MovieItemListener
) : RecyclerView.Adapter<MyMovieRecyclerViewAdapter.ViewHolder>() {

    private val values: MutableList<PlaceholderItem> = ArrayList()

    fun updateList(hqList: List<PlaceholderItem>) {
        values.clear()
        values.addAll(hqList)
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
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentMoviesItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val view: View = binding.root

        fun bindItem(item: PlaceholderItem) {
            binding.movie = item
            binding.executePendingBindings()
        }
    }

}