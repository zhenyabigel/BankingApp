package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface TransactionDataSource {
    fun getTransactions(): Flow<List<TransactionDomainModel>>
    fun getTransaction(id: UUID): Flow<TransactionDomainModel?>
    suspend fun upsert(transactionDomainModel: TransactionDomainModel)
    suspend fun delete(id: UUID)
}
