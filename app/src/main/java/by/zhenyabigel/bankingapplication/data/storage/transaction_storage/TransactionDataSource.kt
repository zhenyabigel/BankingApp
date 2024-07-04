package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.domain.model.Transaction
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface TransactionDataSource {
    fun getTransactions(): Flow<List<Transaction>>
    fun getTransaction(id: UUID): Flow<Transaction?>
    suspend fun upsert(transaction: Transaction)
    suspend fun delete(id: UUID)
}
