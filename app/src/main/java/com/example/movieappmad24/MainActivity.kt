package com.example.movieappmad24

import android.os.Bundle
import android.text.style.BackgroundColorSpan
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.KeyboardArrowDown
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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
                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
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
                        IconButton(onClick = { /* Aktion für das rechte Symbol */ }) {
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
fun MovieListGrid(id: String = "nothing", title: String = "nothing", year: String = "nothing", genre: String = "nothing", director: String = "nothing", actors: String = "nothing", plot: String = "nothing", images: List<String>, trailer: String = "nothing", rating:  String = "nothing") {
    var expanded by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth().clip(MaterialTheme.shapes.medium).padding(top = 15.dp)) {
       AsyncImage(model = images.get(0), contentDescription = title)

        /* Image(
            painter = painterResource(id = R.drawable.movie_image),
            contentDescription = "placeholder_image"
        )*/
        Row(
            modifier = Modifier.background(color = Color.LightGray).
            fillMaxWidth().
            padding(30.dp, 0.dp, 30.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            //  Text(id)
            Text(title)
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Outlined.KeyboardArrowDown else Icons.Outlined.KeyboardArrowUp,
                    contentDescription = if (expanded) "Close the Information" else "Expand for more Information",
                )
            }



        }
        AnimatedVisibility(
            modifier = Modifier.animateContentSize().background(color = Color.LightGray).fillMaxWidth(),
            visible = expanded,

            enter = expandVertically(animationSpec = spring()),
            exit = shrinkVertically(animationSpec = spring())
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Text(
                    "Option 1",
                    modifier = Modifier.clickable { /* Aktion für Option 1 */ })
                Text(
                    "Option 2",
                    modifier = Modifier.clickable { /* Aktion für Option 2 */ })
                Text(
                    "Option 3",
                    modifier = Modifier.clickable { /* Aktion für Option 3 */ })
            }
        }
    }

}

@Composable
fun MovieList(lst: List<Movie>){//lst: List<String> = listOf("Avatar", "Lord of the Rings", "Terminator", "Spaceballs")){

    LazyColumn{
        items(lst){ lst -> MovieListGrid(lst.id, lst.title, lst.year, lst.genre, lst.director, lst.actors, lst.plot, lst.images, lst.trailer, lst.rating)
        }
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