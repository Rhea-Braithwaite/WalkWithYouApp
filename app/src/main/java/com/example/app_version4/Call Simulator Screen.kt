package com.example.app_version4

import android.media.MediaPlayer
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
@Composable
fun CallScreen(navController: NavController, name: String?, song: Int?) {

    val context = LocalContext.current

    // Load the user's selected conversation
    val sampleAudio: MediaPlayer by remember{
        mutableStateOf(
            MediaPlayer.create(
                context,
                song!!
            )
        )
    }

    sampleAudio.start()

    var minutes by remember { mutableStateOf(0) }
    var seconds by remember { mutableStateOf(0) }

    // Create List of Call Screen Icons
    val iconsList = listOf<IconItem>(
        IconItem(
            R.drawable.circle,
            R.drawable.mic_off,
            "Mic Off",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle,
            R.drawable.dialpad,
            "Dial Pad",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle,
            R.drawable.volume_up,
            "Speaker",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle,
            R.drawable.add,
            "Add Caller",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle,
            R.drawable.videocam,
            "Video On/Off",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle,
            R.drawable.people,
            "Contacts",
            Color.White,
            Color.White
        ),
        IconItem(
            R.drawable.circle_fill,
            R.drawable.call_end,
            "End Call",
            Color.Red,
            Color.White
        ),
    )

    // Start timer to simulate a call
    LaunchedEffect(Unit) {
        while(true) {
            delay(1.seconds)
            if(seconds < 60){
                seconds ++
            }
            else if (seconds == 60){
                seconds = 0
                minutes++
            }
        }
    }

    // Display call simulator screen
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ){
        // Back Button
        // If back button is selected stop playing the conversation
        // Return to Saved Conversations Screen
        IconButton(onClick = {
            sampleAudio.stop()
            navController.popBackStack()
        }) {
            // Back Icon
            Icon(
                Icons.Filled.ArrowBack,
                "Back Button",
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(30.dp),
                tint = Color.White
            )
        }

        // Display name associated with the conversation
        if (name != null) {
            Text(
                text = name,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp),
                textAlign = TextAlign.Center,
                fontSize = 50.sp
            )
        }

        var time =if(seconds < 10){
            //Display Eg, 00:01
            "$minutes:0$seconds"
        }else{
            // Display Eg, 00:10
            "$minutes:$seconds"
        }

        // Display time of conversation
        Text(
            text = time,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 40.dp),
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )

        // Display rows of icons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 0..2){
                DisplayIcon(item = iconsList[i], modifier = Modifier)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            for (i in 3..5){
                DisplayIcon(item = iconsList[i], modifier = Modifier)
            }
        }

        // Display Hangup button
        Box( modifier = Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
            contentAlignment = Alignment.Center
        ){
            // Outer Circle
            Icon(
                painter = painterResource(id = iconsList[6].layer1),
                contentDescription = "Circle",
                modifier = Modifier.size(100.dp),
                tint = iconsList[6].tint1
            )

            // Inner Icon
            Icon(
                painter = painterResource(id = iconsList[6].layer2),
                contentDescription = iconsList[6].description,
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(60.dp)
                    //On Click Stop Conversation and Return to Saved Conversations Screen
                    .clickable {
                        sampleAudio.stop()
                        navController.popBackStack()
                    },
                tint = iconsList[6].tint2
            )
        }

        Text(
            text = "Emergency Contact",
            style = TextStyle(textDecoration = TextDecoration.Underline),
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    Navigate(navController = navController, route = "call_contact")
                },
            textAlign = TextAlign.End,
            color = Color.White
        )
    }
    //On Click Stop Conversation and Return to Saved Conversations Screen
    BackHandler() {
        sampleAudio.stop()
        navController.popBackStack()
    }
}

//Display Layered Icon
@Composable
fun DisplayIcon(item: IconItem, modifier: Modifier) {
    Box(modifier, contentAlignment = Alignment.Center){
        // Outer Circle
        Icon(
            painter = painterResource(id = item.layer1),
            contentDescription = "Circle",
            modifier = Modifier.size(100.dp),
            tint = item.tint1
        )

        // Inner Icon
        Icon(
            painter = painterResource(id = item.layer2),
            contentDescription = item.description,
            modifier = Modifier
                .align(Alignment.Center)
                .size(60.dp),
            tint = item.tint2
        )
    }

}