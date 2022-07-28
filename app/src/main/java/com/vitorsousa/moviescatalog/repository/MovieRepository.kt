package com.vitorsousa.moviescatalog.repository

import com.vitorsousa.moviescatalog.data.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): Result<List<Movie>?>
    suspend fun getTopRatedMovies(): Result<List<Movie>?>
    suspend fun getMovieDetail(id: Int): Result<Movie?>
}