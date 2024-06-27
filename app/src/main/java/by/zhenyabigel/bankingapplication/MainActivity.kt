package by.zhenyabigel.bankingapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import by.zhenyabigel.bankingapplication.screen.home_screen.HomeScreen
import by.zhenyabigel.bankingapplication.screen.view_all_transactions_screen.ViewAllTransactionsScreen
import by.zhenyabigel.bankingapplication.ui.theme.BankingApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingApplicationTheme {
                HomeScreen()
            }
        }
    }
}