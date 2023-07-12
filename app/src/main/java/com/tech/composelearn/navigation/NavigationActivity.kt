package com.tech.composelearn.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.tech.composelearn.navigation.navigation.StartNavigation
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class NavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContent { 
            ComposeLearnTheme() {
                Surface {
                    StartNavigation(context = this)
                }
            }
        }
    }
}