package com.example.myapplication2.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication2.R
import com.example.myapplication2.ui.theme.OtpInput
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

@Composable
fun VerifyCodeScreen(navController: NavController) {
    var otpCode by remember { mutableStateOf("") } // lưu giá trị OTP nhập

    Box(modifier = Modifier.fillMaxSize()) {

        // Back Icon (từ drawable)
        IconButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .padding(start = 16.dp, top = 48.dp)
                .size(40.dp)
                .align(Alignment.TopStart)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.task2), // icon từ drawable
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
            Image(
                painter = painterResource(id = R.drawable.task1),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp)
            )
            Text("SmartTasks", fontSize = 30.sp, color = Color(0xFF1EA1F1))

            Spacer(modifier = Modifier.height(24.dp))
            Text("Verify Code", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(
                "Enter the code we just sent you on your registered Email",
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(16.dp))

            // OtpInput không điều hướng, chỉ trả về chuỗi
            OtpInput(length = 5) { code ->
                otpCode = code
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    if (otpCode.length == 5) {
                        navController.navigate("resetPassword")
                    }
                },
                enabled = otpCode.length == 5, // chỉ enable khi đủ 5 số
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF1EA1F1),
                    contentColor = Color.White,
                    disabledContainerColor = Color.LightGray // màu khi disable
                )
            ) {
                Text("Next", fontSize = 16.sp)
            }
        }
    }
}
