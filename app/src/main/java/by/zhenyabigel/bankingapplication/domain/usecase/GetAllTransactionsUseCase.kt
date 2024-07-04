package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetAllTransactionsUseCase(private val transactionRepository: TransactionRepository) {

    operator fun invoke(): Flow<List<TransactionDomainModel>> {
        return transactionRepository.getTransactions()
    }
}