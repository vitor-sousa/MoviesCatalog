package com.vitorsousa.moviescatalog.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vitorsousa.moviescatalog.data.DataState
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.repository.MovieRepository
import com.vitorsousa.moviescatalog.utils.SingleLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {

    val movieLiveData: LiveData<Movie?>
        get() = _movieLiveData
    private val _movieLiveData = MutableLiveData<Movie?>()

    val movieListLiveData: LiveData<List<Movie>>
        get() = _movieListLiveData
    private val _movieListLiveData = MutableLiveData<List<Movie>>()

    val movieTopRatedListLiveData: LiveData<List<Movie>>
        get() = _movieTopRatedListLiveData
    private val _movieTopRatedListLiveData = MutableLiveData<List<Movie>>()

    val navigationToDetailsLive: LiveData<Unit>
        get() = _navigationToDetailsLive
    private val _navigationToDetailsLive = SingleLiveData<Unit>()


    val appState: LiveData<DataState>
        get() =  _appState
    private val _appState = MutableLiveData<DataState>()

    val detailAppState: LiveData<DataState>
        get() =  _detailAppState
    private val _detailAppState = MutableLiveData<DataState>()



    init {
        getMoviesData()
        getTopRatedMovies()
    }

    private fun getMoviesData() {
        _appState.value = DataState.LOADING

        viewModelScope.launch {
            val movieListResult = movieRepository.getPopularMovies()

            movieListResult.fold(
                onSuccess = {
                    _movieListLiveData.value = it
                    _appState.value = DataState.SUCCESS
                },
                onFailure = {
                    _appState.value = DataState.ERROR
                }
            )
        }
    }

    private fun getTopRatedMovies() {
        _appState.value = DataState.LOADING

        viewModelScope.launch {
            val movieListResult = movieRepository.getTopRatedMovies()

            movieListResult.fold(
                onSuccess = {
                    _movieTopRatedListLiveData.value = it
                    _appState.value = DataState.SUCCESS
                },
                onFailure = {
                    _appState.value = DataState.ERROR
                }
            )
        }
    }


    fun onHQSelected(id: Int) {
        _movieLiveData.value = null
        _navigationToDetailsLive.value = Unit
        _detailAppState.value = DataState.LOADING

        viewModelScope.launch {
            val movieDetailResult = movieRepository.getMovieDetail(id)

            movieDetailResult.fold(
                onSuccess = {
                    _movieLiveData.value = it
                    _detailAppState.value = DataState.SUCCESS
                },
                onFailure = {
                    _detailAppState.value = DataState.ERROR
                }
            )
        }
    }


}