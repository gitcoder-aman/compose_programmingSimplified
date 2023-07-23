package com.tech.composelearn.sharedViewModel

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.composelearn.sharedViewModel.viewmodel.SharedViewModel

@Composable
fun ScreenNavigation() {
    val navHostController = rememberNavController()

    val viewModel:SharedViewModel = viewModel()

    NavHost(navController = navHostController, startDestination = FIRST_SCREEN){
        composable(FIRST_SCREEN){
            First_Screen(navHostController,viewModel)
        }
        composable(SECOND_SCREEN){
            Second_Screen(viewModel)
        }
    }
}

const val FIRST_SCREEN = "FIRST_SCREEN"
const val SECOND_SCREEN = "SECOND_SCREEN"