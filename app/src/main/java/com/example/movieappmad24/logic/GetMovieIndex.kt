package com.example.movieappmad24.logic

import androidx.compose.runtime.Composable
import com.example.movieappmad24.models.getMovies

@Composable
fun GetMovieIndex(movieId: String?): Int {

    val movies = getMovies()
    for ((index, movie) in movies.withIndex()) {
        if (movie.id == movieId) {
           return index
        }
    }
    return 0
}