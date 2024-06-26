package by.zhenyabigel.bankingapplication.screens.transaction_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun TransactionHeader() {
    Text(
        text = "Saving account",
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.ExtraBold,
        color = Color.White,
        fontSize = 15.sp
    )
}
