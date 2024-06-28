package by.zhenyabigel.bankingapplication.screens.home_screen

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
import androidx.navigation.NavHostController
import by.zhenyabigel.bankingapplication.model.cards
import by.zhenyabigel.bankingapplication.model.transactions

@Composable
fun HomeScreen(navController: NavHostController) {
    val accounts = cards
    val transactions = transactions

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ) {
        AccountSection(card = accounts[1], onClickAccount = {})
        Spacer(modifier = Modifier.height(16.dp))
        TransactionSection(transactions,{ navController.navigate("view_all_transaction_screen") })
        Spacer(modifier = Modifier.height(16.dp))
        HomeFooter(onClickPlusBtn = {navController.navigate("transaction_screen")})
    }
}






