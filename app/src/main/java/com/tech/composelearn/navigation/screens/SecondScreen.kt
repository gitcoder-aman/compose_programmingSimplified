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
import com.tech.composelearn.navigation.AnotherActivity

@Composable
fun SecondScreen(context: Activity) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = {
            val intent = Intent(context, AnotherActivity::class.java).apply {
                putExtra("String", "Value")
            }
            context.startActivity(intent)
        }) {
            Text(text = "Go to Another Activity.")

            Text(text = "Second Screen")
        }
    }
}