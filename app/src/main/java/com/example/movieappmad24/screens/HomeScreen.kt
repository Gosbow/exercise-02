package com.example.movieappmad24.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.logic.MovieList
import com.example.movieappmad24.models.getMovies


@Composable
fun HomeScreen(navController: NavController){
    TopandBottomBar(navController)
}


// Reusable Function
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopandBottomBar(navController: NavController){
    Scaffold(topBar = { CenterAlignedTopAppBar(modifier = Modifier.padding(top=5.dp), title = { Text(text = "MovieAppMAD24") }
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
            // Change Function Call to use this Overview for another things.
            MovieList(getMovies(), navController)
        }
    }
}

