package com.tech.composelearn

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme {
                MyToolbar()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun MyToolbar() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Demo App")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, contentDescription = "menu")
                    }
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Filled.Notifications,
                            contentDescription = "notification"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Search, contentDescription = "search")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Add, contentDescription = "add")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) {
        Modifier.padding(it)
        ShowSwitch()
    }
}

@Composable
fun ShowSwitch(){
    val isChecked = remember {
        mutableStateOf(true)
    }
    Switch(checked = isChecked.value, onCheckedChange = {
        isChecked.value = it
    },
        modifier = Modifier.run{
            size(20.dp)
            padding(100.dp)
        })

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center
    )
}

//@Preview(showBackground = true, name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)

@Composable
fun GreetingPreview() {
    ComposeLearnTheme {
        Greeting("Android")
    }
}
//ViewPager

