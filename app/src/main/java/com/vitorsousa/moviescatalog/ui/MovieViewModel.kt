package com.vitorsousa.moviescatalog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorsousa.moviescatalog.data.DataState
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.placeholder.PlaceholderContent
import com.vitorsousa.moviescatalog.utils.SingleLiveData

class MovieViewModel: ViewModel() {

    val movieLiveData: LiveData<Movie>
        get() = _movieLiveData
    private val _movieLiveData = MutableLiveData<Movie>()

    val movieListLiveData: LiveData<MutableList<PlaceholderContent.PlaceholderItem>>
        get() = _movieListLiveData
    private val _movieListLiveData = MutableLiveData<MutableList<PlaceholderContent.PlaceholderItem>>()

    val navigationToDetailsLive: LiveData<Unit>
        get() = _navigationToDetailsLive
    private val _navigationToDetailsLive = SingleLiveData<Unit>()


    val appState: LiveData<DataState>
        get() =  _appState
    private val _appState = MutableLiveData<DataState>()



    init {
        _appState.postValue(DataState.LOADING)
        loadMovies()
    }


    fun onHQSelected(position: Int) {
        _movieLiveData.postValue(Movie ("Minha HQ 2", "2 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        _navigationToDetailsLive.postValue(Unit)
    }

    private fun loadMovies() {
        _movieListLiveData.postValue(PlaceholderContent.ITEMS)
        _appState.postValue(DataState.SUCCESS)
    }

}