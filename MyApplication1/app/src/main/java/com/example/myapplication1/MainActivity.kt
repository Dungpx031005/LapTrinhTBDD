package com.example.myapplication1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication1.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = Screen.Splash.route) {
                composable(Screen.Splash.route) { SplashScreen(navController) }
                composable(Screen.Onboarding1.route) { OnboardingScreen1(navController) }
                composable(Screen.Onboarding2.route) { OnboardingScreen2(navController) }
                composable(Screen.Onboarding3.route) { OnboardingScreen3(navController) }
            }
        }
    }
}