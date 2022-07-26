package com.vitorsousa.moviescatalog.dataSource

import android.app.Application
import com.vitorsousa.moviescatalog.R
import com.vitorsousa.moviescatalog.api.MovieApi
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class MovieApiClientDataSource @Inject constructor(
    private val api: MovieApi,
    private val application: Application
): MovieDataSource {

    override suspend fun getPopularMovies(): Result<List<Movie>?> =
        withContext(Dispatchers.IO) {
            val response = api.getPopularMovies(
                apiKey = application.getString(R.string.apiKey),
                language = "${Locale.getDefault().language}-${Locale.getDefault().country}"
            )

            when {
                response.isSuccessful -> Result.success(response.body()?.results)
                else -> Result.failure(Throwable(response.message()))
            }
        }


    override suspend fun getMovieDetail(id: Int): Result<MovieDetail?> =
        withContext(Dispatchers.IO) {
            val response = api.getMovieDetail(
                id = id,
                apiKey = application.getString(R.string.apiKey),
                language = "${Locale.getDefault().language}-${Locale.getDefault().country}"
            )

            when {
                response.isSuccessful -> Result.success(response.body())
                else -> Result.failure(Throwable(response.message()))
            }
        }

    override suspend fun saveMovieDetail(movieDetail: MovieDetail) {
        //NO-OP
    }


    override suspend fun saveData(moviesList: List<Movie>) {
        //NO-OP
    }
}