package com.example.movieappmad24.navigation

const val DETAIL_ARGUMENTED_KEY = "id"

sealed class Screen (val route: String) {
    object Home: Screen(route ="homescreen")
    object Detail: Screen(route = "detailscreen/{$DETAIL_ARGUMENTED_KEY}")
    fun MovieId(id: String): String{
        return "detailscreen/$id"
    }
}