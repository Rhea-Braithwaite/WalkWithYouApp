package com.example.app_version4.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.app_version4.R

// Set of Material typography styles to start with
//
val inter = FontFamily(
    listOf(
        Font(R.font.inter_regular, FontWeight.Normal),
        Font(R.font.inter_medium, FontWeight.Medium),
        Font(R.font.inter_semibold, FontWeight.SemiBold),
        Font(R.font.inter_bold, FontWeight.Bold),
        Font(R.font.inter_black, FontWeight.Black),
    )
)
//
val comfortaa = FontFamily(
    listOf(
        Font(R.font.comfortaa_regular, FontWeight.Normal),
        Font(R.font.comfortaa_medium, FontWeight.Medium),
        Font(R.font.comfortaa_semibold, FontWeight.SemiBold),
        Font(R.font.comfortaa_bold, FontWeight.Bold),
    )
)
//

val irish = FontFamily(
    listOf(
        Font(R.font.irishgrover_regular, FontWeight.Normal)
    )
)

val Typography = Typography(
    body1 = TextStyle(
        color = Color.Black,
        fontFamily = comfortaa,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    h1 = TextStyle(
        color = Purple,
        fontFamily = irish,
        fontWeight = FontWeight.SemiBold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.SemiBold,
    ),
    h3 = TextStyle(
        fontFamily = comfortaa,
        fontWeight = FontWeight.Medium,
    ),
    h4 = TextStyle(
        fontFamily = comfortaa,
        fontWeight = FontWeight.Medium,
        textDecoration = TextDecoration.Underline
    ),
    h5 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Medium,

    ),
    h6 = TextStyle(
        fontFamily = inter,
        fontWeight = FontWeight.Normal,
    ),
    button = TextStyle(
        fontFamily = comfortaa,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        color = DarkBlue
)
    /* Other default text styles to override

    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)