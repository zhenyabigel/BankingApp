package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.model.Transaction
import by.zhenyabigel.bankingapplication.data.storage.dao.TransactionDao
import by.zhenyabigel.bankingapplication.domain.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class TransactionRepositoryImpl(
    private val dao: TransactionDao
) : TransactionRepository {
    override fun getTransactions(): Flow<List<Transaction>> = dao.getTransactions()
    override fun getTransaction(id: UUID): Flow<Transaction?> = dao.getTransaction(id)
    override suspend fun upsert(transaction: Transaction) {
        upsert(transaction)
    }
    override suspend fun delete(id: UUID) {
        delete(id)
    }
}