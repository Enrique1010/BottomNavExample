package com.erapps.bottomnavbarexample.ui.shared

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title: String,
    val iconResource: ImageVector,
    val route: String
)
