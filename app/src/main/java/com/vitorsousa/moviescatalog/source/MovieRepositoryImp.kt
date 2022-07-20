package com.vitorsousa.moviescatalog.source

import android.app.Application
import com.vitorsousa.moviescatalog.R
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.source.remote.MovieApi
import java.util.*
import javax.inject.Inject

class MovieRepositoryImp @Inject constructor(
    private val api: MovieApi,
    private val application: Application
): MovieRepository {

    override suspend fun getPopularMovies(): List<Movie> {
        return api.getPopularMovies(
            application.getString(R.string.apiKey),
            "${Locale.getDefault().language}-${Locale.getDefault().country}"
        ).body()?.results ?: listOf()
    }


}