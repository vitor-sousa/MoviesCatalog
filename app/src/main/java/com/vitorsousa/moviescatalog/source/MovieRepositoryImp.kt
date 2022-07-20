package com.vitorsousa.moviescatalog.source

import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.source.remote.MovieApi
import java.util.*
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val api: MovieApi
): MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies("", "${Locale.getDefault().language}-${Locale.getDefault().country}").body()?.results ?: listOf()
    }


}