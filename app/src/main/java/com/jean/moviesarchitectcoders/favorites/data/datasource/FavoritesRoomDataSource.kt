package com.jean.moviesarchitectcoders.favorites.data.datasource

import com.jean.moviesarchitectcoders.favorites.data.database.FavoriteDao
import com.jean.moviesarchitectcoders.favorites.data.database.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRoomDataSource @Inject constructor(
    private val favoriteDao: FavoriteDao
) : FavoritesLocalDataSource {

    override suspend fun saveFavoriteMovie(movie: MovieEntity) {
        favoriteDao.upsertFavoriteMovies(movie)
    }

    override fun getFavoriteMovies(): Flow<List<MovieEntity>?> {
        return favoriteDao.getFavoriteMovies()
    }

}