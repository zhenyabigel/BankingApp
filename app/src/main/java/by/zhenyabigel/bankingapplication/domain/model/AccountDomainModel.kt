package by.zhenyabigel.bankingapplication.domain.model

import androidx.annotation.DrawableRes
import by.zhenyabigel.bankingapplication.data.model.Account
import java.util.UUID

data class AccountDomainModel(
    val id: UUID = UUID.randomUUID(),
    val number: String,
    val walletID: String,
    val ownerName: String,
    @DrawableRes
    val cover: Int,
)
internal fun Account.toDomain() = AccountDomainModel(
    id = id,
    number = number,
    walletID = walletID,
    ownerName = ownerName,
    cover = cover
)
internal fun AccountDomainModel.toData() = Account(
    id = id,
    number = number,
    walletID = walletID,
    ownerName = ownerName,
    cover = cover
)