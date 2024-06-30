package by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen

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
import by.zhenyabigel.bankingapplication.data.transactions
import androidx.navigation.NavController
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewAllTransactionsScreen(navController: NavController) {
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
            ViewAllTransactionsHeader({ navController.navigate("home_screen") },
                { showBottomSheet = true })
            Spacer(modifier = Modifier.height(16.dp))
            ViewAllTransactionList(transactions)
        }
        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
                containerColor = Color.Black,
            ) {
                ViewAllTransactionsBottomSheet()
            }
        }
    })
}




