package com.example.movieappmad24.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.logic.TrailerPlayer
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.viewmodels.MovieViewModel


@Composable
fun ImagesRow(movieIndex: Int, innerPadding: PaddingValues, viewModel: MovieViewModel) {
    val images = getMovies().get(movieIndex).images.toList()

    Box(
        modifier = Modifier.padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Column {
            MovieRow(
                getMovies().get(movieIndex),
                viewModel
            ) //  MovieRow(movie = getMovies().)//ScrollContent(innerPadding)
            Box(modifier = Modifier.padding(end = 2.dp)) {
                Column(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)) {
                    Text("Movie Trailer:")
                    TrailerPlayer(getMovies().get(movieIndex).trailer)

                    LazyRow {
                        items(images) { imageUrl ->

                            AsyncImage(
                                model = imageUrl,
                                contentDescription = getMovies().get(movieIndex).title,
                                modifier = Modifier.padding(top = 5.dp, end = 5.dp)
                                    .size(420.dp)
                                    .clip(shape = RoundedCornerShape(10.dp))//.aspectRatio(16f/9f)
                            )
                        }
                    }
                }
            }
        }
    }
}