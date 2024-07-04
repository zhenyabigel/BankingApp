package by.zhenyabigel.bankingapplication.data.storage.transaction_storage

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import java.util.UUID

object InMemoryTransactionsDataSource : TransactionDataSource {

    private val transactions = DefaultTransactionDomainModels.associateBy { it.id }.toMutableMap()
    private val _transactionDomainModelFlow = MutableSharedFlow<Map<UUID, TransactionDomainModel>>(1)
    override fun getTransactions(): Flow<List<TransactionDomainModel>> {
        return _transactionDomainModelFlow.asSharedFlow().map { it.values.toList() }
    }

    override fun getTransaction(id: UUID): Flow<TransactionDomainModel?> {
        return _transactionDomainModelFlow.asSharedFlow().map { it[id] }
    }

    override suspend fun upsert(transactionDomainModel: TransactionDomainModel) {
        transactions[transactionDomainModel.id] = transactionDomainModel
    }

    override suspend fun delete(id: UUID) {
        transactions.remove(id)
    }
}




