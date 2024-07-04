package by.zhenyabigel.bankingapplication.presentation.screens.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorScreen(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    )
    Text(text = "Error", color = Color.White)
}