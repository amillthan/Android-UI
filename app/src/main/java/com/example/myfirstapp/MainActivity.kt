package com.example.myfirstapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.LocalOffer
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // All @Composable calls must be inside setContent
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFF3F4F6)
            ) {
                NewsCardScreen()
            }
        }
    }
}

@Composable
fun NewsCardScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp),
            shape = RoundedCornerShape(24.dp)
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                // Make sure drawable name matches file in res/drawable
                Image(
                    painter = painterResource(id = R.drawable.city_bg),
                    contentDescription = "City background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                // Gradient overlay for readable text
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color.Transparent, Color(0xCC000000)),
                                startY = 300f
                            )
                        )
                )

                // Top small progress bars
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .align(Alignment.TopCenter),
                    horizontalArrangement = Arrangement.Center
                ) {
                    repeat(4) { idx ->
                        Box(
                            modifier = Modifier
                                .padding(horizontal = 6.dp)
                                .height(4.dp)
                                .width(if (idx == 0) 48.dp else 36.dp)
                                .clip(RoundedCornerShape(50))
                                .background(if (idx == 0) Color.Green else Color.White.copy(alpha = 0.22f))
                        )
                    }
                }

                // Bottom content: category, title, author/time
                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 20.dp, bottom = 96.dp, end = 20.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(Color(0xFF1B5E20))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "AI",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = Color(0xFF81C784)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "The Future of New AI World",
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 24.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Amillthan",
                            color = Color(0xFFA5D6A7),
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Text(
                            text = "• 10 min read",
                            color = Color.White,
                            fontSize = 14.sp
                        )
                    }
                }

                // Bottom navigation bar (dark)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(84.dp)
                        .align(Alignment.BottomCenter)
                        .background(Color.Black.copy(alpha = 0.92f)),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomNavItem(icon = Icons.Filled.Article, label = "NEWS")
                    BottomNavItem(icon = Icons.Filled.LocalOffer, label = "PROMOS")
                    BottomNavItem(icon = Icons.Filled.Settings, label = "SETTINGS")
                }
            }
        }
    }
}

@Composable
private fun BottomNavItem(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(22.dp), tint = Color.White)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = label, color = Color.Green, fontSize = 12.sp)
    }
}
