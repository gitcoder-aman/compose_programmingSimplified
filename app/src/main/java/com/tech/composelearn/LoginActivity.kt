package com.tech.composelearn

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLearnTheme() {
                Surface(color = MaterialTheme.colorScheme.background) {
                    LoginScreen()
                }
            }
        }
    }

    private fun logged(username: String, password: String) {
        if (username == "jks" && password == "1234") {
            Toast.makeText(this, "logged in", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong Credential", Toast.LENGTH_SHORT).show()
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview
    fun LoginScreen() {

        val userName = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }

        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Hello Again!", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )

            Text(
                text = "Welcome", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )

            Text(
                text = "Back", color = Color.Blue, fontSize = 25.sp,
                fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold
            )

            OutlinedTextField(value = userName.value, onValueChange = {
                userName.value = it
            }, leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "person")
            }, label = {
                Text(text = "Username")
            }, placeholder = {
                Text(text = "enter username")
            }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = password.value, onValueChange = {
                password.value = it
            }, leadingIcon = {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_password_24),
                    contentDescription = "password"
                )
            }, label = {
                Text(text = "Password")
            }, placeholder = {
                Text(text = "enter password")
            }, modifier = Modifier.fillMaxWidth())
            OutlinedButton(
                onClick = { logged(userName.value, password.value) }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 10.dp, end = 10.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}