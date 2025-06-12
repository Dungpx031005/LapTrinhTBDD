package com.example.myapplication2

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication2.ui.theme.*

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "forgotPassword") {
        composable("forgotPassword") { ForgotPasswordScreen(navController) }
        composable("verifyCode") { VerifyCodeScreen(navController) }
        composable("resetPassword") { ResetPasswordScreen(navController) }
        composable("confirm") { ConfirmScreen(navController) }
    }
}
