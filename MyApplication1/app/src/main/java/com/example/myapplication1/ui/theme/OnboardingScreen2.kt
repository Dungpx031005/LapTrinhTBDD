package com.example.myapplication1.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.example.myapplication1.Screen
import com.example.myapplication1.R

@Composable
fun OnboardingScreen2(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top bar: Indicator + Skip
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Dot indicator
                Row {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.Blue, shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.LightGray, shape = CircleShape)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(Color.LightGray, shape = CircleShape)
                    )
                }

                TextButton(onClick = {
                    navController.navigate(Screen.Onboarding1.route) {
                        popUpTo(Screen.Onboarding2.route) { inclusive = true }
                    }
                }) {
                    Text("skip", color = Color.Blue)
                }
            }

            // Image
            Image(
                painter = painterResource(id = R.drawable.task3),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            // Texts
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Increase Work Effectiveness",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Time management and the determination of more important tasks will give your job statistics better and always improve",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            // Bottom buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back icon
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        painter = painterResource(id = R.drawable.task5), // bạn nên dùng hình mũi tên tròn hoặc vector XML
                        contentDescription = "Back",
                        tint = Color.Blue,
                        modifier = Modifier.size(48.dp)
                    )
                }

                // Next button
                Button(
                    onClick = { navController.navigate(Screen.Onboarding3.route) },
                    modifier = Modifier
                        .width(300.dp)
                        .height(48.dp),
                    shape = RoundedCornerShape(24.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
                ) {
                    Text("Next", color = Color.White)
                }
            }
        }
    }
}


