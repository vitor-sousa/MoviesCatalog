package com.vitorsousa.moviescatalog.source.remote

import com.vitorsousa.moviescatalog.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ) : Response<MovieResponse>

}