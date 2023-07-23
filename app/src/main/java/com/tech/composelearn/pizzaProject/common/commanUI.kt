package com.tech.composelearn.pizzaProject.common

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppIconButton(
    @DrawableRes icon: Int,
    tintColor: Color = Color.Unspecified,
    modifier: Modifier = Modifier,
    onClick:()->Unit = {}
) {
    IconButton(onClick = { /*TODO*/ }, modifier = Modifier.size(28.dp)) {
        Icon(painter = painterResource(id = icon), contentDescription = "", tint = tintColor)
    }
}