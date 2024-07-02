package by.zhenyabigel.bankingapplication.data.storage.dao

import by.zhenyabigel.bankingapplication.data.model.Transaction
import by.zhenyabigel.bankingapplication.data.storage.transaction_storage.InMemoryTransactionsDataSource
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class TransactionDaoImpl : TransactionDao {
    private val query = InMemoryTransactionsDataSource
    override fun getTransactions(): Flow<List<Transaction>> = query.getTransactions()

    override fun getTransaction(id: UUID): Flow<Transaction> =
        query.getTransaction(id) as Flow<Transaction>

    override suspend fun upsert(transaction: Transaction) {
        query.upsert(transaction)
    }

    override suspend fun delete(transactionId: UUID) {
        query.delete(transactionId)
    }
}