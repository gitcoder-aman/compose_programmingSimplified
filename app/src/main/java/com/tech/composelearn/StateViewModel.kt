package com.tech.composelearn

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class StateViewModel @Inject constructor() : ViewModel() {

    val name:MutableState<String> = mutableStateOf("Aman")
}