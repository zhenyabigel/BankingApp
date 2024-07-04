package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.domain.model.Account
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface AccountDataSource {
    fun getAccounts(): Flow<List<Account>>
    fun getAccount(id: UUID): Flow<Account?>
    suspend fun upsert(account: Account)
    suspend fun delete(id: UUID)
}
