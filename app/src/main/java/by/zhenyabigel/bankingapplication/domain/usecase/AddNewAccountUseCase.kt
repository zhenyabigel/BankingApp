package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AddNewAccountUseCase(private val repository: AccountsRepository) {

    suspend operator fun invoke(accountDomainModel: AccountDomainModel) =
        withContext(Dispatchers.Default) {
        repository.upsert(accountDomainModel)
}}