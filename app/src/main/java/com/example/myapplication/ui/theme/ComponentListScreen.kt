package com.example.myapplication.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ComponentListScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "UI Components List",
            color = Color(0xFF00BCD4),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Section(title = "Display") {
            ComponentCard(
                title = "Text",
                description = "Displays text",
                onClick = { navController.navigate("text_detail") }
            )
            ComponentCard(
                title = "Image",
                description = "Displays an image",
                onClick = { navController.navigate("image") }
            )
        }

        Section(title = "Input") {
            ComponentCard(
                title = "TextField",
                description = "Input field for text",
                onClick = { navController.navigate("text_field") }
            )
            ComponentCard(
                title = "PasswordField",
                description = "Input field for passwords",
                onClick = { navController.navigate("password_field") }
            )
        }

        Section(title = "Layout") {
            ComponentCard(
                title = "Column",
                description = "Arranges elements vertically",
                onClick = { navController.navigate("column") }
            )
            ComponentCard(
                title = "Row",
                description = "Arranges elements horizontally",
                onClick = { navController.navigate("row") }
            )
        }
    }
}

@Composable
fun Section(title: String, content: @Composable ColumnScope.() -> Unit) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    Column {
        content()
    }
}

@Composable
fun ComponentCard(title: String, description: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color(0xFFB3E5FC), shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = description,
            fontSize = 14.sp
        )
    }
}
