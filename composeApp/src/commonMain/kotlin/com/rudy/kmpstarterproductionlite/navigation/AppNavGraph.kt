package com.rudy.kmpstarterproductionlite.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rudy.kmpstarterproductionlite.presentation.items.ItemsScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "items"
    ) {
        composable("items") {
            ItemsScreen(
                onItemClick = { item ->
                    // Navigate to detail screen
                }
            )
        }
    }
}
