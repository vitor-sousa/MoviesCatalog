package com.vitorsousa.moviescatalog.dataSource

import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail

interface MovieDataSource {
    suspend fun getPopularMovies(): Result<List<Movie>?>
    suspend fun getMovieDetail(id: Int): Result<MovieDetail?>
    suspend fun saveMovieDetail(movieDetail: MovieDetail)
    suspend fun saveData(moviesList: List<Movie>)
}