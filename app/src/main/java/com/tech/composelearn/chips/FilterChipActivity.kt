package com.tech.composelearn.chips

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import com.tech.composelearn.ui.theme.Purple80
import com.tech.composelearn.ui.theme.PurpleGrey40

class FilterChipActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                FilterChipLayout()
            }
        }
    }
}

@Composable
@Preview
fun FilterChipLayout() {
    val list by remember{
        mutableStateOf(listOf(
            "Chip 1",
            "Chip 2",
            "Chip 3",
            "Chip 4",
            "Chip 5",
        ))
    }
    val tempList:Set<Int> = emptySet()
    Box(modifier = Modifier.fillMaxSize().background(Color.White), contentAlignment = Alignment.Center){
        ChipEachRow(list = list, tempList = tempList)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChipEachRow(list: List<String>, tempList: Set<Int>) {

    var multipleChecked by rememberSaveable {
        mutableStateOf(tempList)
    }

    FlowRow(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        crossAxisSpacing = 16.dp,
        mainAxisSpacing = 16.dp
    ) {
        list.forEachIndexed { index, s ->
            FilterChip(
                selected = multipleChecked.contains(index),
                onClick = {
                    multipleChecked =
                        if (multipleChecked.contains(index)) multipleChecked.minus(index)
                        else multipleChecked.plus(index)
                },
                label = {
                    Text(text = s)
                }, border = FilterChipDefaults.filterChipBorder(
                    borderColor = if (multipleChecked.contains(index)) PurpleGrey40 else Color.Black,
                    borderWidth = if (multipleChecked.contains(index)) 0.dp else 2.dp
                ), colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (multipleChecked.contains(index)) Purple80 else Color.Transparent
                ), shape = RoundedCornerShape(8.dp),trailingIcon = {
                    if (multipleChecked.contains(index)) {
                        Icon(Icons.Default.Check, contentDescription = "")
                    } else null
                }
            )
        }
    }
}