package com.example.myapplication2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import com.example.myapplication2.CommonTextField
import com.example.myapplication2.R

@Composable
fun ConfirmScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var code by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

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
            // Logo
            Image(
                painter = painterResource(id = R.drawable.task1),
                contentDescription = "UTH Logo",
                modifier = Modifier.size(100.dp)
            )
            Text("SmartTasks", fontSize = 30.sp, color = Color(0xFF1EA1F1))

            Spacer(modifier = Modifier.height(32.dp))

            Text("Confirm", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                "We are here to help you!",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            CommonTextField("Email", Icons.Default.Email, email) { email = it }
            Spacer(modifier = Modifier.height(12.dp))
            CommonTextField("Code", Icons.Default.Email, code) { code = it }
            Spacer(modifier = Modifier.height(12.dp))
            CommonTextField("New Password", Icons.Default.Lock, password) { password = it }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    // Navigate về màn hình forgotPassword (có thể điều chỉnh logic tùy app)
                    navController.popBackStack("forgotPassword", inclusive = false)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1EA1F1),
                    contentColor = Color.White
                )
            ) {
                Text("Submit", fontSize = 16.sp)
            }
        }
    }
}
