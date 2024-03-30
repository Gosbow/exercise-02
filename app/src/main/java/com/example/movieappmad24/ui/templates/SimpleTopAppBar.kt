package com.example.movieappmad24.ui.templates

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopAppBar(BackArrow: Boolean = false, title: String?, navController: NavController) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar( modifier = Modifier.padding(bottom = 20.dp),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "$title",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                //if(BackArrow == true){
                navigationIcon = {
                    IconButton({ navController.popBackStack() }) { //onClick = { /* do something */ }) {
                        if(BackArrow) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Return"
                            )
                        }
                    }
                }
                ,

                )
        },
    ) { innerPadding ->

    }
}

/*
@Preview
@Composable
fun PreviewSimpleTopBar() {
    SimpleTopAppBar(title = "wie gehts", BackArrow = false, navController = rememberNavController())
    Column(modifier = Modifier.padding(top = 77.dp)) {
        Text("Ich bin sooo cool")
    }
}
*/

