package com.tech.composelearn.viewpager

import androidx.annotation.DrawableRes
import com.tech.composelearn.R

data class Pager(
    @DrawableRes val image:Int,
    val des:String
)
val dataList = listOf(
    Pager(R.drawable.page1,"PAGE ONE"),
    Pager(R.drawable.page2,"PAGE TWO"),
    Pager(R.drawable.page3,"PAGE THREE")
)