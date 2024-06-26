package by.zhenyabigel.bankingapplication.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import by.zhenyabigel.bankingapplication.model.cards
import by.zhenyabigel.bankingapplication.model.transactions

@Composable
fun HomeScreen() {
    val accounts = cards
    val transactions = transactions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ) {
        AccountSection(accounts[1])
        Spacer(modifier = Modifier.height(16.dp))
        TransactionSection(transactions)
        Spacer(modifier = Modifier.height(16.dp))
        HomeFooter()
    }
}






