package com.jean.moviesarchitectcoderscompose.movies.data.datasource

import com.jean.moviesarchitectcoderscompose.movies.data.network.MoviesApiService
import com.jean.moviesarchitectcoderscompose.movies.data.network.models.MovieApiModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class MoviesRemoteRetrofitDataSource @Inject constructor(
    private val moviesApiService: MoviesApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRemoteDataSource {

    override suspend fun getNowPlayingMovies(region: String): List<MovieApiModel> {
        return moviesApiService.getNowPlayingMovies(region).body()?.results ?: listOf()
    }

}