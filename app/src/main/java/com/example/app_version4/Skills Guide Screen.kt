package com.example.app_version4

import com.example.app_version4.ui.theme.Purple500

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_version4.ui.theme.Blue

@Composable
fun SkillsGuideScreen(
    navController: NavController
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(bottom = 80.dp)
    ) {
        item {
            DisplayBox(navController = navController, title = "Eight Self-Defense Moves for Women", route = "self_defense")
        }
        item {
            DisplayBox(navController = navController, title = "Nine Tips for Walking Alone at Night", route = "night_tips")
        }

        item {
            DisplayBox(navController = navController, title = "Three Secret Self-Defense Tools", route = "to_bring")
        }

        item {
            DisplayBox(navController = navController, title = "Self-Defense Videos", route = "video_demo")
        }




    }
}

@Composable
fun DisplayBox(
    navController: NavController,
    title: String,
    route: String
) {
    Box(
        modifier = Modifier
            .padding(vertical = 25.dp)
            .width(300.dp)
            .height(150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Blue)
            .clickable {
                Navigate(navController = navController, route = route)
            },
        contentAlignment = Alignment.Center,

        ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 30.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.h3
        )
    }
}