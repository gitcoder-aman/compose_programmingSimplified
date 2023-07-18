package com.tech.composelearn.radioBtn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonColors
import androidx.compose.material.Card
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class RadioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
//                RadioBtnUI()
//                CheckBoxUI()
                Button()
            }
        }
    }
}

@Composable
fun RadioBtnUI() {

    val genderList by remember {
        mutableStateOf(listOf("Male", "Female", "Others"))
    }
    var genderState by remember {
        mutableStateOf(listOf(""))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = CenterVertically
        ) {
            genderList.forEach {
                Row {
                    Text(text = it, modifier = Modifier.align(CenterVertically))
                    RadioButton(selected = genderState == listOf(it), onClick = {
                        genderState = listOf(it)
                    }, colors = RadioButtonDefaults.colors(selectedColor = Color.Yellow))
                }
            }
        }
        Text(text = listOf(genderState).toString())
    }

}

@Composable
fun CheckBoxUI() {

    var isChecked by remember {
        mutableStateOf(false)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Checkbox(
            checked = isChecked, onCheckedChange = {
                isChecked = it
            }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Black
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        CustomCheckBox()
    }
}

@Composable
fun CustomCheckBox() {

    var isCheck by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Card(
            elevation = 0.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            border = BorderStroke(1.dp, Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .background(if (isCheck) Color.Green else Color.White)
                    .clickable { isCheck = !isCheck }
                    .size(25.dp), contentAlignment = Center
            ) {
                if (isCheck)
                    Icon(Icons.Default.Check, contentDescription = "", tint = Color.White)
            }
        }
        Text(
            text = "Accept All terms and Conditions",
            modifier = Modifier
                .padding(start = 5.dp)
                .align(CenterVertically)
        )
    }
}

@Composable
@Preview
fun Button() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        androidx.compose.material3.Button(
            onClick = { /*TODO*/ },
            elevation = ButtonDefaults.buttonElevation(pressedElevation = 10.dp),
            shape = CutCornerShape(10.dp),
            border = BorderStroke(2.dp, Color.Blue),
            colors = ButtonDefaults.buttonColors(Color.Yellow),

            ) {
            Text(text = "Button", color = Color.Black)
        }

        TextButton(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Text Button")
        }

        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Red)
        ) {
            Text(text = "OutLined Button")
        }
    }
}