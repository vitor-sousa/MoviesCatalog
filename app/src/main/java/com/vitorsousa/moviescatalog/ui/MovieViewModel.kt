package com.vitorsousa.moviescatalog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorsousa.moviescatalog.data.DataState
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.source.MovieRepository
import com.vitorsousa.moviescatalog.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {

    val movieLiveData: LiveData<Movie>
        get() = _movieLiveData
    private val _movieLiveData = MutableLiveData<Movie>()

    val movieListLiveData: LiveData<List<Movie>>
        get() = _movieListLiveData
    private val _movieListLiveData = MutableLiveData<List<Movie>>()

    val navigationToDetailsLive: LiveData<Unit>
        get() = _navigationToDetailsLive
    private val _navigationToDetailsLive = SingleLiveData<Unit>()


    val appState: LiveData<DataState>
        get() =  _appState
    private val _appState = MutableLiveData<DataState>()



    init {
        _appState.value = DataState.LOADING

        viewModelScope.launch {
            _movieListLiveData.value = movieRepository.getPopularMovies()
            _appState.value = DataState.SUCCESS
        }
    }


    fun onHQSelected(position: Int) {
        _movieLiveData.value = _movieListLiveData.value?.get(position)
        _navigationToDetailsLive.postValue(Unit)
    }

    private fun loadMovies() {
        _appState.value = DataState.SUCCESS
    }

}