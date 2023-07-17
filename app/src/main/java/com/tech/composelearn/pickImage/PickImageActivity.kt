package com.tech.composelearn.pickImage

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import kotlinx.coroutines.launch

class PickImageActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
//                PickImageFromGallery()
                PickImageFromCamera()
                val scaffoldState = rememberScaffoldState()
                androidx.compose.material.Scaffold(scaffoldState = scaffoldState) {

                    CreateSnackBar(scaffoldState)
                    Modifier.padding(it)
                }
            }
        }
    }
}

@Composable
//@Preview
fun PickImageFromGallery() {
    val context = LocalContext.current

    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent(),
            onResult = {
                imageUri = it
            })
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            launcher.launch("image/*")
        }) {
            Text(text = "Pick Image from Gallery.")
        }
        Spacer(modifier = Modifier.height(20.dp))

        imageUri?.let {
            bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(context.contentResolver, it)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, it)
                ImageDecoder.decodeBitmap(source)
            }
            Image(
                bitmap = bitmap?.asImageBitmap()!!,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Color.Cyan
                    )
            )
        }
    }
}

@Composable
//@Preview
fun PickImageFromCamera() {
    var bitmap by remember {
        mutableStateOf<Bitmap?>(null)
    }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview(),
        onResult = {
            bitmap = it
        })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Button(onClick = { launcher.launch() }) {
            Text(text = "Pick Image from Camera")
        }

        Spacer(modifier = Modifier.height(20.dp))

        bitmap?.let {
            Image(
                bitmap = bitmap?.asImageBitmap()!!,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun CreateSnackBar(scaffoldState: ScaffoldState) {

    val scope = rememberCoroutineScope() //here is used sideEffect of Coroutine jetpack
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = {
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Image Selected")
            }
        }) {
            Text(text = "Show SnackBar")
        }
    }
}
