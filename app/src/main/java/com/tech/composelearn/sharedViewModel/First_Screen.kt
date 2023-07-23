package com.tech.composelearn.sharedViewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.tech.composelearn.sharedViewModel.viewmodel.SharedViewModel

@Composable
fun First_Screen(navHostController: NavHostController,viewModel:SharedViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Button(onClick = {
            viewModel.setData("Hello how are you")
            navHostController.navigate(SECOND_SCREEN)
        }) {
            Text(text = "Send Data", color = Color.White)
        }
    }
}