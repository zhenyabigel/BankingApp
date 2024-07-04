package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class GetTransactionByIdUseCase(private val transactionRepository: TransactionRepository) {

    operator fun invoke(id:UUID): Flow<TransactionDomainModel?> {
        return transactionRepository.getTransaction(id)
    }
}