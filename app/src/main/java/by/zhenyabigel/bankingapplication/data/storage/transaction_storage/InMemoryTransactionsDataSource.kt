package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.data.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.UUID

object InMemoryTransactionsDataSource : TransactionDataSource {

    private val transactions = DefaultTransactions.associateBy { it.id }.toMutableMap() // (1)

    private val _transactionFlow = MutableSharedFlow<Map<UUID, Transaction>>(1) // (2)
    override fun getTransactions(): Flow<List<Transaction>> {
    }

    override fun getTransaction(id: UUID): Flow<Transaction?> {
    }

    override suspend fun upsert(transaction: Transaction) {
    }

    override suspend fun delete(id: UUID) {
    }

}
