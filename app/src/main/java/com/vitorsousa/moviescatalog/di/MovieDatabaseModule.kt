package com.vitorsousa.moviescatalog.di

import android.content.Context
import androidx.room.Room
import com.vitorsousa.moviescatalog.database.MoviesDatabase
import com.vitorsousa.moviescatalog.dao.MovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class MovieDatabaseModule {

    @Provides
    fun provideMovieDao(moviesDatabase: MoviesDatabase): MovieDao {
        return moviesDatabase.movieDao()
    }


    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext appContext: Context): MoviesDatabase {
        return Room.databaseBuilder(
            appContext,
            MoviesDatabase::class.java,
            "MoviesDatabase"
        ).build()
    }
}