package by.zhenyabigel.bankingapplication.di

import by.zhenyabigel.bankingapplication.domain.usecase.AddNewAccountUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.AddNewTransactionUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.GetAllAccountsUseCase
import by.zhenyabigel.bankingapplication.domain.usecase.GetAllTransactionsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<AddNewAccountUseCase> {
        AddNewAccountUseCase(repository = get())
    }

    factory<GetAllAccountsUseCase> {
        GetAllAccountsUseCase(accountsRepository = get())
    }

    factory<GetAllTransactionsUseCase> {
        GetAllTransactionsUseCase(transactionRepository = get())
    }
    factory<AddNewTransactionUseCase> {
        AddNewTransactionUseCase(repository = get())
    }
}