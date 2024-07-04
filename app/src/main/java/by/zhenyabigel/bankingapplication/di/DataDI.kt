package by.zhenyabigel.bankingapplication.di

import by.zhenyabigel.bankingapplication.data.datasource.AccountDataSource
import by.zhenyabigel.bankingapplication.data.datasource.TransactionDataSource
import by.zhenyabigel.bankingapplication.data.repository.AccountRepositoryImpl
import by.zhenyabigel.bankingapplication.data.repository.TransactionRepositoryImpl
import by.zhenyabigel.bankingapplication.data.room.AppDatabase
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import org.koin.dsl.module

val dataModule = module {

    single { AppDatabase(context = get()) }
    single { get<AppDatabase>().accountDao() }
    single { get<AppDatabase>().transactionDao() }
    single { AccountDataSource(get()) }
    single { TransactionDataSource(get()) }
    single<AccountsRepository> {
        AccountRepositoryImpl(get())
    }
    single<TransactionRepository> {
        TransactionRepositoryImpl(get())
    }


}