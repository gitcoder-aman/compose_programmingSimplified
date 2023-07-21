package com.tech.composelearn.suggestionchips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import com.tech.composelearn.ui.theme.Purple80
import com.tech.composelearn.ui.theme.PurpleGrey40

class SuggestionChipActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                SuggestionChipLayout()
            }
        }
    }
}

@Composable
fun SuggestionChipLayout() {
    val chipsData by remember {
        mutableStateOf(listOf("India", "France", "Spain"))
    }
    var chipState by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            chipsData.forEach {
                SuggestionChipEachRow(label = it, isSelected = (it == chipState)) { chip ->
                    chipState = chip
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuggestionChipEachRow(label: String, isSelected: Boolean, onChipChange: (String) -> Unit) {
    SuggestionChip(
        onClick = {
            if (!isSelected) {
                onChipChange(label)
            } else {
                onChipChange("")
            }
        },
        label = {
            Text(text = label, color = Color.Black)
        },
        //modifier = Modifier.padding(horizontal = 10.dp),
        shape = RoundedCornerShape(8.dp),
        colors = SuggestionChipDefaults.suggestionChipColors(
            containerColor = if (isSelected) Purple80 else Color.Transparent
        ),
        border = SuggestionChipDefaults.suggestionChipBorder(
            borderWidth = 1.dp,
            borderColor = if (isSelected) Color.Transparent else PurpleGrey40
        )
    )
}