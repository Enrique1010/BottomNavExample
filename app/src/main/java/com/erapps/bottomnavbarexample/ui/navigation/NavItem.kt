package com.erapps.bottomnavbarexample.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.erapps.bottomnavbarexample.utils.Constants.DETAILS_NAME_ARGUMENT
import com.erapps.bottomnavbarexample.utils.Constants.DETAILS_ROUTE
import com.erapps.bottomnavbarexample.utils.Constants.HOME_ROUTE
import com.erapps.bottomnavbarexample.utils.Constants.LANDING_PAGE
import com.erapps.bottomnavbarexample.utils.Constants.SEARCH_ROUTE
import com.erapps.bottomnavbarexample.utils.Constants.SETTINGS_ROUTE
import com.erapps.bottomnavbarexample.utils.Constants.SPLASH_SCREEN

sealed class NavItem(
    val baseRoute: String,
    private val navArgs: List<NavArgs> = emptyList()
) {
    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute).plus(argKeys).joinToString("/")
    }

    val args = navArgs.map { navArgument(name = it.key) { type = it.navType } }

    //navigation objects
    object SplashScreen: NavItem(SPLASH_SCREEN)
    object LandingPage: NavItem(LANDING_PAGE)
    object Home: NavItem(HOME_ROUTE)
    object Search: NavItem(SEARCH_ROUTE)
    object Settings: NavItem(SETTINGS_ROUTE)
    object Details: NavItem(DETAILS_ROUTE, listOf(NavArgs.Name)) {
        fun createDetailsRoute(name: String) = "$baseRoute/$name"
    }
}

//navigation arguments
enum class NavArgs(val key: String, val navType: NavType<*>) {
    Name(key = DETAILS_NAME_ARGUMENT, navType = NavType.StringType),
}
