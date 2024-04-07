package com.example.movieappmad24.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class MovieViewModel : ViewModel() {

    val movies = getMovies().associateWith { movie -> mutableStateOf(movie.isFavorite) }.toMutableMap()

    fun toggleFavorite(movie: Movie){

        val isFavorite = movies[movie]?.value
        movies[movie]?.value = !(isFavorite ?: false)
    }
}