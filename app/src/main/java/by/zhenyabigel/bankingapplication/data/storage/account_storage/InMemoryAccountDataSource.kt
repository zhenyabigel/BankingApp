package by.zhenyabigel.bankingapplication.data.storage.account_storage

import by.zhenyabigel.bankingapplication.data.model.Account
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.util.UUID

@OptIn(DelicateCoroutinesApi::class)
object InMemoryAccountDataSource : AccountDataSource {
    private val accounts = DefaultAccounts.associateBy { it.id }.toMutableMap()
    private val _accountFlow = MutableSharedFlow<Map<UUID, Account>>(1)
    init {
        GlobalScope.launch(Dispatchers.Default) {
            while (isActive) {
                _accountFlow.emit(accounts)
            }
        }
    }

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
