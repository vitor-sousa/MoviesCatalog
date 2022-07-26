package com.vitorsousa.moviescatalog.dao

import androidx.room.Dao
import androidx.room.Query
import com.vitorsousa.moviescatalog.data.movieDetail.MovieDetail

@Dao
interface MovieDetailDao: BaseDao<MovieDetail> {

    @Query("SELECT * FROM MovieDetail WHERE id=:id")
    suspend fun getMovieDetail(id: Int): MovieDetail?
}