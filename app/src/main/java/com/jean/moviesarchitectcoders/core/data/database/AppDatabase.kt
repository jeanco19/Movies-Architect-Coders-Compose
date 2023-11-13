package com.jean.moviesarchitectcoders.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jean.moviesarchitectcoders.favorites.data.database.FavoriteDao
import com.jean.moviesarchitectcoders.favorites.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun favoriteDao(): FavoriteDao

}