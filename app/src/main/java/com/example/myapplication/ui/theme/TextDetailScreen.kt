package com.example.myapplication.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily.Companion.Cursive
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetailScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Text Detail",
                        color = Color(0xFF00BCD4), // màu xanh dương như trong ảnh
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back",
                            tint = Color(0xFF00BCD4) // chỉnh màu mũi tên cho giống ảnh
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        // Nội dung bên trong
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(60.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            val textSize = 40.sp

            // Dòng 1: The ~quick~ Brown
            Row {
                Text("The ", fontSize = textSize)
                Text(
                    text = "quick ",
                    style = TextStyle(
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = textSize
                    )
                )
                Text(
                    text = "Brown",
                    color = Color(0xFFB9802A),
                    fontWeight = FontWeight.Bold,
                    fontSize = textSize
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Dòng 2: fox j u m p s over
            Row {
                Text("fox ", fontSize = textSize)
                listOf("j", "u", "m", "p", "s").forEach {
                    Text("$it ", fontSize = textSize)
                }
                Text(
                    text = "over",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = textSize
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Dòng 3: the lazy dog. (gạch dưới chỉ "the")
            Row {
                Text(
                    text = "the",
                    fontSize = textSize,
                    style = TextStyle(textDecoration = TextDecoration.Underline)
                )
                Text(
                    text = " lazy ",
                    fontStyle = FontStyle.Italic,
                    fontSize = textSize,
                    fontFamily = Cursive
                )
                Text("dog.", fontSize = textSize)
            }
        }
    }
}

