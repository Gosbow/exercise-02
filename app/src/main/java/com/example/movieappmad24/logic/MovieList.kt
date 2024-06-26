package com.example.movieappmad24.logic

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.navigation.Screen
import com.example.movieappmad24.viewmodels.MovieViewModel
import com.example.movieappmad24.widgets.MovieRow

@Composable
fun MovieList(lst: List<Movie>, navController: NavController, viewModel: MovieViewModel){

        LazyColumn {
            if(lst.isNotEmpty()) {
            items(lst) { m ->
                MovieRow(m, viewModel) { movieId ->
                    navController.navigate(route = Screen.Detail.MovieId(movieId))
                }
            }
        }
    }
}