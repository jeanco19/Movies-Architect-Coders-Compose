package com.jean.moviesarchitectcoderscompose.favorites.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.jean.moviesarchitectcoderscompose.favorites.data.database.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Upsert
    suspend fun upsertFavoriteMovies(movie: MovieEntity)

    @Query("SELECT * FROM favorite_movies")
    fun getFavoriteMovies(): Flow<List<MovieEntity>?>

}