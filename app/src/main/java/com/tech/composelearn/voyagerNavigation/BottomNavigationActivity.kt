package com.tech.composelearn.voyagerNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class BottomNavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme() {
                Surface {
                    TabNavigator(tab = HomeTab) {
                        Scaffold(bottomBar = {
                            BottomNavigation(
                                backgroundColor = Color.Red, contentColor = Color.White
                            ) {
                                TabNavigationItem(tab = HomeTab)
                                TabNavigationItem(tab = ProfileTab)
                                TabNavigationItem(tab = AddTab)
                            }
                        }) {
                            Modifier.padding(it)
                            CurrentTab()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    BottomNavigationItem(selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = { Icon(tab.options.icon!!, contentDescription = tab.options.title) })
}

object HomeTab : Tab {

    override val options: TabOptions
        @Composable get() {

            val title = "Home"
            val icon = rememberVectorPainter(image = Icons.Default.Home)
            return remember {
                TabOptions(
                    0u, title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Home")
    }
}

object AddTab : Tab {

    override val options: TabOptions
        @Composable get() {
            val title = "Add"
            val icon = rememberVectorPainter(image = Icons.Default.AddCircle)
            return remember {
                TabOptions(
                    2u, title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Add")
    }

}

object ProfileTab : Tab {
    override val options: TabOptions
        @Composable get() {
            val title = "Profile"
            val icon = rememberVectorPainter(image = Icons.Default.Person)

            return remember {
                TabOptions(
                    1u, title, icon
                )
            }
        }

    @Composable
    override fun Content() {
        Text(text = "Profile")
    }

}