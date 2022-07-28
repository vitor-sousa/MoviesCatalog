package com.vitorsousa.moviescatalog.dataSource

import com.vitorsousa.moviescatalog.dao.MovieDao
import com.vitorsousa.moviescatalog.data.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDatabaseDataSource @Inject constructor(
    private val moviesDao: MovieDao
): MovieDataSource {

    override suspend fun getPopularMovies(): Result<List<Movie>?> =
        withContext(Dispatchers.IO) {
            Result.success(moviesDao.getAllMovies())
        }

    override suspend fun getTopRatedMovies(): Result<List<Movie>?> =
        withContext(Dispatchers.IO) {
            Result.success(moviesDao.getTopRatedMovies())
        }

    override suspend fun getMovie(id: Int): Result<Movie?> =
        withContext(Dispatchers.IO) {
            Result.success(moviesDao.getMovie(id))
        }


    override suspend fun saveMovie(movie: Movie) {
        moviesDao.insert(movie)
    }

    override suspend fun saveMovieList(moviesList: List<Movie>) {
        moviesDao.insertList(moviesList)
    }
}