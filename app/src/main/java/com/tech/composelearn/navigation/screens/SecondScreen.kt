package com.tech.composelearn.navigation.screens

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.tech.composelearn.navigation.AnotherActivity
import com.tech.composelearn.navigation.util.NavigationScreen

@Composable
fun SecondScreen(context: Activity,navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = {
//            val intent = Intent(context, AnotherActivity::class.java).apply {
//                putExtra("String", "Value")
//            }
//            context.startActivity(intent)

            //Back stack Manage
            navHostController.navigate(NavigationScreen.ThirdScreen.route){
                launchSingleTop = true  // only one create unique stack
//                popUpTo(NavigationScreen.FirstScreen.route){
//                    inclusive = true  // all destroy the backstack
//                }
            }
        }) {
            Text(text = "Go to Another Activity.")

            Text(text = "Second Screen")
        }
    }
}