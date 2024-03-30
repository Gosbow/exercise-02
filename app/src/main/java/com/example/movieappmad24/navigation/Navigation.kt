package com.example.movieappmad24.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappmad24.screens.DetailScreen
import com.example.movieappmad24.screens.HomeScreen
import com.example.movieappmad24.screens.WatchlistScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        /* BACKUP
        composable("detailscreen/{movieId}",
            arguments = listOf(navArgument(name = "movieId"){type = NavType.StringType})) {
            backStackEntry -> DetailScreen(movieId = backStackEntry.arguments?.getString("movieId"), navController)
        }

         */

        composable(route = Screen.Detail.route,
            arguments = listOf(navArgument(DETAIL_ARGUMENTED_KEY){type = NavType.StringType})) {
                backStackEntry -> DetailScreen(movieId = backStackEntry.arguments?.getString(DETAIL_ARGUMENTED_KEY), navController)
        }
        composable(route = BottomBarScreen.Home.route){
        HomeScreen(navController = navController)
        }
        composable(route = BottomBarScreen.Watchlist.route){
        WatchlistScreen(navController = navController)
        }

    }
}


