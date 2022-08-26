package com.erapps.bottomnavbarexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.erapps.bottomnavbarexample.ui.navigation.SplashNav
import com.erapps.bottomnavbarexample.ui.screens.LandingPage
import com.erapps.bottomnavbarexample.ui.theme.BottomNavBarExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BottomNavBarExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SplashNav()
                }
            }
        }
    }
}