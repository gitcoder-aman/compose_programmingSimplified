package com.tech.composelearn

import android.graphics.Outline
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StateActivity : ComponentActivity() {

    private val viewModel : StateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    ShowWidget()
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ShowWidget(){

        val name = rememberSaveable{ mutableStateOf("") }  //configuration change data no loss in rememberSaveable rather than remember.

        Column(modifier = Modifier.padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "demo")
//            if(name.value.isNotEmpty()){
            if(viewModel.name.value.isNotEmpty()){
                Text(text = viewModel.name.value, color = Color.Green)
            }
            OutlinedTextField(value = name.value, onValueChange = {
                name.value = it
            }, label = {
                Text(text = "Name")
            })
        }
    }
}