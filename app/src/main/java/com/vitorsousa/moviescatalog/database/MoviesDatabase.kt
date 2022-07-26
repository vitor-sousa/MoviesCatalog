package com.vitorsousa.moviescatalog.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vitorsousa.moviescatalog.data.Movie
import com.vitorsousa.moviescatalog.dao.MovieDao
import com.vitorsousa.moviescatalog.dao.MovieDetailDao
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail

@Database(
    entities = [Movie::class, MovieDetail::class],
    version = 1,
    exportSchema = false
)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun movieDetailDao(): MovieDetailDao
}