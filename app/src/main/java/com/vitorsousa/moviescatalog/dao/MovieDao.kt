package com.vitorsousa.moviescatalog.dao

import androidx.room.Dao
import androidx.room.Query
import com.vitorsousa.moviescatalog.data.Movie

@Dao
interface MovieDao: BaseDao<Movie> {

    @Query("SELECT * FROM Movie")
    suspend fun getAllMovies(): List<Movie>
}