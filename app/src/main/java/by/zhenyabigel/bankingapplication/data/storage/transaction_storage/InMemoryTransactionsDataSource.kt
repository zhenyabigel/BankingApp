package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.domain.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import java.util.UUID

object InMemoryTransactionsDataSource : TransactionDataSource {

    private val transactions = DefaultTransactions.associateBy { it.id }.toMutableMap()
    private val _transactionFlow = MutableSharedFlow<Map<UUID, Transaction>>(1)
    override fun getTransactions(): Flow<List<Transaction>> {
        return _transactionFlow.asSharedFlow().map { it.values.toList() }
    }

    override fun getTransaction(id: UUID): Flow<Transaction?> {
        return _transactionFlow.asSharedFlow().map { it[id] }
    }

    override suspend fun upsert(transaction: Transaction) {
        transactions[transaction.id] = transaction
    }

    override suspend fun delete(id: UUID) {
        transactions.remove(id)
    }
}




