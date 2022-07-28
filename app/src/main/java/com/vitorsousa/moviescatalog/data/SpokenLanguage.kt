package com.vitorsousa.moviescatalog.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SpokenLanguage(
    val iso_639_1: String?,
    val name: String?
)