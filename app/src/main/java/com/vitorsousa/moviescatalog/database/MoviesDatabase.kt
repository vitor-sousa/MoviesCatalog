package com.vitorsousa.moviescatalog.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vitorsousa.moviescatalog.dao.MovieDao
import com.vitorsousa.moviescatalog.data.Movie

@Database(
    entities = [Movie::class],
    version = 1,
    exportSchema = true
)
abstract class MoviesDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}