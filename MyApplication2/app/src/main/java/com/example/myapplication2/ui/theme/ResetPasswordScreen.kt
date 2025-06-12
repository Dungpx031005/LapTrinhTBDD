package com.example.myapplication2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication2.R
import com.example.myapplication2.CommonTextField

@Composable
fun ResetPasswordScreen(navController: NavController) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        // Back icon
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(start = 16.dp, top = 48.dp)
                .size(40.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.task2),
                contentDescription = "Back",
                tint = Color(0xFF1EA1F1),
                modifier = Modifier.size(40.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo UTH
            Image(
                painter = painterResource(id = R.drawable.task1),
                contentDescription = "UTH Logo",
                modifier = Modifier.size(100.dp)
            )
            Text("SmartTasks", fontSize = 30.sp, color = Color(0xFF1EA1F1))

            Spacer(modifier = Modifier.height(32.dp))

            Text("Create new password", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                "Your new password must be different from previously used password.",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Input fields
            CommonTextField("Password", Icons.Default.Lock, password) { password = it }
            Spacer(modifier = Modifier.height(12.dp))
            CommonTextField("Confirm Password", Icons.Default.Lock, confirmPassword) { confirmPassword = it }

            Spacer(modifier = Modifier.height(32.dp))

            // Next Button
            Button(
                onClick = {
                    if (password == confirmPassword && password.isNotBlank()) {
                        navController.navigate("confirm")
                    }
                },
                enabled = password == confirmPassword && password.isNotBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1EA1F1),
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray
                )
            ) {
                Text("Next", fontSize = 16.sp)
            }
        }
    }
}
