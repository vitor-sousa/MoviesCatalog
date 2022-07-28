package com.vitorsousa.moviescatalog.dao

import androidx.room.Dao
import androidx.room.Query
import com.vitorsousa.moviescatalog.data.Movie

@Dao
interface MovieDao: BaseDao<Movie> {

    @Query("SELECT * FROM Movie ORDER BY popularity DESC")
    suspend fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM Movie ORDER BY vote_average DESC")
    suspend fun getTopRatedMovies(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id=:id")
    suspend fun getMovie(id: Int): Movie?
}