package com.vitorsousa.moviescatalog.data.movieDetail

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass
import com.vitorsousa.moviescatalog.utils.ImageUtils
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem

@Entity
@JsonClass(generateAdapter = true)
class MovieDetail() {
    
    var adult: Boolean? = null
    var backdrop_path: String? = null
    @Ignore var belongs_to_collection: Any? = null
    var budget: Int? = null
    @Ignore var genres: List<Genre>? = null
    var homepage: String? = null
    @PrimaryKey(autoGenerate = false) var id: Int? = null
    var imdb_id: String? = null
    var original_language: String? = null
    var original_title: String? = null
    var overview: String? = null
    var popularity: Double? = null
    var poster_path: String? = null
    @Ignore var production_companies: List<ProductionCompany>? = null
    @Ignore var production_countries: List<ProductionCountry>? = null
    var release_date: String? = null
    var revenue: Int? = null
    var runtime: Int? = null
    @Ignore var spoken_languages: List<SpokenLanguage>? = null
    var status: String? = null
    var tagline: String? = null
    var title: String? = null
    var video: Boolean? = null
    var vote_average: Double? = null
    var vote_count: Int? = null
    
    @Ignore
    constructor(
         adult: Boolean?,
         backdrop_path: String?,
         belongs_to_collection: Any?,
         budget: Int?,
         genres: List<Genre>?,
         homepage: String?,
         id: Int?,
         imdb_id: String?,
         original_language: String?,
         original_title: String?,
         overview: String?,
         popularity: Double?,
         poster_path: String?,
         production_companies: List<ProductionCompany>?,
         production_countries: List<ProductionCountry>?,
         release_date: String?,
         revenue: Int?,
         runtime: Int?,
         spoken_languages: List<SpokenLanguage>?,
         status: String?,
         tagline: String?,
         title: String?,
         video: Boolean?,
         vote_average: Double?,
         vote_count: Int?
    ) : this() {
        this.adult = adult
        this.backdrop_path = backdrop_path
        this.belongs_to_collection = belongs_to_collection
        this.budget = budget
        this.genres = genres
        this.homepage = homepage
        this.id = id
        this.imdb_id = imdb_id
        this.original_language = original_language
        this.original_title = original_title
        this.overview = overview
        this.popularity = popularity
        this.poster_path = poster_path
        this.production_companies = production_companies
        this.production_countries = production_countries
        this.release_date = release_date
        this.revenue = revenue
        this.runtime = runtime
        this.spoken_languages = spoken_languages
        this.status = status
        this.tagline = tagline
        this.title = title
        this.video = video
        this.vote_average = vote_average
        this.vote_count = vote_count
    }
    
    

    fun getCarouselImages() = production_companies?.map {
        CarouselItem(
            imageUrl = "${ImageUtils.baseImageUrl}${it.logo_path}",
            caption = "${it.name}"
        )
    }
}