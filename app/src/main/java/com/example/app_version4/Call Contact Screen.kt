package com.example.app_version4

import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Scale
import com.example.app_version4.ui.theme.Blue
import coil.size.Size

@Composable
fun CallContactScreen(
    firstContactViewModel: ContactViewModel = viewModel(),
    secondContactViewModel: ContactViewModel = viewModel(),
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 18.dp, bottom = 80.dp)

    ) {
        DisplayContact(
            title = "Click to Call First Contact",
            name = firstContactViewModel.name,
            number = firstContactViewModel.phone
        )

        DisplayContact(
            title = "Click to Call Second Contact",
            name = secondContactViewModel.name,
            number = secondContactViewModel.phone
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
            CoilImage3(graphic = R.drawable.night3)

        }
    }
}

@Composable
fun DisplayContact(
    title: String,
    name: String,
    number: String
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .padding(vertical = 15.dp)
            .width(300.dp)
            .height(130.dp)
            .background(Blue)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        PhoneCall(context, number)
                    },
                    onLongPress = {
                        PhoneCall(context, number)
                    },
                    onTap = {
                        PhoneCall(context, number)
                    }
                )
            },
       horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 15.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Text(
            text = name,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(horizontal = 30.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5,
            color = Color.White
        )
    }


}

@Composable
fun CoilImage3(
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
//                    scale(Scale.FIT)
                }).build(), imageLoader = imageLoader
        ),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    CallContactScreen()
//    DisplayContact(title = "First Contact", name = "William Gong", number = "12345")

}