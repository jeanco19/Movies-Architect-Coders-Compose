package com.jean.moviesarchitectcoders.di

import com.jean.moviesarchitectcoders.favorites.data.database.FavoriteDao
import com.jean.moviesarchitectcoders.favorites.data.datasource.FavoritesLocalDataSource
import com.jean.moviesarchitectcoders.favorites.data.datasource.FavoritesRoomDataSource
import com.jean.moviesarchitectcoders.movies.data.datasource.MoviesRemoteDataSource
import com.jean.moviesarchitectcoders.movies.data.datasource.MoviesRemoteRetrofitDataSource
import com.jean.moviesarchitectcoders.movies.data.network.MoviesApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    fun provideMoviesRetrofitDataSource(
        moviesApiService: MoviesApiService,
        coroutineDispatcher: CoroutineDispatcher
    ): MoviesRemoteDataSource {
        return MoviesRemoteRetrofitDataSource(moviesApiService)
    }

    @Provides
    fun provideFavoriteRoomDataSource(
        favoriteDao: FavoriteDao
    ): FavoritesLocalDataSource {
        return FavoritesRoomDataSource(favoriteDao)
    }

}