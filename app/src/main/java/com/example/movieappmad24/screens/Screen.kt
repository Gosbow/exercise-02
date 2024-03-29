package com.example.movieappmad24.screens

sealed class Screen (val route: String) {
    object Home: Screen(route ="homescreen")
    object Detail: Screen(route = "detailscreen")
}