package com.vitorsousa.moviescatalog.repository

import com.vitorsousa.moviescatalog.data.Movie
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

    override suspend fun getTopRatedMovies(): Result<List<Movie>?> {
        return try {
            val result = movieApiClientDataSource.getTopRatedMovies()

            if (result.isSuccess) {
                persistData(result.getOrNull())
                result
            } else {
                movieDatabaseDataSource.getTopRatedMovies()
            }
        } catch (e: Exception) {
            movieDatabaseDataSource.getTopRatedMovies()
        }
    }

    override suspend fun getMovieDetail(id: Int): Result<Movie?> {
        return try {
            val result = movieApiClientDataSource.getMovie(id)

            if (result.isSuccess) {
                saveMovieData(result.getOrNull())
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
        movieList?.let { movieDatabaseDataSource.saveMovieList(movieList) }
    }

    private suspend fun getLocalMovieDetail(id: Int): Result<Movie?> = movieDatabaseDataSource.getMovie(id)

    private suspend fun saveMovieData(movie: Movie?) {
        movie?.let { movieDatabaseDataSource.saveMovie(it) }
    }


}