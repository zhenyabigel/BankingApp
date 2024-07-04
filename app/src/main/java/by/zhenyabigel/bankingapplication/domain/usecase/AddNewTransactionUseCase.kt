package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddNewTransactionUseCase(private val repository: TransactionRepository) {

    suspend operator fun invoke(transaction: TransactionDomainModel) =   withContext(Dispatchers.Default) {
        repository.upsert(transaction)
}}