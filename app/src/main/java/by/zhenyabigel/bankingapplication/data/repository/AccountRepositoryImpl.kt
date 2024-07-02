package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.storage.dao.AccountDao
import by.zhenyabigel.bankingapplication.domain.AccountsRepository
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class AccountRepositoryImpl(
    private val dao: AccountDao
) : AccountsRepository {
    override fun getAccounts(): Flow<List<Account>> = dao.getAccounts()
    override fun getAccount(id: UUID): Flow<Account?> = dao.getAccount(id)
    override suspend fun upsert(account: Account) {
        upsert(account)
    }
    override suspend fun delete(id: UUID) {
        delete(id)
    }
}