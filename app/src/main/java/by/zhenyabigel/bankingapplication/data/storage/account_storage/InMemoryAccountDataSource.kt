package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.model.Transaction
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.UUID

object InMemoryAccountDataSource : AccountDataSource {

    private val transactions = DefaultAccounts.associateBy { it.id }.toMutableMap() // (1)

    private val _transactionFlow = MutableSharedFlow<Map<UUID, Transaction>>(1) // (2)
    override fun getTransactions(): Flow<List<Account>> {
    }

    override fun getTransaction(id: UUID): Flow<Account?> {
    }

    override suspend fun upsert(transaction: Account) {
    }

    override suspend fun delete(id: UUID) {
    }

}
