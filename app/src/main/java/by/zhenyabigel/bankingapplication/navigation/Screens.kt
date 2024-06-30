package by.zhenyabigel.bankingapplication.navigation

sealed class Screen(val route: String) {
    data object HomeScreen : Screen(route = "home_screen")
    data object TransactionScreen : Screen(route = "transaction_screen")
    data object ViewAllTransactionsScreen : Screen(route = "view_all_transaction_screen")
}
