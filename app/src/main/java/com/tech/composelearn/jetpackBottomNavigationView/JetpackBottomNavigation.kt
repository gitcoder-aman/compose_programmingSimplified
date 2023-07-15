package com.tech.composelearn.jetpackBottomNavigationView

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class JetpackBottomNavigation : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun Home() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home")
    }
}

@Composable
fun Notification() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Notification")
        }
    }
}

@Composable
fun Setting() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Setting")
        }
    }
}

@Composable
fun Accounts() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Accounts")
        }
    }
}
@Composable
fun NavigationController(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = NavigationItems.Home.route) {
        composable(NavigationItems.Home.route) {
            Home()
        }
        composable(NavigationItems.Notification.route) {
            Notification()
        }
        composable(NavigationItems.Setting.route) {
            Setting()
        }
        composable(NavigationItems.Account.route) {
            Accounts()
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val items = listOf(
        NavigationItems.Home,
        NavigationItems.Setting,
        NavigationItems.Notification,
        NavigationItems.Account
    )

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "BottomNavigation View") },backgroundColor = Color.Cyan)
    }, bottomBar = {
        BottomNavigation(backgroundColor = MaterialTheme.colors.background) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.forEach {
                BottomNavigationItem(
                    selected = currentRoute == it.route,
                    label = {
                        Text(
                            text = it.lable,
                            color = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                        )
                    },
                    icon = {
                        Icon(
                            imageVector = it.icons,
                            contentDescription = null,
                            tint = if (currentRoute == it.route) Color.DarkGray else Color.LightGray
                        )
                    },
                    onClick = {
                        if (currentRoute != it.route) {
                            navController.graph.startDestinationRoute.let {
                                navController.popBackStack(it!!, true)
                            }

                            navController.navigate(it.route) {
                                launchSingleTop = true
                            }
                        }
                    })
            }
        }

    }) {
        Modifier.padding(it)
        NavigationController(navHostController = navController)
    }
}
