package com.example.movieappmad24.ui.templates

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.movieappmad24.navigation.BottomBarScreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun SimpleBottomAppBar(navController: NavController) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()

        BottomAppBar (modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(60.dp, 0.dp, 60.dp, 0.dp)
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { navController.navigate(BottomBarScreen.Home.route) }) {
                        Icon(
                            imageVector = if (currentBackStackEntry?.destination?.route == BottomBarScreen.Home.route) Icons.Filled.Home else Icons.Outlined.Home,
                            contentDescription = "Back to home"
                        )
                    }
                    Text("Home")
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    IconButton(onClick = { /* Aktion für das rechte Symbol */ }) {
                        Icon(
                            imageVector = if (currentBackStackEntry?.destination?.route == BottomBarScreen.Watchlist.route) Icons.Filled.Star else Icons.Outlined.Star,
                            contentDescription = "Watchlist"
                        )
                    }
                    Text("Watchlist")
                }

            }
            }
}


@Preview
@Composable
fun PreviewSimpleBottomAppBar (){
    SimpleBottomAppBar(navController = rememberNavController())
}








/* BULLSHIT
@Composable
fun BottomBar(navController: NavController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Watchlist
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    //Bottom
}

fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
){
    //BottomNavigationItem
}

 */