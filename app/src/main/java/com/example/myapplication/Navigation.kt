package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.ComponentListScreen
import com.example.myapplication.ui.theme.ImageScreen
import com.example.myapplication.ui.theme.RowLayoutScreen
import com.example.myapplication.ui.theme.TextDetailScreen
import com.example.myapplication.ui.theme.TextFieldScreen
import com.example.myapplication.ui.theme.WelcomeScreen


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("components") { ComponentListScreen(navController) }
        composable("text_detail") { TextDetailScreen(navController) }
        composable("image") { ImageScreen(navController) }
        composable("text_field") { TextFieldScreen(navController) }
        composable("row") { RowLayoutScreen(navController) }
    }
}
