package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.TransactionDataSource
import by.zhenyabigel.bankingapplication.data.entities.TransactionEntity
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class TransactionRepositoryImpl(private val transactionDataSource: TransactionDataSource) :
    TransactionRepository {

    override fun getTransactions(): Flow<List<TransactionDomainModel>> = flow {
        val transactionDomainModels = transactionDataSource.getTransactions().map {
            TransactionDomainModel(
                id = it.id,
                company = it.company,
                transactionNumber = it.transactionNumber,
                date = it.date,
                status = it.status,
                amount = it.amount.toString()
            )
        }

        emit(transactionDomainModels)
    }

    override fun getTransaction(id: UUID): Flow<TransactionDomainModel?> = flow {
        val transaction = transactionDataSource.getTransaction(id)

        emit(
            TransactionDomainModel(
                id = transaction.id,
                company = transaction.company,
                transactionNumber = transaction.transactionNumber,
                date = transaction.date,
                status = transaction.status,
                amount = transaction.amount.toString()
            )
        )
    }

    override suspend fun upsert(transactionDomainModel: TransactionDomainModel) {
        transactionDataSource.upsert(
            TransactionEntity(
                id = transactionDomainModel.id,
                company = transactionDomainModel.company,
                transactionNumber = transactionDomainModel.transactionNumber,
                date = transactionDomainModel.date,
                status = transactionDomainModel.status,
                amount = transactionDomainModel.amount.toInt()
            )
        )
    }

    override suspend fun delete(id: UUID) {
        transactionDataSource.delete(id)
    }
}