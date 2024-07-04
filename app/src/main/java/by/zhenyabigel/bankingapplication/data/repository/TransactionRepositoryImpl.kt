package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.TransactionDataSource
import by.zhenyabigel.bankingapplication.domain.model.Transaction
import by.zhenyabigel.bankingapplication.domain.model.toData
import by.zhenyabigel.bankingapplication.domain.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class TransactionRepositoryImpl(private val transactionDataSource: TransactionDataSource) :
    TransactionRepository {

    override fun getTransactions(): Flow<List<Transaction>> = flow {
        val transactions = transactionDataSource.getTransactions().map {
            Transaction(
                id = it.id,
                company = it.company,
                transactionNumber = it.transactionNumber,
                date = it.date,
                status = it.status,
                amount = it.amount.toString()
            )
        }

        emit(transactions)
    }

    override fun getTransaction(id: UUID): Flow<Transaction?> = flow {
        val transaction = transactionDataSource.getTransaction(id)

        emit(
            Transaction(
                id = transaction.id,
                company = transaction.company,
                transactionNumber = transaction.transactionNumber,
                date = transaction.date,
                status = transaction.status,
                amount = transaction.amount.toString()
            )
        )
    }

    override suspend fun upsert(transaction: Transaction) {
        transactionDataSource.upsert(transaction.toData())
    }

    override suspend fun delete(id: UUID) {
        transactionDataSource.delete(id)
    }
}