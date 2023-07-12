package com.tech.composelearn.viewpager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class ViewPagerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                Surface {
                    OnBoardingScreen()
                }
            }
        }
    }
}