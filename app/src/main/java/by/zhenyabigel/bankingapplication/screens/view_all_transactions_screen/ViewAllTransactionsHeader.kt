package by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun ViewAllTransactionsHeader(onClickBackBtn: () -> Unit, onClickMoreBnt: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Color.Black)
            .padding(horizontal = 16.dp), contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { onClickBackBtn() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_arrow),
                    contentDescription = "Back",
                    tint = Color.White
                )
            }
            Text(
                text = "All transactions",
                fontSize = 17.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
            IconButton(
                onClick = { onClickMoreBnt() }, modifier = Modifier
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_ellipsis_circle),
                    contentDescription = "More options",
                    tint = Color.White
                )
            }
        }
    }
}