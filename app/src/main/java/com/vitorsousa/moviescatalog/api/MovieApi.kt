package com.vitorsousa.moviescatalog.api

import com.vitorsousa.moviescatalog.data.MovieResponse
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ) : Response<MovieResponse>

    @GET("movie/{id}")
    suspend fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String
    ): Response<MovieDetail>
}