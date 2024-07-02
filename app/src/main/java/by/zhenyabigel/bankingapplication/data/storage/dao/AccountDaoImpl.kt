package by.zhenyabigel.bankingapplication.data.storage.dao

import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.storage.account_storage.InMemoryAccountDataSource
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class AccountDaoImpl:AccountDao {
    private val query = InMemoryAccountDataSource
    override fun getAccounts(): Flow<List<Account>> =
        query.getAccounts()
    override fun getAccount(accountId: UUID): Flow<Account> =
        query.getAccount(accountId) as Flow<Account>
    override suspend fun upsert(account: Account) {
        query.upsert(account)
    }
    override suspend fun delete(accountId: UUID) {
        query.delete(accountId)
    }
}