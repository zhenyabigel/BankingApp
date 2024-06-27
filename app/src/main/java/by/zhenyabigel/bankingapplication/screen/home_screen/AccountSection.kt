package by.zhenyabigel.bankingapplication.screen.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.model.Actions
import by.zhenyabigel.bankingapplication.model.Card
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun AccountSection(card: Card, onClickAccount: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Account",
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 28.sp
            )
            Spacer(modifier = Modifier.height(26.dp))
            CardItem(card, onClickAccount,Actions.AccountSection)
        }
    }
}