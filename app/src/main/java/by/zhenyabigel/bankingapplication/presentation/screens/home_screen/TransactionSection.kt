package by.zhenyabigel.bankingapplication.presentation.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.presentation.navigation.Screen
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Blue
import by.zhenyabigel.bankingapplication.presentation.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.presentation.ui.theme.LightGray
import by.zhenyabigel.bankingapplication.presentation.ui.theme.robotoFontFamily

@Composable
fun TransactionSection(
    transactionDomainModels: List<TransactionDomainModel>, navController: NavController
) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Transactions",
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 28.sp
            )
            Text(text = "VIEW ALL",
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Blue,
                fontSize = 13.sp,
                modifier = Modifier.clickable { navController.navigate(Screen.ViewAllTransactionsScreen.route) })
        }
        Spacer(modifier = Modifier.height(26.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(DarkGray)
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 7.dp),
                contentPadding = PaddingValues(all = 5.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(items = transactionDomainModels.take(5)) { index, item ->
                    TransactionItem(transactionDomainModel = item,
                        onClickTransaction = { navController.navigate((Screen.TransactionScreen.route)) })
                    if (index < 4) Divider(
                        color = LightGray,
                        thickness = 0.7.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }
}