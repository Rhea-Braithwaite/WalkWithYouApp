package com.example.app_version4

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.app_version4.ui.theme.DarkBlue
import com.example.app_version4.ui.theme.LightBlue

@Composable
fun EditContactScreen(
    firstContactViewModel: ContactViewModel = viewModel(),
    secondContactViewModel: ContactViewModel = viewModel(),
    navController: NavController
) {
    val checkedState = rememberSaveable { mutableStateOf(true) }
    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 32.dp, vertical = 7.5.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        item {
            Row(){
                Text(text = "Send message at the same time",
                    modifier = Modifier.padding(top = 8.dp))
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange ={
                        checkedState.value = it
                    }
                )
            }

        }
        //CallViewModel1
        item {
            EditContactItem(
                contactViewModel = firstContactViewModel,
                contact = "First Contact"
            )

        }
        //CallViewModel2
        item {
            EditContactItem(
                contactViewModel = secondContactViewModel,
                contact = "Second Contact"
            )

        }
        item{

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

}


@Composable
fun EditContactItem(
    contactViewModel: ContactViewModel = viewModel(),
    contact: String
) {
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.padding(top = 7.5.dp)
    ) {
        Text(
            text = contact,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Gray
        )

        EditNumberField(
            title = "name",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = contactViewModel.name,
            onValueChange = { contactViewModel.onNameChange(it) }
        )

        EditNumberField(
            title = "phone number",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            ),
            value = contactViewModel.phone,
            onValueChange = { contactViewModel.onPhoneChange(it) }
        )


        EditNumberField(
            title = "email",
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            value = contactViewModel.email,
            onValueChange = { contactViewModel.onEmailChange(it) }
        )

    }
}

@Composable
fun EditNumberField(
    title: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
){

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(
            text = "Enter a $title",
            modifier = Modifier.padding((5).dp),
            style = MaterialTheme.typography.body1) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
            .drawBehind {
                val strokeWidth = 2 * density
                val y = size.height - strokeWidth / 2
                drawLine(
                    Color.Gray,
                    Offset(48f, y),
                    Offset(size.width - 40f, y),
                    strokeWidth
                )
            }
        ,
        keyboardOptions = keyboardOptions,
        singleLine = true,
        keyboardActions = keyboardActions,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            focusedIndicatorColor =  Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        )
    )
}