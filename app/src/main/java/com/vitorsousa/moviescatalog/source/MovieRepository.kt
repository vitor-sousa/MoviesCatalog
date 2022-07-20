package com.vitorsousa.moviescatalog.source

import com.vitorsousa.moviescatalog.data.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}