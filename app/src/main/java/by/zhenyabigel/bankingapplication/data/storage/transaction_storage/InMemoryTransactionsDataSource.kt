package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.data.model.Transaction
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(DelicateCoroutinesApi::class)
object InMemoryTransactionsDataSource : TransactionDataSource {

    private val transactions = DefaultTransactions.associateBy { it.id }.toMutableMap() // (1)
    private val _transactionFlow = MutableSharedFlow<Map<UUID, Transaction>>(1) // (2)

    init {
        GlobalScope.launch {
            while (isActive) {
                _transactionFlow.emit(transactions)
                delay(2000L)
            }
        }
    }

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




