package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.AccountDataSource
import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.model.toEntity
import by.zhenyabigel.bankingapplication.domain.repository_interfaces.AccountsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class AccountRepositoryImpl(
    private val accountDataSource: AccountDataSource
) : AccountsRepository {
    override fun getAccounts(): Flow<List<AccountDomainModel>> = flow {
        val accounts = accountDataSource.getAccountsList().map { it.toAccount() }
        emit(accounts)
    }
    override fun getAccount(id: UUID): Flow<AccountDomainModel?> = flow {
        val account = accountDataSource.getAccount(id).toAccount()
        emit(account)
    }
    override suspend fun upsert(accountDomainModel: AccountDomainModel) {
        accountDataSource.upsert(accountDomainModel.toEntity())
    }
    override suspend fun delete(id: UUID) {
        accountDataSource.delete(id)
    }
}