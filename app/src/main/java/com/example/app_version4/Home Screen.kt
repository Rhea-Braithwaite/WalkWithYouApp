package com.example.app_version4

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Scale
import coil.size.Size
import com.example.app_version4.ui.theme.Blue
import com.example.app_version4.ui.theme.LightBlue
import com.example.app_version4.ui.theme.Purple


//Display Homescreen Components
@Composable
fun HomeScreen(
    navController: NavController,
    locationViewModel: LocationViewModel
){

    Column ( modifier = Modifier
        .fillMaxSize()
    ) {
//        LandingPage()
        CoilImage2(graphic = R.drawable.landing_page_1, modifier = Modifier
            .padding(start = 60.dp, end = 60.dp)
            .fillMaxWidth())

        Text(
            text = "WALK WITH YOU",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.5.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h1
//            color = Purple,
//            fontSize = 28.sp,
//            fontStyle = FontStyle.Italic

        )

        WhereAreYou(
            value = locationViewModel.location,
            onValueChange = { locationViewModel.onLocationChange(it)}
        )
        ScreenOptions(navController,
            options = listOf(
                HomeScreenOption(
                    title = "SKILLS",
                    R.drawable.lightbulb,
                    NavDrawerItem.Skills.route
                ),
                HomeScreenOption(
                    title = "EDIT CONTACT",
                    R.drawable.lightbulb,
                    NavDrawerItem.EditContact.route
                ),
                HomeScreenOption(
                    title = "CALL SIMULATOR",
                    R.drawable.lightbulb,
                    NavDrawerItem.CallSim.route
                ),
                HomeScreenOption(
                    title = "ABOUT US",
                    R.drawable.lightbulb,
                    NavDrawerItem.AboutUs.route
                ),
            )

        )
    }
}

@Composable
fun CoilImage2(
    @DrawableRes graphic: Int,
    modifier: Modifier
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

    Box (modifier = modifier) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = graphic).apply(
                    block = {
                        //                    size(Size.ORIGINAL)
                        scale(Scale.FIT)
                    }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
//Landing Page Image
@Composable
fun LandingPage(){
    Box(
        modifier = Modifier
            .padding(start = 35.dp, end = 35.dp, top = 25.dp, bottom = 10.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray)
            .fillMaxWidth(),

        contentAlignment = Alignment.Center

    ){
        Text(
            text ="Landing Page",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable {
                    //Handle the click
                }
                .fillMaxWidth()
                .padding(horizontal = 80.dp, vertical = 30.dp)
            ,
            textAlign = TextAlign.Center
        )
    }
}


//User enters their location and it is saved
@Composable
fun WhereAreYou(
    value: String,
    onValueChange: (String) -> Unit
){
    val focusManager = LocalFocusManager.current

    Column (modifier = Modifier.padding(start = 35.dp, bottom = 5.dp, end = 35.dp)){
//        Text(
//            text = "Where are you?",
//            fontSize = 20.sp,
//            modifier = Modifier.padding(start = 5.dp)
//
//        )

        OutlinedTextField(
            value = value ,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = Blue,
                fontWeight = FontWeight.Bold
            ),
            label = {
                Text(
                    text = "Where are you?",
                    color = Blue,
                    style = MaterialTheme.typography.h2
                ) },
            leadingIcon = {Icon(Icons.Default.Place, contentDescription = "", tint = Blue)},
            shape = RoundedCornerShape(percent = 30),
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.Transparent,
                focusedBorderColor = Blue,
                unfocusedBorderColor = Blue)
        )
    }
}

//Display all the app functionalities
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScreenOptions(
    navController: NavController,
    options: List<HomeScreenOption>
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 20.dp, end = 20.dp, bottom = 75.dp) ,
            modifier = Modifier.fillMaxHeight(),

            ){
            items(options.size){
                ScreenOptionItem(
                    navController,
                    option = options[it]
                )
            }
        }

    }
}

//Display Card of App Functionality
@Composable
fun ScreenOptionItem(
    navController: NavController,
    option: HomeScreenOption
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, bottom = 7.5.dp, top = 15.dp)
            .aspectRatio(1.2f)
            .clip(RoundedCornerShape(10.dp))
            .background(Blue)
            .clickable {
                //If card is clicked, navigate to respective screen
                Navigate(navController = navController, route = option.route)
            },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = option.title,
            fontSize = 18.sp,
            lineHeight = 26.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(horizontal = 10.dp)
        )
    }
}

//Buttons to Call Emergency Contact or Police
@Composable
fun CallButtonMenu(
    buttons: List<CallButtonItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    firstContactPhone: String
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(LightBlue)
            .padding(bottom = 3.dp)
    ) {
        // Display Both Buttons
        if(currentRoute(navController = navController as NavHostController) != "call_contact"){
            CallButtonItem(
                button = buttons[0],
                navController = navController,
                firstContactPhone = firstContactPhone
            )
        }

        CallButtonItem(
            button = buttons[1],
            navController = navController,
            firstContactPhone = firstContactPhone
        )
    }
}

//Display Call Button
@Composable
fun CallButtonItem(
    button: CallButtonItem,
    navController: NavController,
    firstContactPhone: String
){
    val context = LocalContext.current

    var isPressed by remember{
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
        ){

            Image(
                painter = painterResource(id = R.drawable.circle_fill),
                contentDescription = "",
                modifier = Modifier
                    .size(57.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                try {
                                    isPressed = true
                                    awaitRelease()
                                } finally {
                                    isPressed = false
                                }
                            },
                            onLongPress = {
                                if (button.num == 1) {
                                    PhoneCall(context = context, number = "911")
                                } else {
                                    PhoneCall(context = context, number = firstContactPhone)
                                }
                            },
                            onTap = {
                                if (button.num == 1) {
                                    PhoneCall(context = context, number = "911")
                                    //
                                } else {
                                    //navigate
                                    Navigate(navController = navController, route = button.route)
                                }
                            }
                        )
                    },
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.tint(
                    button.buttonColor.copy(
                        alpha = if (isPressed) .88f else 1f
                    )
                )
            )
        }
        Text(
            text = button.title,
            style = MaterialTheme.typography.h6,
        )
    }
}


//Exit to Phone App and Call Number
fun PhoneCall(
    context: Context,
    number: String
){
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))

    ContextCompat.startActivity(context, intent, null)

}

@Preview
@Composable
fun HomePrev() {
    val navController = rememberNavController()
    val locationViewModel = viewModel<LocationViewModel>()
    HomeScreen(navController = navController, locationViewModel = locationViewModel)
}