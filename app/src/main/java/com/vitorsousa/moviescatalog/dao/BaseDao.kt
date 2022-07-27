package com.vitorsousa.moviescatalog.dao

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: T)

    @Insert
    suspend fun insertList(entities: List<T>)

    @Update
    suspend fun update(entity: T)

    @Update
    suspend fun updateList(entities: List<T>)

    @Delete
    suspend fun delete(entity: T)

    @Delete
    suspend fun deleteList(entities: List<T>)
}