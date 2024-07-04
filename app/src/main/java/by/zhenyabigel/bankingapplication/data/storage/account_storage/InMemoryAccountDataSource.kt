package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.domain.model.Account
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import java.util.UUID

object InMemoryAccountDataSource : AccountDataSource {
    private val accounts = DefaultAccounts.associateBy { it.id }.toMutableMap()
    private val _accountFlow = MutableSharedFlow<Map<UUID, Account>>(1)
    override fun getAccounts(): Flow<List<Account>> {
        return _accountFlow.asSharedFlow().map { it.values.toList() }
    }

    override fun getAccount(id: UUID): Flow<Account?> {
        return _accountFlow.asSharedFlow().map { it[id] }
    }

    override suspend fun upsert(account: Account) {
        accounts[account.id] = account
    }

    override suspend fun delete(id: UUID) {
        accounts.remove(id)
    }
}
