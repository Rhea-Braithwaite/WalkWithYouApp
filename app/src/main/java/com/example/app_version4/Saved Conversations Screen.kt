package com.example.app_version4

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


//Display List of Saved Conversations for the Call Simulator
@Composable
fun CallsListScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Header()
        RecordingList(
            navController = navController,
            recordings = listOf(
                CallItem(
                    title = "Catching up with Friend",
                    caller = "Gibi",
                    length = "20:16",
                    R.raw.facetime,
                    1
                ),
                CallItem(
                    title = "Talking with Boyfriend",
                    caller = "Doctor's Office",
                    length = "5:14",
                    R.raw.talk_boyfriend,
                    2

                ),
                CallItem(
                    title = "Talking with Upset Friend",
                    caller = "Coco",
                    length = "16:43",
                    R.raw.upset_call,
                    3
                )
            )
        )
    }
}

//Display Heading: Title & Length of Conversations
@Composable
fun Header(
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp, start = 15.dp, end = 15.dp)
            .background(Color.LightGray)
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "TITLE",
            modifier = Modifier.padding(start = 13.dp, top = 15.dp, bottom = 15.dp)
        )
        Text(
            text = "LENGTH",
            modifier = Modifier.padding(end = 13.dp, top = 15.dp, bottom = 15.dp),
        )
    }

}

//List of Saved Connversations
@Composable
fun RecordingList(
    recordings: List<CallItem>,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var shouldPlay by remember {
        mutableStateOf(false)
    }

    var check by remember {
        mutableStateOf(
            CallItem(
                title = "",
                caller = "",
                length = "",
                sound = R.raw.facetime,
                marker = 0
            )
        )
    }

    // Display List with Title and Length of Each Conversation
    // If a recording is selected highlight it
    Box(modifier){
        LazyColumn(Modifier.fillMaxWidth()) {
            items(recordings) { record ->
                RecordListItem(
                    record = record,
                    selected = record.marker == check.marker,
                    onItemClick = {
                        shouldPlay = true
                        // Update the selected item if the user clicks another recording
                        check = it
                    }
                )
            }
        }
    }
    // If a recording is selected, Play Button becomes Visible
    if(shouldPlay){
        // If Play Button is clicked, navigate to call simulator screen
        IconButton(
            onClick = {
                Navigate(navController = navController, route = "call_screen/" + check.caller + "/" + check.sound.toString())
            }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.play_circle),
                contentDescription = "Play/Pause Button",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .size(110.dp),
                tint = Color.Black
            )
        }

    }
}
// Display Recorded Conversation Highlighted or Not
@Composable
fun RecordListItem(
    record: CallItem,
    selected: Boolean,
    onItemClick: (CallItem) -> Unit
) {

    //Determine background color: clicked -> light blue, not clicked -> transparent

    val background = if(selected) R.color.purple_200 else android.R.color.transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.5.dp)
            .clickable {
                onItemClick(record)
            }
            .background(colorResource(id = background))
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Conversation Title
        Text(
            text = record.title,
            modifier = Modifier.padding(start = 15.dp, top = 10.dp, bottom = 10.dp, end = 15.dp)
        )
        // Conversation Length
        Text(
            text = record.length,
            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp, end = 20.dp)
        )
    }
}