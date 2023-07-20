package com.tech.composelearn.state_hoisting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class StateHosting : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
//                StateFul()
                ParentContent()
            }
        }
    }
}

//Only Parent composable function will keep state in it.
//Any Child Composable function will never keep state in it.
@Composable
fun ParentContent() {

    var name by remember {
        mutableStateOf("")
    }

    ChildContent(name = name) {
        name = it
    }
}

@Composable
fun ChildContent(name: String, onChange: (String) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "hello${name}")

        Spacer(modifier = Modifier.height(20.dp))

        TextField(value = name, onValueChange = {
            onChange(it)
        }, placeholder = { Text(text = "Type Something...") })


    }
}

@Composable
fun StateFul() {
    var name by remember {
        mutableStateOf("")
    }
    TextField(value = name, onValueChange = {
        name = it
    })
}

@Composable
fun Stateless() {
    Text(text = "Hello world")
}