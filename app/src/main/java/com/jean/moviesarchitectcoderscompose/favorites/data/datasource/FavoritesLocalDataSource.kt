package com.jean.moviesarchitectcoderscompose.favorites.data.datasource

import com.jean.moviesarchitectcoderscompose.favorites.data.database.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

interface FavoritesLocalDataSource {

    suspend fun saveFavoriteMovie(movie: MovieEntity)

    fun getFavoriteMovies(): Flow<List<MovieEntity>?>

}