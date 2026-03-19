package com.rudy.kmpstarterproductionlite

import androidx.compose.runtime.Composable
import com.rudy.kmpstarterproductionlite.navigation.AppNavGraph
import com.rudy.kmpstarterproductionlite.presentation.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        AppNavGraph()
    }
}
