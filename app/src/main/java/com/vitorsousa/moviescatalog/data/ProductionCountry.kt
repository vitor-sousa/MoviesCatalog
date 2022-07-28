package com.vitorsousa.moviescatalog.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductionCountry(
    val iso_3166_1: String?,
    val name: String?
)