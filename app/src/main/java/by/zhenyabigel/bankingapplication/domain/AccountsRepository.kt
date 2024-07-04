package by.zhenyabigel.bankingapplication.domain

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface AccountsRepository {
    fun getAccounts(): Flow<List<AccountDomainModel>>
    fun getAccount(id: UUID): Flow<AccountDomainModel?>
    suspend fun upsert(accountDomainModel: AccountDomainModel)
    suspend fun delete(id: UUID)
}