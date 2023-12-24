package com.jean.moviesarchitectcoderscompose.movies.data.datasource

import com.jean.moviesarchitectcoderscompose.movies.data.network.models.MovieApiModel

interface MoviesRemoteDataSource {

    suspend fun getNowPlayingMovies(region: String): List<MovieApiModel>

}