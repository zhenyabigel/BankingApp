package by.zhenyabigel.bankingapplication.data.repository

import by.zhenyabigel.bankingapplication.data.datasource.AccountDataSource
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.AccountsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.UUID

class AccountRepositoryImpl(private val accountDataSource: AccountDataSource) : AccountsRepository {

    override fun getAccounts(): Flow<List<AccountDomainModel>> = flow {
        val accountDomainModels = accountDataSource.getAccountsList().map {
            AccountDomainModel(
                id = it.id,
                number = it.number,
                walletID = it.walletID,
                ownerName = it.ownerName,
                cover = it.coverUrl
            )
        }

        emit(accountDomainModels)
    }

    override fun getAccount(id: UUID): Flow<AccountDomainModel?> = flow {
        val accountEntity = accountDataSource.getAccount(id)

        emit(
            AccountDomainModel(
                id = accountEntity.id,
                number = accountEntity.number,
                walletID = accountEntity.walletID,
                ownerName = accountEntity.ownerName,
                cover = accountEntity.coverUrl
            )
        )
    }

    override suspend fun upsert(accountDomainModel: AccountDomainModel) {
        accountDataSource.upsert(
            AccountEntity(
                id = accountDomainModel.id,
                number = accountDomainModel.number,
                walletID = accountDomainModel.walletID,
                ownerName = accountDomainModel.ownerName,
                coverUrl = accountDomainModel.cover
            )
        )
    }

    override suspend fun delete(id: UUID) {
        accountDataSource.delete(id)
    }
}