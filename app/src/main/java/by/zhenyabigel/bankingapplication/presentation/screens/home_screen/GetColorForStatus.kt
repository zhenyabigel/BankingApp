package by.zhenyabigel.bankingapplication.presentation.screens.home_screen

import androidx.compose.ui.graphics.Color
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Green
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Maroon
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Yellow

fun getColorForStatus(status: String): Color {
    return when (status) {
        "Executed" -> Green
        "In progress" -> Yellow
        "Declined" -> Maroon
        else -> Color.Gray // Цвет по умолчанию
    }
}