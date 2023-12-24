package com.jean.moviesarchitectcoderscompose.di

import com.jean.moviesarchitectcoderscompose.favorites.data.database.FavoriteDao
import com.jean.moviesarchitectcoderscompose.favorites.data.datasource.FavoritesLocalDataSource
import com.jean.moviesarchitectcoderscompose.favorites.data.datasource.FavoritesRoomDataSource
import com.jean.moviesarchitectcoderscompose.movies.data.datasource.MoviesRemoteDataSource
import com.jean.moviesarchitectcoderscompose.movies.data.datasource.MoviesRemoteRetrofitDataSource
import com.jean.moviesarchitectcoderscompose.movies.data.network.MoviesApiService
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