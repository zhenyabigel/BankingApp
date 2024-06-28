package by.zhenyabigel.bankingapplication.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.model.Transaction
import by.zhenyabigel.bankingapplication.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.ui.theme.Gray
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun TransactionItem(transaction: Transaction, onClickTransaction: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(8.dp))
        .background(DarkGray)
        .clickable { onClickTransaction() }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = transaction.company,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Text(
                    text = transaction.date,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Gray,
                    fontSize = 13.sp
                )
                Text(
                    text = transaction.status,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = getColorForStatus(transaction.status),
                    fontSize = 13.sp
                )
            }
            Row {
                Text(
                    text = transaction.amount,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_dark),
                    contentDescription = "image arrow forward"
                )
            }
        }
    }
}