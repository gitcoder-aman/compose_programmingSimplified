package com.tech.composelearn.sharedViewModel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class SharedViewModelActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                ScreenNavigation()
            }
        }
    }
}