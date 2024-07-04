package by.zhenyabigel.bankingapplication.di

import by.zhenyabigel.bankingapplication.presentation.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HomeViewModel> {
        HomeViewModel(
            addNewAccountUseCase = get(),
            addNewTransactionUseCase = get(),
            getAllAccountsUseCase = get(),
            getAllTransactionsUseCase = get()
        )
    }
}