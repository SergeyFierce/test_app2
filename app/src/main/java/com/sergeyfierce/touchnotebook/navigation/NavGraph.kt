package com.sergeyfierce.touchnotebook.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sergeyfierce.touchnotebook.feature.contacts.list.ContactsListRoute
import com.sergeyfierce.touchnotebook.feature.home.HomeRoute

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) {
            HomeRoute(navController)
        }
        composable(
            route = "contacts/{category}",
            enterTransition = {
                slideInHorizontally { it } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { -it } + fadeOut()
            }
        ) {
            ContactsListRoute(navController)
        }
    }
}
