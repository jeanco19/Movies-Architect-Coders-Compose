package com.jean.moviesarchitectcoders.favorites.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jean.moviesarchitectcoders.core.data.database.DatabaseConstants.FAVORITES_TABLE

@Entity(tableName = FAVORITES_TABLE)
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val voteAverage: Double,
    val isFavorite: Boolean
)