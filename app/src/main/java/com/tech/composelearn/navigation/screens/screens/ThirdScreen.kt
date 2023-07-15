package com.tech.composelearn.navigation.screens.screens

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.TabOptions

data class ThirdScreen(val name : String) : Screen {

    @Composable
    override fun Content() {

        Text(text = "Voyager data $name")
    }
}

