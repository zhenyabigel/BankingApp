package by.zhenyabigel.bankingapplication.screens.transaction_screen

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

import by.zhenyabigel.bankingapplication.model.Transaction

@Composable
fun TransactionScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ) {
        TransactionHeader()
        Spacer(modifier = Modifier.height(32.dp))
        TransactionInputField(
            transactions[1],
            onClickOkayBtn = {
                {}
                navController.navigate("home_screen")
            })
    }
}




