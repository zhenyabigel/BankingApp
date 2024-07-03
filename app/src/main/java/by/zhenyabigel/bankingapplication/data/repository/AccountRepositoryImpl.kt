package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.AccountDataSource
import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.domain.AccountsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class AccountRepositoryImpl(
    private val accountDataSource: AccountDataSource
) : AccountsRepository {
    override fun getAccounts(): Flow<List<Account>> = flow {
        val accounts = accountDataSource.getAccountsList().map { it.toAccount() }
        emit(accounts)
    }
    override fun getAccount(id: UUID): Flow<Account?> = flow {
        val account = accountDataSource.getAccount(id).toAccount()
        emit(account)
    }
    override suspend fun upsert(account: Account) {
        upsert(account)
    }
    override suspend fun delete(id: UUID) {
        delete(id)
    }
}