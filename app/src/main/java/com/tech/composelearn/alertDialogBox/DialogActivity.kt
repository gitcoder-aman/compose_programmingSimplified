package com.tech.composelearn.alertDialogBox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class DialogActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
//                DialogScreen()
                Scaffold(topBar = { TopAppBar(title = { Text(text = "Dialog")})
                    AlertDialogScreen()
                }) {
                    Modifier.padding(it)
                }
            }
        }
    }
}

@Composable
//@Preview
fun DialogScreen() {

    var isDialog by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "Click here.")
        }
    }
    if (isDialog) {
        Dialog(onDismissRequest = {
            isDialog = false
        }) {
            CircularProgressIndicator()
        }
    }
}

@Composable
@Preview
fun AlertDialogScreen() {

    var isDialog by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            isDialog = true
        }) {
            Text(text = "Click Here.")
        }
        if (isDialog) {
            AlertDialog(onDismissRequest = { }, title = {
                Text(text = "Dialog Box")
            }, text = { Text(text = "This is Dialog Box") }, modifier = Modifier.fillMaxWidth(),
                confirmButton = {
                    Button(onClick = {
                        isDialog = false
                    }) {
                        Text("Ok")
                    }
                }, dismissButton = {
                    Button(onClick = {isDialog = false}) {
                        Text(text = "Cancel")
                    }
                })
        }

    } //Column closed
}