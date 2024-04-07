package com.example.movieappmad24.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

class MovieViewModel : ViewModel() {

    val movies = getMovies().associateWith { movie -> mutableStateOf(movie.isFavorite) }.toMutableMap()

    fun toggleFavorite(movie: Movie){


        Log.v("ViewModel", movies[movie]?.value.toString())

        if(movies[movie]?.value == true){
            movies[movie]?.value = false
        } else {
            movies[movie]?.value = true
        }
        Log.v("ViewModel1", movies[movie]?.value.toString())
    }

    fun getisFavorite(movie: Movie): Boolean{
        Log.v("ViewModel3", movies[movie]?.value.toString())
        return movies[movie]?.value ?: false
    }



}