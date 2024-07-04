package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository
import kotlinx.coroutines.flow.Flow

class GetAllAccountsUseCase(private val accountsRepository: AccountsRepository) {

    operator fun invoke(): Flow<List<AccountDomainModel>> {
        return accountsRepository.getAccounts()
    }
}