package com.tech.composelearn.customToggleBtn

import android.os.Bundle
import android.widget.ToggleButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.composelearn.R
import com.tech.composelearn.ui.theme.ComposeLearnTheme

class CustomToggleBtnActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                CustomToggleBtnCreate()
            }
        }
    }
}

@Composable
@Preview
fun CustomToggleBtnCreate() {
    var isToggle by remember {
        mutableStateOf(false)
    }

    Box(contentAlignment = Center) {
        Card(
            shape = RoundedCornerShape(39.dp),
            elevation = CardDefaults.cardElevation(0.dp), modifier = Modifier.padding(5.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(if (isToggle) Color.Green else Color.Black)
                    .clickable {
                        isToggle = !isToggle
                    },
                contentAlignment = Alignment.Center
            ) {
                if (isToggle) {
                    Row(modifier = Modifier.padding(5.dp)) {
                        Text(
                            text = "On",
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W400),
                            color = Color.White,
                            modifier = Modifier
                                .align(CenterVertically)
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_power_settings_new_24),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                } else {
                    Row(modifier = Modifier.padding(5.dp)) {

                        Icon(
                            painter = painterResource(id = R.drawable.baseline_power_settings_new_24),
                            contentDescription = "",
                            tint = Color.Unspecified,
                            modifier = Modifier.padding(end = 3.dp)
                        )
                        Text(
                            text = "Off",
                            style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.W400),
                            color = Color.White,
                            modifier = Modifier
                                .align(CenterVertically)
                        )
                    }
                }
            }
        }
    }

}