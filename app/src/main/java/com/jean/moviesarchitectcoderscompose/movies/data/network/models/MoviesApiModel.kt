package com.jean.moviesarchitectcoderscompose.movies.data.network.models

import com.google.gson.annotations.SerializedName

data class MoviesApiModel(
    val results: List<MovieApiModel>
)

data class MovieApiModel(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("vote_average") val voteAverage: Double
)