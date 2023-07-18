package com.tech.composelearn.tabViewLayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabPosition
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.tech.composelearn.ui.theme.ComposeLearnTheme
import kotlinx.coroutines.launch

class TabViewActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeLearnTheme {
                TabViewUI()
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview
fun TabViewUI() {
    val pagerState = rememberPagerState()
    val currentPage = pagerState.currentPage
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = currentPage, backgroundColor = Color.Yellow, divider = {
            TabRowDefaults.Divider(
                color = Color.Black,
                thickness = 2.dp
            )
        }) {

            tabList.forEachIndexed { index, tabData ->
                Tab(selected = currentPage == index, onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, modifier = Modifier.padding(20.dp)) {

                    Text(text = tabList[index].tab)
                }
            }
        }

        HorizontalPager(count = tabList.size, state = pagerState) { index ->
            Text(text = tabList[index].desc)
        }

    }
}

data class TabData(
    val tab: String,
    val desc: String
)

val tabList = listOf(
    TabData("Home", "This is home page."),
    TabData("Image", "This is Image page."),
    TabData("Videos", "This is Video page.")
)
