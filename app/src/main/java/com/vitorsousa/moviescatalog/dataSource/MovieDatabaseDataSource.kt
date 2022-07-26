package com.vitorsousa.moviescatalog.dataSource

import com.vitorsousa.moviescatalog.dao.MovieDao
import com.vitorsousa.moviescatalog.dao.MovieDetailDao
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDatabaseDataSource @Inject constructor(
    private val moviesDao: MovieDao,
    private val movieDetailDao: MovieDetailDao
): MovieDataSource {

    override suspend fun getPopularMovies(): Result<List<Movie>?> =
        withContext(Dispatchers.IO) {
            Result.success(moviesDao.getAllMovies())
        }

    override suspend fun getMovieDetail(id: Int): Result<MovieDetail?> =
        withContext(Dispatchers.IO) {
            Result.success(movieDetailDao.getMovieDetail(id))
        }


    override suspend fun saveMovieDetail(movieDetail: MovieDetail) {
        movieDetailDao.insert(movieDetail)
    }

    override suspend fun saveData(moviesList: List<Movie>) {
        moviesDao.insertList(moviesList)
    }
}