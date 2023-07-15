package com.tech.composelearn.jetpackBottomNavigationView

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItems(val route : String,val lable : String,val icons : ImageVector){
    object Home : NavigationItems("home","Home",Icons.Default.Home)
    object Notification : NavigationItems("notification","Notification",Icons.Default.Notifications)
    object Setting : NavigationItems("setting","Setting",Icons.Default.Settings)
    object Account : NavigationItems("account","Account",Icons.Default.AccountBox)
}