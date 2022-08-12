package com.example.app_version4

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun VideoDemosScreen(
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 15.dp, end = 15.dp, top = 15.dp, bottom = 80.dp)
    ) {
        item {
            Text(
                text = "Self-Defense Videos",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }


        item{
            DisplayVideo(
                heading = "Self Defense with Aja Dang",
                vidTitle = "5 Choke Hold Defenses Women MUST KNOW",
                video = R.drawable.ajan__defense,
                link = "https://www.youtube.com/watch?v=-V4vEyhWDZ0",
                description = "In a perfect world, women wouldn't need to know self protection, but we are not in a perfect world. This video will teach you how to escape from some attacks and sexual assault positions. We covered some of the best defense moves in this self defense training video - even how to escape a choke hold."
            )
        }

        item{
            DisplayVideo(
                heading = "POPSUGAR Fitness",
                vidTitle = "7 Self-Defense Essentials to Protect Yourself",
                video = R.drawable.popsugar_defense,
                link = "https://www.youtube.com/watch?v=CKaa19kpqzM",
                description = "Protect yourself from an attacker with these essential moves from self-defense expert Jarrett Arthur."
            )
        }
    }
}

@Composable
fun DisplayVideo(
    heading: String,
    vidTitle: String,
    @DrawableRes video: Int,
    description: String,
    link: String
) {
    Column(
        modifier = Modifier.padding(top=15.dp)
    ) {
        Text(
            text = heading,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Text(
            text = description,
            modifier = Modifier.padding(horizontal = 3.5.dp, vertical = 7.5.dp),
            lineHeight = 25.sp,
            fontSize = 17.sp,
        )
        CoilImage(graphic = video)
        HyperLink(title = vidTitle, link = link)
    }


}

@Composable
fun HyperLink(
    title: String,
    link: String
) {

    val uriHandler = LocalUriHandler.current
    Text(
        text = title,
        color = Color.Blue,
        fontWeight = FontWeight.Medium,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .clickable {
                uriHandler.openUri(link)
            },
        textAlign = TextAlign.Center,
        lineHeight = 25.sp
    )
}