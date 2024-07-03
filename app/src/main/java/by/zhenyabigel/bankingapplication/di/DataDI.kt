package by.zhenyabigel.bankingapplication.di

import by.zhenyabigel.bankingapplication.data.repository.AccountRepositoryImpl
import by.zhenyabigel.bankingapplication.data.room.AppDatabase
import by.zhenyabigel.bankingapplication.domain.repository_interfaces.AccountsRepository
import org.koin.dsl.module

val dataModule = module {
    single { AppDatabase(context = get()) }
    single<AccountsRepository> { AccountRepositoryImpl(accountDataSource = get()) }
    single { get<AppDatabase>().accountDao() }
    single { get<AppDatabase>().accountDao() }
}