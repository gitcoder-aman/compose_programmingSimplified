package com.tech.composelearn.navigation.util

sealed class NavigationScreen(val route : String) {


    //define a unique name for identify the NavHost Controller
    object FirstScreen : NavigationScreen("firstScreen")
    object SecondScreen : NavigationScreen("{data}/secondScreen"){    //data catch when data pass from another activity
        fun createRoute(data:String) = "$data/secondScreen"
    }
    object ThirdScreen : NavigationScreen("thirdScreen")
}