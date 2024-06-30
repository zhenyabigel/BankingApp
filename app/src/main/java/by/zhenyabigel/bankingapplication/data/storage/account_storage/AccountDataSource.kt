package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.model.Transaction
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface AccountDataSource{
    fun getTransactions(): Flow<List<Account>>
    fun getTransaction(id: UUID): Flow<Account?>

    suspend fun upsert(transaction: Account)
    suspend fun delete(id: UUID)
}
