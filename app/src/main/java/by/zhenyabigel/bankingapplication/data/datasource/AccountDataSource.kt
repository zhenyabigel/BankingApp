package by.zhenyabigel.bankingapplication.data.datasource

import by.zhenyabigel.bankingapplication.data.dao.AccountDao
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

class AccountDataSource(
    private val accountDao: AccountDao
) {
    fun getAccountsAsFlow(): Flow<List<AccountEntity>> = accountDao.getListAsFlow()
    fun getAccounts(): List<AccountEntity> = accountDao.getList()
    fun getAccountAsFlow(id: UUID): Flow<AccountEntity> = accountDao.getItemAsFlow(id)
    fun getAccount(id: UUID): AccountEntity = accountDao.getItem(id)
    fun getAccountsList(): List<AccountEntity> = accountDao.getList()
    suspend fun upsert(account: AccountEntity) {
        accountDao.save(account)
    }
    suspend fun delete(id: UUID) {
        accountDao.delete(id)
    }
}