package com.example.movieappmad24

import android.graphics.Paint.Align
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                MovieList(getMovies())

            // A surface container using the 'background' color from the theme

            }
        }
    }
}

@Composable
fun MovieRow(titles: String = "Nothing"){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Card {
            Box {
                Box(modifier = Modifier
                    .matchParentSize()
                    .background(color = Color.Gray))
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.movie_image),
                        contentDescription = "placeholder_image"
                    )
                    Row(modifier = Modifier.background(Color.Yellow), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top)
                    {
                        Text(titles)
                        Icon(imageVector = Icons.Outlined.KeyboardArrowUp, contentDescription = "Expand the list")//,  = Align.RIGHT)
                    }
                }
            }
        }
    }
}

@Composable
fun MovieList(lst: List<Movie>){//lst: List<String> = listOf("Avatar", "Lord of the Rings", "Terminator", "Spaceballs")){

    LazyColumn{
        items(lst){ lst -> MovieRow(lst.title)}
    }

}