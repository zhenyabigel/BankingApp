package by.zhenyabigel.bankingapplication.domain.model

import androidx.annotation.DrawableRes
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import java.util.UUID

data class AccountDomainModel(
    val id: UUID = UUID.randomUUID(),
    val number: String,
    val walletID: String,
    val ownerName: String,
    @DrawableRes
    val cover: Int,
)
internal fun AccountDomainModel.toEntity() = AccountEntity(
    id = id,
    number = number,
    walletID = walletID,
    ownerName = ownerName,
    coverUrl = cover
)