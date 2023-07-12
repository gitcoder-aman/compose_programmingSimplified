package com.tech.composelearn.viewpager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.tech.composelearn.R

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen() {
    val pagerState = rememberPagerState()

    Column {
        HorizontalPager(
            count = dataList.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            page->
            PageUI(pager = dataList[page])
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(20.dp),
        activeColor = colorResource(id = R.color.purple_500))

        AnimatedVisibility(visible = pagerState.currentPage==2) {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
            }
        }
    }
}

@Composable
fun PageUI(pager: Pager) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = pager.image),
            contentDescription = pager.des,
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = pager.des)
    }
}