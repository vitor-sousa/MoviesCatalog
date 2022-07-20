package com.vitorsousa.moviescatalog.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page: Int?,
    val results: List<Movie>?,
    val total_results: Int?,
    val total_pages: Int?
)
