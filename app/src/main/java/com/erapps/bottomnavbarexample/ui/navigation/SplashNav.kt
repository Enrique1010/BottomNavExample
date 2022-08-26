package com.erapps.bottomnavbarexample.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.erapps.bottomnavbarexample.ui.SplashScreen
import com.erapps.bottomnavbarexample.ui.screens.LandingPage

@Composable
fun SplashNav() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.SplashScreen.route) {
        composable(NavItem.SplashScreen.route){
            SplashScreen {
                navController.popBackStack()
                navController.navigate(NavItem.LandingPage.route)
            }
        }
        composable(NavItem.LandingPage.route) {
            LandingPage()
        }
    }

}