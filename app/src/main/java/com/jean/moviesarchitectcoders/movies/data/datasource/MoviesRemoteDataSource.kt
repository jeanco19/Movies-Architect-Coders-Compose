package com.jean.moviesarchitectcoders.movies.data.datasource

import com.jean.moviesarchitectcoders.movies.data.network.models.MovieApiModel

interface MoviesRemoteDataSource {

    suspend fun getNowPlayingMovies(region: String): List<MovieApiModel>

}