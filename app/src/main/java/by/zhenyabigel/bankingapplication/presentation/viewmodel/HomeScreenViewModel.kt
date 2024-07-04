package by.zhenyabigel.bankingapplication.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.usecase.AddNewAccountUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.AddNewTransactionUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.GetAllAccountsUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.GetAllTransactionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel(
    private val addNewAccountUseCase: AddNewAccountUseCase,
    private val addNewTransactionUseCase: AddNewTransactionUseCase,
    private val getAllAccountsUseCase: GetAllAccountsUseCase,
    private val getAllTransactionsUseCase: GetAllTransactionsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeState>(HomeState.Loading)
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch(Dispatchers.Default) {
            try {
                val accountsFlow = getAllAccountsUseCase()
                val transactionsFlow = getAllTransactionsUseCase()

                combine(accountsFlow, transactionsFlow) { accounts, transactions ->

                    if (accounts.isEmpty() && transactions.isEmpty()) {
                        HomeState.Empty

                    } else if (accounts.isNotEmpty()) {
                        val selectedAccountId = accounts.first().id
                        HomeState.Loaded(accounts, transactions, selectedAccountId)

                    } else {
                        throw IllegalStateException("Account was null")
                    }

                }.collect { state ->
                    _uiState.value = state
                }

            } catch (e: Exception) {
                _uiState.value = HomeState.Error(e)
            }

        }
    }

    fun upsertAccount(account: AccountDomainModel) {
        viewModelScope.launch (Dispatchers.Default){
            try {
                addNewAccountUseCase(account)
                loadData()
            } catch (e: Exception) {
                _uiState.value = HomeState.Error(e)
            }
        }
    }

    sealed interface HomeState {

        data object Loading : HomeState

        data object Empty : HomeState

        data class Loaded(
            val accounts: List<AccountDomainModel>,
            val transactions: List<TransactionDomainModel>,
            val selectedAccountId: UUID
        ) : HomeState

        data class Error(val e: Exception) : HomeState
    }
}