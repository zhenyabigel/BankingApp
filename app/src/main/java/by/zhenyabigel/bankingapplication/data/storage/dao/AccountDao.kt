package by.zhenyabigel.bankingapplication.data.storage.dao

import by.zhenyabigel.bankingapplication.data.model.Account
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface AccountDao {
    fun getAccounts(): Flow<List<Account>>
    fun getAccount(accountId: UUID): Flow<Account>
    suspend fun upsert(account: Account)
    suspend fun delete(accountId: UUID)
}