package com.vitorsousa.moviescatalog.di

import com.vitorsousa.moviescatalog.repository.MovieRepository
import com.vitorsousa.moviescatalog.repository.MovieRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsMovieRepository(
        movieRepositoryImp: MovieRepositoryImp
    ): MovieRepository


}