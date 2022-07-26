package com.vitorsousa.moviescatalog.repository

import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail
import com.vitorsousa.moviescatalog.dataSource.MovieDataSource
import javax.inject.Inject
import javax.inject.Named

class MovieRepositoryImp @Inject constructor(
    @Named ("api") private val movieApiClientDataSource: MovieDataSource,
    @Named ("database") private val movieDatabaseDataSource: MovieDataSource
): MovieRepository {


    override suspend fun getPopularMovies(): Result<List<Movie>?> {
        return try {
            val result = movieApiClientDataSource.getPopularMovies()

            if (result.isSuccess) {
                persistData(result.getOrNull())
                result
            } else {
                getLocalData()
            }
        } catch (e: Exception) {
            getLocalData()
        }

    }

    override suspend fun getMovieDetail(id: Int): Result<MovieDetail?> {
        return try {
            val result = movieApiClientDataSource.getMovieDetail(id)

            if (result.isSuccess) {
                saveMovieDetail(result.getOrNull())
                result
            } else {
                getLocalMovieDetail(id)
            }
        } catch (e: Exception) {
            getLocalMovieDetail(id)
        }
    }

    private suspend fun getLocalData(): Result<List<Movie>?> = movieDatabaseDataSource.getPopularMovies()

    private suspend fun persistData(movieList: List<Movie>?) {
        movieList?.let { movieDatabaseDataSource.saveData(movieList) }
    }

    private suspend fun getLocalMovieDetail(id: Int): Result<MovieDetail?> = movieDatabaseDataSource.getMovieDetail(id)

    private suspend fun saveMovieDetail(movieDetail: MovieDetail?) {
        movieDetail?.let { movieDatabaseDataSource.saveMovieDetail(movieDetail) }
    }


}