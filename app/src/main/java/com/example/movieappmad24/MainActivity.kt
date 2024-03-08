package com.example.movieappmad24

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.ui.theme.MovieAppMAD24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppMAD24Theme {
                // A surface container using the 'background' color from the theme
               TopandBottomBar()
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopandBottomBar(){
     Scaffold( topBar = { CenterAlignedTopAppBar(modifier = Modifier.background(Color.Cyan), title = { Text(text = "MovieAppMAD24")}
        )
     }, bottomBar =  {
            BottomAppBar (modifier = Modifier.fillMaxWidth(), content = {
                Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
                , modifier = Modifier
                        .fillMaxWidth()
                        .padding(60.dp, 0.dp, 60.dp, 0.dp)
                        ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = { /* Aktion für das linke Symbol */ }) {
                            Icon(Icons.Filled.Home, contentDescription = "Back to home")
                        }
                        Text("Home")


                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = { /* Aktion für das linke Symbol */ }) {
                            Icon(imageVector = Icons.Outlined.Star, contentDescription = "Watchlist")
                        }
                        Text("Watchlist")
                    }

                }
            }
         )
     }
     ) {innerPadding ->
         Box( modifier = Modifier
             .padding(innerPadding)
             .fillMaxSize(),
             contentAlignment = Alignment.Center
         ) {
             MovieList(getMovies())

         }
     }

 }


@Composable
fun MovieListGrid(titles: String = "Nothing") {
    Column {
        Image(
            painter = painterResource(id = R.drawable.movie_image),
            contentDescription = "placeholder_image"
        )
        Row(
            modifier = Modifier.background(Color.Yellow),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        )
        {
            Text(titles)
            Icon(
                imageVector = Icons.Outlined.KeyboardArrowUp,
                contentDescription = "Expand the list"
            )//,  = Align.RIGHT)
        }
    }
}

@Composable
fun MovieList(lst: List<Movie>){//lst: List<String> = listOf("Avatar", "Lord of the Rings", "Terminator", "Spaceballs")){

    LazyColumn{
        items(lst){ lst -> MovieListGrid(lst.title) }
    }

}









// OLD CODE!
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
fun MovieListbak(lst: List<Movie>){//lst: List<String> = listOf("Avatar", "Lord of the Rings", "Terminator", "Spaceballs")){

    LazyColumn{
        items(lst){ lst -> MovieRow(lst.title)}
    }

}