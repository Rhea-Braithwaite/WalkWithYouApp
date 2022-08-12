package com.example.app_version4

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.app_version4.ui.theme.Blue
import com.example.app_version4.ui.theme.DarkBlue


@Composable
fun ToBring(
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 15.dp, end = 15.dp, bottom = 85.dp, top = 15.dp)
    ){
        item {
            Text(
                text = "Three Secret Self-Defense Tools",
                fontSize = 20.sp,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }

        item {
            DisplayTool(
                title = "Pepper Spray",
                content = "Pepper spray is one of the most well-known and one of the best self-defense products for women. The less-lethal self-defense weapon allows you to incapacitate an attacker from a distance and is very effective.",
                pros = listOf(
                    "Effectiveness: Pepper spray is very effective at temporarily blinding and incapacitating a perpetrator.",
                    "Weapon Range: Pepper spray allows you to incapacitate a perpetrator from a distance without having to physically make contact with them, which is very important in self-defense."
                ),
                cons = listOf(
                    "Environmental Conditions: Pepper spray should be used with caution in certain environments like close-quarter spaces (where you can accidentally get sprayed), or in outdoor windy environments.",
                    "Potency Limitations: While pepper spray is very potent, some perpetrators may not be affected and impaired by it."
                ),
                picture = R.drawable.pepper_spray
            )
        }

        item {
            DisplayTool(
                title = "Self Defense Keychains",
                content = "Cat Ears Keychains are a cute and effective way to add some extra protection to your daily life. The keychain is designed as a cat's face with pointed ears which are the weapons on this protective tool and can be used to strike an aggressor.",
                pros = listOf(
                    "Effective: Cat Ear Keychains can be very effective at inflicting pain and damage to an attacker when used properly in self-defense.",
                    "Cheap: Cat Ears Keychains can be purchased from online retailers for less than \$10, a very cost-effective way to defend yourself.",
                    "Style: The design and style won't appeal to everyone, but those who love cats or animals will find these protective products cute and endearing."
                ),
                cons = listOf(
                    "Practicality: Cat Ear Keychains are more bulky and impractical than other self-defense keychains, as they are bigger and have larger points."
                ),
                picture = R.drawable.cat_ears
            )
        }

        item {
            DisplayTool(
                title = "Open Point Ring",
                content = "Open Point Rings from Defender Ring are one of the best self-defense weapons for any woman to have for practical protection. Open Point Rings are worn as everyday jewelry and designed with style and subtlety in mind while giving their wearer the ability to cut skin, draw blood, and collect the DNA of an attacker.",
                pros = listOf(
                    "Small: Open Point Rings are 2.25 mm thin, less than the thickness of two pennies stacked together.",
                    "Lightweight: Each Open Point Ring weighs 3 grams, slightly heavier than a penny.",
                    "Modern: Open Point Rings are designed as minimalist rings that you can wear every single day.",
                    "Effective: Open Points Rings are equipped with beveled points that can inflict significant damage to an attacker."
                ),
                cons = listOf(
                    "Personal Style: Open Point Rings are worn as everyday jewelry so their style and colors need to match your taste.",
                    "Power: Open Point Rings can supplement your defensive capabilities, but won't equip you with incapacitating power by itself."
                ),
                picture = R.drawable.ring
            )
        }
        item {
            Text(
                text = "Source: https://www.defenderring.com/blogs/news/the-best-self-defense-weapons-for-women",
                fontSize = 13.sp
            )
        }
    }
}

@Composable
fun DisplayTool(
    title: String,
    content: String,
    pros: List<String>,
    cons: List<String>,
    @DrawableRes picture: Int
) {
    Column(
        modifier = Modifier
            .padding(top = 25.dp)
            .border(width = 3.dp, color = Blue, shape = RoundedCornerShape(7))
    ) {
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = DarkBlue
        )

        Text(
            text = content,
            modifier = Modifier.padding(5.dp),
            fontSize = 17.sp,
            lineHeight = 25.sp
        )
        CoilImage(graphic = picture)
        Text(
            text = "Pros",
            modifier = Modifier.padding(7.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
        DisplaySteps(steps = pros)
        Text(
            text = "Cons",
            modifier = Modifier.padding(7.dp),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp,
        )
        DisplaySteps(steps = cons)

    }
}


@Composable
fun DisplaySteps(
    steps: List<String>
) {
    val paragraphStyle = ParagraphStyle(textIndent = TextIndent(restLine = 12.sp))
    Text(
        buildAnnotatedString {
            steps.forEach {
                withStyle(style = paragraphStyle) {
                    append(Typography.bullet)
                    append("\t\t")
                    append(it)
                }
            }
        },
        fontSize = 17.sp,
        lineHeight = 25.sp,
        modifier = Modifier.padding(horizontal = 7.dp, vertical = 3.5.dp)
    )

}

@Composable
fun CoilImage(
    @DrawableRes graphic: Int
) {

    //Create an ImageLoader

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (Build.VERSION.SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()

    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(context).data(data = graphic).apply(
                block = {
                    size(Size.ORIGINAL)
                }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.5.dp),
    )
}

@Preview
@Composable
fun Bring() {
    val navController = rememberNavController()
    ToBring(navController = navController)

}
