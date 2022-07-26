package com.vitorsousa.moviescatalog.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity
@JsonClass(generateAdapter = true)
class Movie() {
    
    var adult: Boolean? = null
    var backdrop_path: String? = null
    @Ignore var genre_ids: List<Int>? = null
    @PrimaryKey(autoGenerate = false) var id: Int? = null
    var original_language: String? = null
    var original_title: String? = null
    var overview: String? = null
    var popularity: Double? = null
    var poster_path: String? = null
    var release_date: String? = null
    var title: String? = null
    var video: Boolean? = null
    var vote_average: Double? = null
    var vote_count: Int? = null

    @Ignore
    constructor(
        adult: Boolean?,
        backdrop_path: String?,
        genre_ids: List<Int>?,
        id: Int?,
        original_language: String?,
        original_title: String?,
        overview: String?,
        popularity: Double?,
        poster_path: String?,
        release_date: String?,
        title: String?,
        video: Boolean?,
        vote_average: Double?,
        vote_count: Int?,
    ): this() {
        this.id = id
        this.backdrop_path = backdrop_path
        this.adult = adult
        this.genre_ids = genre_ids
        this.original_title = original_title
        this.original_language = original_language
        this.overview = overview
        this.popularity = popularity
        this.poster_path = poster_path
        this.release_date = release_date
        this.title = title
        this.video = video
        this.vote_count = vote_count
        this.vote_average = vote_average
    }
}
