package com.tech.composelearn.pizzaProject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tech.composelearn.pizzaProject.screens.HomeScreen
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                HomeScreen()
            }
        }
    }
}