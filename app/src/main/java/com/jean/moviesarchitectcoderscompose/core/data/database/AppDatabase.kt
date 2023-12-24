package com.jean.moviesarchitectcoderscompose.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jean.moviesarchitectcoderscompose.favorites.data.database.FavoriteDao
import com.jean.moviesarchitectcoderscompose.favorites.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

}