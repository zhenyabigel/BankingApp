package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository

class AddNewAccountUseCase(private val repository: AccountsRepository) {

    suspend operator fun invoke(accountDomainModel: AccountDomainModel) =
        repository.upsert(accountDomainModel)
}