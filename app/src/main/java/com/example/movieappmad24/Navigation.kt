package com.example.movieappmad24

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homescreen" ) {
        composable(route = "homescreen") {
            HomeScreen()
        }
        composable("detailscreen") {
            DetailScreen()
        }
    }
}


