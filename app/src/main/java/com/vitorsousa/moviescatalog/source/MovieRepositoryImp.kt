package com.vitorsousa.moviescatalog.source

import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.source.remote.MovieApi
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val api: MovieApi
): MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies("").body()?.results ?: listOf()
    }


}