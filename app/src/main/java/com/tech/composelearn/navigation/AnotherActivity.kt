package com.tech.composelearn.navigation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class AnotherActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme() {
                Surface() {
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Yellow)) {

                        Text(text = "Another Activity Launched")

                    }
                }
            }
        }
    }
}