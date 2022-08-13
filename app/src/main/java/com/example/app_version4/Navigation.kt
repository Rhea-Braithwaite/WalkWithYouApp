package com.example.app_version4

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavGraph(
    navController: NavHostController,
    firstContactViewModel: ContactViewModel = viewModel(),
    secondContactViewModel: ContactViewModel = viewModel(),
) {

    val messageViewModel = viewModel<MessageViewModel>()

    val locationViewModel = viewModel<LocationViewModel>()

    NavHost(navController, startDestination = NavDrawerItem.Home.route) {


        composable(
            NavDrawerItem.Home.route
        ) {
            HomeScreen(
                navController = navController,
                locationViewModel = locationViewModel
            )
        }

        // Skills Navigation
        composable(
            NavDrawerItem.Skills.route
        ) {
            SkillsGuideScreen(navController = navController)
        }
        composable(route = "to_bring"){
            ToBring(navController = navController)
        }
        composable(route = "video_demo"){
            VideoDemosScreen(navController = navController)
        }
        composable(route = "self_defense"){
            SelfDefense(navController = navController)
        }
        composable(route = "night_tips"){
            NightTipsScreen(navController = navController)
        }

        // Edit Contact Navigation
        composable(
            NavDrawerItem.EditContact.route
        ) {
            EditGuideScreen(navController = navController)
        }

        composable(
            route = "edit_contact",
        ){
            EditContactScreen(
                firstContactViewModel = firstContactViewModel,
                secondContactViewModel = secondContactViewModel,
                navController = navController
            )
        }
        composable("edit_message"){
            EditMessageScreen(
                navController = navController,
                messageViewModel = messageViewModel
            )
        }

        composable(
            NavDrawerItem.CallSim.route
        ) {
            CallsListScreen(navController = navController)
        }
        composable(
            route = "call_screen/{name}/{song}",
            arguments = listOf(
                navArgument("name"){
                    type = NavType.StringType
                    defaultValue = "HOME"
                    nullable = false
                },
                navArgument("song"){
                    type = NavType.IntType
                    defaultValue = R.raw.facetime
                    nullable = false
                }
            )
        ){entry ->
            CallScreen(navController = navController, name = entry.arguments?.getString("name"), song = entry.arguments?.getInt("song"))
        }

        composable(
            NavDrawerItem.AboutUs.route
        ) {
//            AboutUsScreen()
        }
        composable(
            "call_contact"
        ) {
            CallContactScreen(
                firstContactViewModel = firstContactViewModel,
                secondContactViewModel = secondContactViewModel
            )
        }



    }
}


fun Navigate(navController: NavController, route: String){
    navController.navigate(route){
        popUpTo(route){
            saveState = true
            inclusive = true
        }

        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}


// Return Title of Screen Based on Route
fun getTitleByRoute(route:String): String {
    return when (route) {
        NavDrawerItem.Skills.route, "to_bring", "video_demo", "self_defense","night_tips"   -> "SKILLS"

        NavDrawerItem.EditContact.route -> "EDIT CONTACT"
        "edit_contact" -> "CONTACT DETAILS"
        "edit_message" -> "MESSAGE DETAILS"

        NavDrawerItem.CallSim.route -> "SAVED CONVERSATIONS"
        NavDrawerItem.AboutUs.route -> "ABOUT US"
        "call_contact" -> "CALL CONTACT"
        // other cases
        else -> "HOME"
    }
}
