package com.vitorsousa.moviescatalog.dataSource

import com.vitorsousa.moviescatalog.data.Movie

interface MovieDataSource {
    suspend fun getPopularMovies(): Result<List<Movie>?>
    suspend fun getTopRatedMovies(): Result<List<Movie>?>
    suspend fun getMovie(id: Int): Result<Movie?>
    suspend fun saveMovie(movie: Movie)
    suspend fun saveMovieList(moviesList: List<Movie>)
}