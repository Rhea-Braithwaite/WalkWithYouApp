package com.example.app_version4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.app_version4.ui.theme.DarkBlue
import com.example.app_version4.ui.theme.LightBlue

@Composable
fun EditMessageScreen(
    navController: NavController,
    messageViewModel: MessageViewModel
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 7.5.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Edit Message",
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 20.dp)
                .background(Color.White, RoundedCornerShape(5.dp)),
            shape = RoundedCornerShape(5.dp),
            value = messageViewModel.message,
            onValueChange = {
                messageViewModel.onMessageChange(it)
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            maxLines = 3,
            textStyle = MaterialTheme.typography.caption
        )
        OutlinedButton(
            onClick = {
                navController.popBackStack()
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = LightBlue,
            ),
            border = BorderStroke(1.dp, DarkBlue)
        ) {
            Text(text = "Save")
        }

    }
}