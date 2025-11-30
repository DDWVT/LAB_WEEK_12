package com.example.test_lab_week_12

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.test_lab_week_12.model.Movie
import com.example.test_lab_week_12.model.PopularMoviesResponse
import com.example.test_lab_week_12.api.MovieService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepository (private val movieService: MovieService) {
    private val apiKey = "fa67a1e1f4f084c13fe0c494fd101027"

    fun fetchMovies(): Flow<List<Movie>> {
        return flow {
            emit(movieService.getPopularMovies (apiKey).results)
        }.flowOn (Dispatchers.IO)
    }
}