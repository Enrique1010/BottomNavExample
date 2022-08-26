package com.erapps.bottomnavbarexample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.erapps.bottomnavbarexample.ui.screens.details.DetailsScreen
import com.erapps.bottomnavbarexample.ui.screens.home.HomeScreen
import com.erapps.bottomnavbarexample.ui.screens.search.SearchScreen
import com.erapps.bottomnavbarexample.ui.screens.settings.SettingScreen

@Composable
fun NavGraph(paddingValues: PaddingValues, navController: NavHostController) {

    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = NavItem.Home.route
    ) {

        composable(NavItem.Home) {
            HomeScreen { name ->
                navController.navigate(
                    NavItem.Details.createDetailsRoute(name)
                )
            }
        }
        composable(NavItem.Search) {
            SearchScreen()
        }
        composable(NavItem.Settings) {
            SettingScreen()
        }
        composable(NavItem.Details) {
            DetailsScreen(it.findArgs(NavArgs.Name)) {
                navController.popBackStack()
            }
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route = navItem.route, arguments = navItem.args) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArgs(args: NavArgs): T {
    val value = arguments?.get(args.key)
    requireNotNull(value)

    return value as T
}