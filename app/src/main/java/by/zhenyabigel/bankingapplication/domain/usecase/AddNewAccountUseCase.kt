package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository

class AddNewAccountUseCase(private val repository: AccountsRepository) {

    suspend operator fun invoke(accountDomainModel: AccountDomainModel) =
        repository.upsert(accountDomainModel)
}