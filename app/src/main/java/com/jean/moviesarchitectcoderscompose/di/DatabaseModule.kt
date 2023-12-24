package com.jean.moviesarchitectcoderscompose.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jean.moviesarchitectcoderscompose.core.data.database.AppDatabase
import com.jean.moviesarchitectcoderscompose.core.data.database.DatabaseConstants.MOVIES_DATABASE
import com.jean.moviesarchitectcoderscompose.favorites.data.database.FavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): RoomDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, MOVIES_DATABASE).build()
    }

    @Provides
    fun provideFavoriteDao(database: AppDatabase): FavoriteDao {
        return database.favoriteDao()
    }

}