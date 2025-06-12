package com.example.myapplication2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication2.CommonTextField
import com.example.myapplication2.R
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun ForgotPasswordScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Image(
                painter = painterResource(id = R.drawable.task1),
                contentDescription = "UTH Logo",
                modifier = Modifier.size(100.dp)
            )
            Text(
                text = "SmartTasks",
                fontSize = 30.sp,
                color = Color(0xFF1EA1F1), // dùng `color` (chữ thường) mới đúng
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(32.dp))
            Text("Forget Password?", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                "Enter your Email, we will send you a verification code.",
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Your Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    if (email.isNotBlank()) navController.navigate("verifyCode")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1EA1F1), // xanh dương sáng giống hình
                    contentColor = Color.White          // chữ màu trắng
                ),
                shape = RoundedCornerShape(50) // bo tròn toàn bộ nút
            ) {
                Text("Next", fontSize = 16.sp)
            }
        }
    }
}



