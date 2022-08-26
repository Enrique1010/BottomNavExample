package com.erapps.bottomnavbarexample.ui.screens

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.erapps.bottomnavbarexample.R
import com.erapps.bottomnavbarexample.ui.navigation.NavGraph
import com.erapps.bottomnavbarexample.ui.navigation.NavItem
import com.erapps.bottomnavbarexample.ui.shared.BottomNavItem

@Composable
fun LandingPage(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(modifier = modifier, bottomBar = {
        if (currentRoute == NavItem.Home.route ||
            currentRoute == NavItem.Search.route ||
            currentRoute == NavItem.Settings.route
        ) {
            BottomNavBar(navController, currentRoute)
        }
    }) { padding ->
        NavGraph(padding, navController)
    }
}

@Composable
fun BottomNavBar(navController: NavHostController, currentRoute: String?) {

    val items = listOf(
        BottomNavItem(
            route = NavItem.Home.route,
            title = stringResource(id = R.string.title_home),
            iconResource = Icons.Default.Home
        ),
        BottomNavItem(
            route = NavItem.Search.route,
            title = stringResource(id = R.string.title_search),
            iconResource = Icons.Default.Search
        ),
        BottomNavItem(
            route = NavItem.Settings.route,
            title = stringResource(id = R.string.title_settings),
            iconResource = Icons.Default.Settings
        )
    )

    BottomNavigation(backgroundColor = Color.White) {

        items.forEach { item ->
            BottomNavigationItem(
                selected = item.route == currentRoute,
                label = { Text(text = item.title) },
                icon = { Icon(imageVector = item.iconResource, contentDescription = item.title) },
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = Color.LightGray,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}