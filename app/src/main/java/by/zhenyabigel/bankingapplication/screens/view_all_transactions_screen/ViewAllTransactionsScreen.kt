package by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen

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
import by.zhenyabigel.bankingapplication.model.transactions

@Composable
fun ViewAllTransactionsScreen() {
    val transactions = transactions
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ) {
        ViewAllTransactionsHeader({}, {})
        Spacer(modifier = Modifier.height(16.dp))
        ViewAllTransactionList(transactions)
    }
}




