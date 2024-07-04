package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel

class AddNewTransactionUseCase(private val repository: TransactionRepository) {

    suspend operator fun invoke(transaction: TransactionDomainModel) =
        repository.upsert(transaction)
}