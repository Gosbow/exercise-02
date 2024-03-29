package com.example.movieappmad24

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.Screen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }
/*
        composable(route = Screen.Detail.route){
            DetailScreen(movieId = "2", navController = navController)
        }
        */
        composable("detailscreen/{movieId}",
            arguments = listOf(navArgument(name = "movieId"){type = NavType.StringType})) {
            backStackEntry -> DetailScreen(movieId = backStackEntry.arguments?.getString("movieId"), navController)
        }

    }
}


