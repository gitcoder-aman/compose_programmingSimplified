package com.tech.composelearn.navigation.navigation

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.TopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.composelearn.navigation.screens.FirstScreen
import com.tech.composelearn.navigation.screens.SecondScreen
import com.tech.composelearn.navigation.screens.ThirdScreen
import com.tech.composelearn.navigation.util.NavigationScreen

@Composable
fun StartNavigation(context: Activity){

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationScreen.FirstScreen.route ){
        composable(NavigationScreen.FirstScreen.route){
            FirstScreen(navController)
        }
        composable(NavigationScreen.SecondScreen.route){
            val data = it.arguments?.getString("data")

            Toast.makeText(context,data,Toast.LENGTH_LONG).show()

            SecondScreen(context,navController)
        }
        composable(NavigationScreen.ThirdScreen.route){
            ThirdScreen()
        }
    }

}