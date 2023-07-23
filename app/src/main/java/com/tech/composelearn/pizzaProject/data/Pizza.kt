package com.tech.composelearn.pizzaProject.data

import androidx.annotation.DrawableRes
import com.tech.composelearn.R

data class Pizza(
    @DrawableRes val image: Int,
    val name: String,
    val description: String,
    val price: String
)
val pizzaList = listOf(
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ) ,
    Pizza(
        R.drawable.pizza,
        "Peppy Panner",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    ),
    Pizza(
        R.drawable.pizza,
        "Fresh Farm House",
        "crisp capsicum, succulent,mushrooms and fresh tomato.",
        "$12"
    )
)