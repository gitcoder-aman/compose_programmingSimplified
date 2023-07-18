package com.tech.composelearn.navigationDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.List
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.tech.composelearn.R
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import kotlinx.coroutines.launch

class DrawerActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                Surface {
                    val scaffoldState = rememberScaffoldState()
                    val scope = rememberCoroutineScope()   // side effect in jetpack coroutine

                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Column() {
                                IconButton(onClick = {
                                    scope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }) {
                                    Icon(
                                        Icons.Default.Close,
                                        contentDescription = "",
                                        tint = Color.Blue
                                    )
                                }
                                Text(text = "Drawer Content")
                                Image(
                                    painterResource(id = R.drawable.compose),
                                    contentDescription = "image",
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .background(Color.Blue)
                                )
                            }
                        }, drawerGesturesEnabled = false
                    ) {
                        CreateDrawer(scaffoldState)
                        Modifier.padding(it)
                    }
                }
            }
        }
    }
}

@Composable
fun CreateDrawer(scaffoldState: ScaffoldState) {

    val scope = rememberCoroutineScope()
    IconButton(onClick = {
        scope.launch {
            scaffoldState.drawerState.open()
        }
    }) {
        Icon(Icons.Default.List, contentDescription = "", tint = Color.Blue)
    }
}