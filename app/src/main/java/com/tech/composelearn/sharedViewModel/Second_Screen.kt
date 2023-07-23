package com.tech.composelearn.sharedViewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tech.composelearn.sharedViewModel.viewmodel.SharedViewModel

@Composable
fun Second_Screen(viewModel:SharedViewModel) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            Text(text = viewModel.res.value)
    }
}