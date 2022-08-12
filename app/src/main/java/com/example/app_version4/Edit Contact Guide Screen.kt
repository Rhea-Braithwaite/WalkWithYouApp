package com.example.app_version4

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun EditGuideScreen(
    navController: NavController
) {

    Column (
        modifier = Modifier.fillMaxSize().padding(bottom = 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        DisplayBox(
            navController = navController,
            title = "Edit Contact Person",
            route = "edit_contact"
        )
        DisplayBox(
            navController = navController,
            title = "Edit Contact Text",
            route = "edit_message"
        )
    }
}