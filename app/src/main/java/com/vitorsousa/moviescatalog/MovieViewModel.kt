package com.vitorsousa.moviescatalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vitorsousa.moviescatalog.placeholder.PlaceholderContent

class MovieViewModel: ViewModel() {

    val movieDetailsLiveData: LiveData<MovieDetails>
        get() = _movieDetailsLiveData
    private val _movieDetailsLiveData = MutableLiveData<MovieDetails>()

    val movieListLiveData: LiveData<MutableList<PlaceholderContent.PlaceholderItem>>
        get() = _movieListLiveData
    private val _movieListLiveData= MutableLiveData<MutableList<PlaceholderContent.PlaceholderItem>>()

    val navigationToDetailsLive: LiveData<Unit>
        get() = _navigationToDetailsLive
    private val _navigationToDetailsLive = SingleLiveData<Unit>()



    init {
        _movieListLiveData.postValue(PlaceholderContent.ITEMS)
    }


    fun onHQSelected(position: Int) {
        _movieDetailsLiveData.postValue(MovieDetails ("Minha HQ 2", "2 - Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."))
        _navigationToDetailsLive.postValue(Unit)
    }
}