package by.zhenyabigel.bankingapplication.presentation.screens.home_screen


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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.presentation.screens.utils.ErrorScreen
import by.zhenyabigel.bankingapplication.presentation.screens.utils.LoadingScreen
import by.zhenyabigel.bankingapplication.presentation.viewmodel.HomeViewModel
import org.koin.androidx.compose.koinViewModel
import java.util.UUID


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController, viewModel: HomeViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet: Boolean by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(horizontal = 16.dp)
                    .padding(top = 40.dp)
            ) {

                when (val state = uiState) {
                    is HomeViewModel.HomeState.Loading -> {
                        LoadingScreen()
                    }

                    is HomeViewModel.HomeState.Empty -> {
                        ErrorScreen()
                    }

                    is HomeViewModel.HomeState.Loaded -> {
                        val accounts = state.accounts
                        val transactions = state.transactions

                        AccountSection(accountDomainModel = accounts[1],
                            onClickAccount = { showBottomSheet = true })

                        Spacer(modifier = Modifier.height(16.dp))

                        TransactionSection(
                            transactionDomainModels = transactions, navController = navController
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        HomeFooter(onClickPlusBtn = { navController.navigate("transaction_screen") })

                        if (showBottomSheet) {
                            ModalBottomSheet(
                                onDismissRequest = {
                                    showBottomSheet = false
                                },
                                sheetState = sheetState,
                                containerColor = Color.Black,
                            ) {
                                HomeBottomSheet(
                                    selectedAccountDomainModel = AccountDomainModel(
                                        id = UUID.randomUUID(),
                                        number = "1212312",
                                        walletID = "1231231232",
                                        ownerName = "Zhenya Bigel",
                                        cover = R.drawable.card
                                    ),
                                    accountDomainModels =accounts,
                                    onClickChangeAccount = {

                                    })
                            }
                        }
                    }

                    is HomeViewModel.HomeState.Error -> {
                        val exception = state.e
                    }
                }
            }
        })
}


