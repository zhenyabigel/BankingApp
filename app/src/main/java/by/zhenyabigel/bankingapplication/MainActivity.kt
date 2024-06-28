package by.zhenyabigel.bankingapplication

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.rememberNavController
import by.zhenyabigel.bankingapplication.navigation.SetupNavGraph
import by.zhenyabigel.bankingapplication.screens.home_screen.HomeScreen
import by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen.ViewAllTransactionsScreen
import by.zhenyabigel.bankingapplication.ui.theme.BankingApplicationTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BankingApplicationTheme {
                val coroutineScope: CoroutineScope = rememberCoroutineScope()
                val navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}