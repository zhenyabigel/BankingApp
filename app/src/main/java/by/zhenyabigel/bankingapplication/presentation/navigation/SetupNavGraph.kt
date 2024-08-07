package by.zhenyabigel.bankingapplication.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import by.zhenyabigel.bankingapplication.presentation.screens.home_screen.HomeScreen
import by.zhenyabigel.bankingapplication.presentation.screens.transaction_screen.TransactionScreen
import by.zhenyabigel.bankingapplication.presentation.screens.view_all_transactions_screen.ViewAllTransactionsScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController, startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.TransactionScreen.route) {
            TransactionScreen(navController)
        }
        composable(route = Screen.ViewAllTransactionsScreen.route) {
            ViewAllTransactionsScreen(navController)
        }
    }
}