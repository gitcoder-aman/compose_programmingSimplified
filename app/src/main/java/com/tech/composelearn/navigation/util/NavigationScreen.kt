package com.tech.composelearn.navigation.util

sealed class NavigationScreen(val route : String) {


    //define a unique name for identify the NavHost Controller
    object FirstScreen : NavigationScreen("firstScreen")
    object SecondScreen : NavigationScreen("secondScreen")
}