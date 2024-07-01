package by.zhenyabigel.bankingapplication.domain

import by.zhenyabigel.bankingapplication.data.model.Account
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface AccountsRepository {
    fun getAccounts(): Flow<List<Account>>
    fun getAccount(id: UUID): Flow<Account?>
    suspend fun upsert(account: Account)
    suspend fun delete(id: UUID)
}