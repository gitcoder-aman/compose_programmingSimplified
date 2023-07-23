package com.tech.composelearn.pizzaProject.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tech.composelearn.R
import com.tech.composelearn.pizzaProject.common.AppIconButton
import com.tech.composelearn.pizzaProject.data.Pizza
import com.tech.composelearn.pizzaProject.data.pizzaList
import com.tech.composelearn.ui.theme.BackgroundColor
import com.tech.composelearn.ui.theme.DarkBlackColor
import com.tech.composelearn.ui.theme.LightGrayColor
import com.tech.composelearn.ui.theme.OrangeColor
import com.tech.composelearn.ui.theme.RedColor
import com.tech.composelearn.ui.theme.YellowColor

@Composable
@Preview
fun HomeScreen() {

    val menuList =
        listOf("Starter", "Asian", "Placha & Roast & Grill", "Classic", "Indian", "Italian")
    var currentMenuState by remember { mutableStateOf("Starter") }

    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ) {
        Column {
            PizzaHeader()
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(scrollState)
                ) {
                    menuList.forEach {
                        CustomChip(
                            title = it,
                            selected = it == currentMenuState,
                            onValueChange = { data ->
                                currentMenuState = data
                            })
                    }
                }
            }
            //card view attached in recycler
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(pizzaList) {
                    ShowPizza(pizza = it)
                }
            }
        }
        ExtendedActionButton(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 30.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun PizzaHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(OrangeColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                AppIconButton(icon = R.drawable.menu)
                SpacerWidth(10.dp)
                Text(
                    text = "Pizza Hut", style = TextStyle(
                        fontSize = 19.sp,
                        fontWeight = FontWeight.W600,
                        color = Color.White
                    )
                )
            }
            AppIconButton(icon = R.drawable.search)
        }
    }
}

@Composable
fun CustomChip(title: String, selected: Boolean, onValueChange: (String) -> Unit) {
    TextButton(
        onClick = {
            onValueChange(title)
        },
        shape = RoundedCornerShape(200.dp),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if (selected) YellowColor else Color.Transparent),
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.W600,
                color = if (selected) Color.White else Color.Black
            )
        )
    }
}

@Composable
fun ShowPizza(          //Pizza card view
    pizza: Pizza
) {
    Card(
        modifier = Modifier
            .width(175.dp)
            .padding(5.dp), shape = RoundedCornerShape(5.dp)
    ) {

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pizza),
                    contentDescription = "",
                    modifier = Modifier.size(109.dp)
                )
                SpacerHeight()
                Text(
                    text = pizza.price, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W300,
                        color = RedColor
                    ), textAlign = TextAlign.Center
                )
                SpacerHeight()
                Text(
                    text = pizza.name, style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.W600,
                        color = DarkBlackColor
                    ), textAlign = TextAlign.Center
                )
                SpacerHeight()
                Text(
                    text = pizza.description, style = TextStyle(
                        fontSize = 10.sp,
                        fontWeight = FontWeight.W300,
                        color = LightGrayColor
                    ), textAlign = TextAlign.Center
                )
                SpacerHeight()
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.width(91.dp),
                    shape = RoundedCornerShape(18.dp),
                    colors = ButtonDefaults.buttonColors(YellowColor)
                ) {
                    Text(
                        text = "Add", style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight.W600,
                            color = Color.White
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun ExtendedActionButton(modifier: Modifier) {
    Box(
        modifier = modifier
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp))
            .background(DarkBlackColor), contentAlignment = Center
    ) {
        Row {
            SpacerWidth(20.dp)
            Text(
                text = "$10.04",
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W600,
                    color = Color.White
                ), modifier = Modifier.align(CenterVertically)
            )
            Icon(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
                    .padding(2.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
fun SpacerWidth(width: Dp = 5.dp) {
    Spacer(modifier = Modifier.width(width))
}

@Composable
fun SpacerHeight(height: Dp = 5.dp) {
    Spacer(modifier = Modifier.height(height))
}