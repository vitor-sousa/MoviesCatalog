package com.vitorsousa.moviescatalog.di

import android.app.Application
import com.vitorsousa.moviescatalog.api.MovieApi
import com.vitorsousa.moviescatalog.dao.MovieDao
import com.vitorsousa.moviescatalog.dataSource.MovieApiClientDataSource
import com.vitorsousa.moviescatalog.dataSource.MovieDataSource
import com.vitorsousa.moviescatalog.dataSource.MovieDatabaseDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MovieDataSource {


    @Provides
    @Singleton
    @Named("api")
    fun providesMovieApiClientDataSource(
        api: MovieApi,
        application: Application
    ): MovieDataSource {
        return MovieApiClientDataSource(api, application)
    }


    @Provides
    @Singleton
    @Named("database")
    fun providesMovieDatabaseDataSource(
        moviesDao: MovieDao
    ): MovieDataSource {
        return MovieDatabaseDataSource(moviesDao)
    }

}