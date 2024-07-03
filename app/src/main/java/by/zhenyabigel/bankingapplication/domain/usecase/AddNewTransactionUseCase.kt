package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.TransactionRepository
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.model.toData

class AddNewTransactionUseCase(private val repository: TransactionRepository) {
    suspend operator fun invoke(transaction: TransactionDomainModel) =
        repository.upsert(transaction.toData())
}