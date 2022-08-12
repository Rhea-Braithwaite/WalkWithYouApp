package com.example.app_version4

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app_version4.ui.theme.Blue
import com.example.app_version4.ui.theme.DarkBlue
import com.example.app_version4.ui.theme.LightBlue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


//Define Scaffold
@Composable
fun MainScreenPlusScaffold() {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val scope = rememberCoroutineScope()

    val navController = rememberNavController()

    var topBarTitle by remember{
        mutableStateOf("")
    }

    val firstContactViewModel = viewModel<ContactViewModel>(key = "first")

    val secondContactViewModel = viewModel<ContactViewModel>(key = "second")

    // Map the title of the screen based on the route
    LaunchedEffect(navController) {
        navController.currentBackStackEntryFlow.collect { backStackEntry ->
            topBarTitle = getTitleByRoute(backStackEntry.destination.route.toString())
        }
    }

    CompositionLocalProvider(
        // Have Scaffold on the Right of the Screen
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                if(currentRoute(navController = navController) != "call_screen/{name}/{song}"){
                    TopBar(
                        navController = navController,
                        scope = scope,
                        scaffoldState = scaffoldState,
                        topBarTitle = topBarTitle
                    )
                }

            },
            drawerBackgroundColor = Color.LightGray,
            drawerContent = {
                Drawer(
                    scope = scope,
                    scaffoldState = scaffoldState,
                    navController = navController
                )
            },

            bottomBar = {
                if(
                    currentRoute(navController = navController) != "call_screen/{name}/{song}" &&
                    currentRoute(navController = navController) != "edit_contact" &&
                    currentRoute(navController = navController) != "edit_message"
                ){
                    CallButtonMenu(
                        buttons = listOf(
                            CallButtonItem(
                                title = "Call Contact",
                                buttonColor = Color.Green,
                                route = "call_contact",
                                num = 2
                            ),
                            CallButtonItem(
                                title = "Call Security",
                                buttonColor = Color.Red,
                                route = "",
                                num = 1
                            )
                        ),
                        navController = navController,
                        firstContactPhone = firstContactViewModel.phone
                    )
                }

            }

        ) {
            CompositionLocalProvider(
                // Have Content Display from Left to Right
                LocalLayoutDirection provides LayoutDirection.Ltr
            ) {
                NavGraph(
                    navController = navController,
                    firstContactViewModel = firstContactViewModel,
                    secondContactViewModel = secondContactViewModel
                )
            }

        }
    }
}


//Top Bar with Menu Icon to Open Menu Drawer and Display Title of the Screen
@Composable
fun TopBar(navController: NavController, scope: CoroutineScope, scaffoldState: ScaffoldState, topBarTitle: String) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(LightBlue)
    ){


        Row (){

            // On click open the Menu Drawer
            IconButton(onClick = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }) {
                // Menu Icon
                Icon(
                    Icons.Filled.Menu,
                    "Toggle Drawer",
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .size(30.dp)
                )
            }
            Spacer(Modifier.weight(1f))

            if(currentRoute(navController = navController as NavHostController) != NavDrawerItem.Home.route){
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    // Back Icon
                    Icon(
                        Icons.Filled.ArrowBack,
                        "Back Button",
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .size(30.dp)
                    )
                }

            }
        }


        // Title of Screen
        Text(
            text = topBarTitle,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h2

        )
    }

}

@Composable
fun Drawer(
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavController
) {
    // All Drawer Options
    val items = listOf(
        NavDrawerItem.Home,
        NavDrawerItem.Skills,
        NavDrawerItem.EditContact,
        NavDrawerItem.CallSim,
        NavDrawerItem.AboutUs,
    )
    Column(
        modifier = Modifier.background(Blue)
    ){
        //Header
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = " ",
            modifier = Modifier
                .height(100.dp)
                .fillMaxWidth()
                .padding(10.dp)
        )
        //Space Between
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        )

        //List of Navigation Items and their Icons
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        // Display Each Drawer Item
        items.forEach { item ->
            DrawerItem(
                item = item,
                selected = currentRoute == item.route,
                onItemClick = {
                    // Navigate to route if item is clicked
                    Navigate(navController = navController, route = item.route)

                    // Close drawer
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        // Creators
        Text(
            text = "Developed by Rhea Braithwaite and Jiawen Zhang",
            color = Color.White,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun DrawerItem(
    item: NavDrawerItem,
    selected: Boolean,
    onItemClick: (NavDrawerItem) -> Unit
){
    val background: Color = if (selected) LightBlue else Color.Transparent

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(item) })
            .height(45.dp)
            .background(background)
            .padding(end = 10.dp),
        horizontalArrangement = Arrangement.End
    ){
        // Name of Drawer Item
        Text(
            text = item.title,
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.width(7.dp))

        // Icon for Drawer Item
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.title,
            colorFilter = ColorFilter.tint(Color.White),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
        )
    }
}