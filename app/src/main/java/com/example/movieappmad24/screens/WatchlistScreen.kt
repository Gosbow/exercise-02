package com.example.movieappmad24.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.movieappmad24.models.getMovies
import com.example.movieappmad24.navigation.BottomBarScreen
import com.example.movieappmad24.widgets.MovieRow

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WatchlistScreen(navController: NavController){
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
        Scaffold(topBar = { CenterAlignedTopAppBar(modifier = Modifier.padding(top=5.dp), title = { Text(text = "Your Watchlist") }
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
                        IconButton(onClick = { navController.navigate(BottomBarScreen.Home.route) }) {
                            Icon(imageVector = if(currentBackStackEntry?.destination?.route == BottomBarScreen.Home.route) Icons.Filled.Home else Icons.Outlined.Home, contentDescription = "Back to home")
                        }
                        Text("Home")
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        IconButton(onClick = { /* Aktion für das rechte Symbol */ }) {
                            Icon(imageVector = if(currentBackStackEntry?.destination?.route == BottomBarScreen.Watchlist.route) Icons.Filled.Star else Icons.Outlined.Star, contentDescription = "Watchlist", modifier = Modifier.background(Color.Green))
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
                Column(modifier = Modifier
                    .padding(bottom = 5.dp)
                    .verticalScroll(rememberScrollState())) {
                 //   MovieRow(getMovies().get(0))
                  //  MovieRow(getMovies().get(5))
                   // MovieRow(getMovies().get(1))
                }
            }
        }
}
