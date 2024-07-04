package by.zhenyabigel.bankingapplication.presentation.screens.transaction_screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.presentation.ui.theme.robotoFontFamily

@Preview
@Composable
fun TransactionHeader() {
    Text(
        text = "Transaction ",
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Black,
        color = Color.White,
        fontSize = 32.sp
    )
}
