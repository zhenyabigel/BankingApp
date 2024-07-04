package by.zhenyabigel.bankingapplication.data.datasource

import by.zhenyabigel.bankingapplication.data.dao.TransactionDao
import by.zhenyabigel.bankingapplication.data.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class TransactionDataSource(private val transactionDao: TransactionDao) {

    fun getTransactionsAsFlow(): Flow<List<TransactionEntity>> = transactionDao.getListAsFlow()

    fun getTransactions(): List<TransactionEntity> = transactionDao.getList()

    fun getTransactionAsFlow(id: UUID): Flow<TransactionEntity> = transactionDao.getItemAsFlow(id)

    fun getTransaction(id: UUID): TransactionEntity = transactionDao.getItem(id)

    suspend fun upsert(transaction: TransactionEntity) {
        transactionDao.save(transaction)
    }

    suspend fun delete(id: UUID) {
        transactionDao.delete(id)
    }
}