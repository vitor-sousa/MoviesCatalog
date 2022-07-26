package com.vitorsousa.moviescatalog.repository

import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail

interface MovieRepository {
    suspend fun getPopularMovies(): Result<List<Movie>?>
    suspend fun getMovieDetail(id: Int): Result<MovieDetail?>
}