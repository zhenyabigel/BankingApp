package by.zhenyabigel.bankingapplication.screens.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.domain.model.Actions
import by.zhenyabigel.bankingapplication.domain.model.Account
import by.zhenyabigel.bankingapplication.ui.theme.DarkBlue
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun HomeBottomSheet(selectedAccount: Account, accounts: List<Account>, onClickChangeAccount: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            modifier = Modifier.padding(bottom = 20.dp),
            text = "Select the account",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White,
            fontSize = 34.sp
        )
        LazyColumn(
            modifier = Modifier.padding(top = 7.dp, bottom = 50.dp),
            contentPadding = PaddingValues(all = 5.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = accounts) { item ->
                val color = if (selectedAccount == item) DarkBlue
                else Color.Black
                CardItem(
                    account = item,
                    onClickAccount = { onClickChangeAccount() },
                    type = Actions.BottomSheet,
                    modifier = Modifier.background(color)
                )
            }
        }
    }
}