package com.example.movieappmad24.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.getMovies


@Composable
fun ImagesRow(movieIndex: Int, innerPadding: PaddingValues) {
    val images = getMovies().get(movieIndex).images.toList()

    Box(
        modifier = Modifier.padding(innerPadding),
        contentAlignment = Alignment.Center
    ) {
        Column {
            MovieRow(getMovies().get(movieIndex)) //  MovieRow(movie = getMovies().)//ScrollContent(innerPadding)
            Box(modifier = Modifier.padding(end = 2.dp)) {
                LazyRow {
                    items(images) { imageUrl ->

                        AsyncImage(
                            model = imageUrl,
                            contentDescription = getMovies().get(movieIndex).title,
                            modifier = Modifier.padding(end = 5.dp)
                                .size(420.dp)
                                .clip(shape = RoundedCornerShape(10.dp))//.aspectRatio(16f/9f)
                        )
                    }
                }
            }
        }
    }
}