package com.example.myapplication1.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication1.R
import com.example.myapplication1.Screen



@Composable
fun OnboardingScreen1(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Top bar with dot indicators and Skip button
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row {
                    Dot(isSelected = true)
                    Spacer(modifier = Modifier.width(8.dp))
                    Dot(isSelected = false)
                }
                TextButton(onClick = {
                    navController.navigate("home") {
                        popUpTo("onboarding/0") { inclusive = true }
                    }
                }) {
                    Text("Skip", color = Color.Blue)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Image
            Image(
                painter = painterResource(id = R.drawable.task2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )

            // Title and description
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    "Easy Time Management",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first.",
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )
            }

            // Next button
            Button(
                onClick = { navController.navigate(Screen.Onboarding2.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3))
            ) {
                Text("Next", color = Color.White)
            }
        }
    }
}

@Composable
fun Dot(isSelected: Boolean) {
    Box(
        modifier = Modifier
            .size(8.dp)
            .background(
                color = if (isSelected) Color.Blue else Color.LightGray,
                shape = RoundedCornerShape(50)
            )
    )
}

