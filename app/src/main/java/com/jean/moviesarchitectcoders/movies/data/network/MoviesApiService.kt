package com.jean.moviesarchitectcoders.movies.data.network

import com.jean.moviesarchitectcoders.movies.data.network.models.MoviesApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApiService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("region") region: String): Response<MoviesApiModel>

}