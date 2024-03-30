package com.example.movieappmad24.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.movieappmad24.models.Movie

@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}){
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .clip(MaterialTheme.shapes.medium)
        .padding(top = 15.dp)
        .clickable {
            onItemClick(movie.id) }) {
        //  onItemClick(movie.title)}){
        Box(modifier = Modifier) {

            AsyncImage(model = movie.images.get(0), contentDescription = movie.title)
            IconButton(
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .align(Alignment.TopEnd),
                onClick = { /* Kommt noch etwas, die Logik für den Rest*/ }
            ) {
                Icon(
                    imageVector = Icons.Outlined.FavoriteBorder,
                    contentDescription = "Add to Favorites",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .background(color = Color.LightGray)
                .fillMaxWidth()
                .padding(5.dp, 0.dp, 15.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(movie.title)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowUp,
                    contentDescription = if (expanded) "Close the Information" else "Expand for more Information",
                )
            }

        }
        AnimatedVisibility(
            modifier = Modifier
                .animateContentSize()
                .background(color = Color.LightGray)
                .fillMaxWidth(),
            visible = expanded,

            enter = expandVertically(animationSpec = spring()),
            exit = shrinkVertically(animationSpec = spring())
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)

            ) {
                Text("Director: ${movie.director}")
                Text("Release: ${movie.year}")
                Text("Genre: ${movie.genre}")
                Text("Actors: ${movie.actors}")
                Text("Rating: ${movie.rating}")
                Divider(color = Color.Black, thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
                Text("Plot: ${movie.plot}")
                Text("Trailer: ${movie.trailer}")

            }
        }
    }

}