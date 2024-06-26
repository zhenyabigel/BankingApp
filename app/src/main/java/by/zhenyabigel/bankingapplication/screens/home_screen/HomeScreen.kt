package by.zhenyabigel.bankingapplication.screens.home_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import by.zhenyabigel.bankingapplication.data.accounts
import by.zhenyabigel.bankingapplication.data.transactions


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val accounts = accounts
    var selectedAccount = by.zhenyabigel.bankingapplication.data.accounts[1]
    val transactions = transactions

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(modifier = Modifier.fillMaxSize(), content = { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(horizontal = 16.dp)
                .padding(top = 40.dp)
        ) {
            AccountSection(account = accounts[1], onClickAccount = { showBottomSheet = true })
            Spacer(modifier = Modifier.height(16.dp))
            TransactionSection( transactions = transactions,navController =  navController)
            Spacer(modifier = Modifier.height(16.dp))
            HomeFooter(onClickPlusBtn = {navController.navigate("transaction_screen")})
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                containerColor = Color.Black,
            ) {
                HomeBottomSheet(selectedAccount, accounts, {})
            }
        }
    })
}


