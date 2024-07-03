package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.TransactionDataSource
import by.zhenyabigel.bankingapplication.data.model.Transaction
import by.zhenyabigel.bankingapplication.data.model.toData
import by.zhenyabigel.bankingapplication.domain.repository_interfaces.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class TransactionRepositoryImpl(
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override fun getTransactions(): Flow<List<Transaction>> = flow {
        val transactions = transactionDataSource.getTransactions().map { it.toTransaction() }
        emit(transactions)
    }
    override fun getTransaction(id: UUID): Flow<Transaction?> = flow {
        val transaction = transactionDataSource.getTransaction(id).toTransaction()
        emit(transaction)
    }
    override suspend fun upsert(transaction: Transaction) {
        transactionDataSource.upsert(transaction.toData())
    }
    override suspend fun delete(id: UUID) {
        transactionDataSource.delete(id)
    }
}