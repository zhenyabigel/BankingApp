package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import java.util.UUID

object InMemoryAccountDataSource : AccountDataSource {
    private val accounts = DefaultAccountDomainModels.associateBy { it.id }.toMutableMap()
    private val _accountDomainModelFlow = MutableSharedFlow<Map<UUID, AccountDomainModel>>(1)
    override fun getAccounts(): Flow<List<AccountDomainModel>> {
        return _accountDomainModelFlow.asSharedFlow().map { it.values.toList() }
    }

    override fun getAccount(id: UUID): Flow<AccountDomainModel?> {
        return _accountDomainModelFlow.asSharedFlow().map { it[id] }
    }

    override suspend fun upsert(accountDomainModel: AccountDomainModel) {
        accounts[accountDomainModel.id] = accountDomainModel
    }

    override suspend fun delete(id: UUID) {
        accounts.remove(id)
    }
}
