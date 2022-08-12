package com.example.app_version4

import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel


data class HomeScreenOption(
    val title: String,
    @DrawableRes val iconId: Int,
    val route: String
)

data class CallButtonItem(
    val title: String,
    val buttonColor: Color,
    val route: String,
    val num: Int
)

sealed class NavDrawerItem(
    var route: String,
    var icon: Int,
    var title: String
){
    object Home : NavDrawerItem("home_screen", R.drawable.home, "Home")
    object Skills : NavDrawerItem("skills", R.drawable.build, "Skills")
    object EditContact : NavDrawerItem("edit_contact_screen", R.drawable.contacts, "Edit Contact")
    object CallSim : NavDrawerItem("call_simulator_screen", R.drawable.call, "Call Simulator")
    object AboutUs : NavDrawerItem("about_us_screen", R.drawable.info, "About Us")
}

data class CallItem(
    val title: String,
    val caller: String,
    val length: String,
    @RawRes val sound: Int,
    val marker: Int
)

data class IconItem(
    @DrawableRes val layer1: Int,
    @DrawableRes val layer2: Int,
    val description: String,
    val tint1: Color,
    val tint2: Color
)

sealed class ContactItem(
    var name: String,
    var phone: String,
    var email: String
)


class ContactViewModel: ViewModel(){

    var name by mutableStateOf("")
    var phone by mutableStateOf("")
    var email by mutableStateOf("")

    fun onNameChange(newName: String){
        name = newName
    }

    fun onPhoneChange(newPhone: String){
        phone = newPhone
    }

    fun onEmailChange(newEmail: String){
        email = newEmail
    }
}

class MessageViewModel: ViewModel(){
    var message by mutableStateOf("")

    fun onMessageChange(newMessage: String){
        message = newMessage
    }
}


class LocationViewModel: ViewModel(){
    var location by mutableStateOf("")

    fun onLocationChange(newLocation: String){
        location = newLocation
    }
}
