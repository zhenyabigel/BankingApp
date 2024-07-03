package by.zhenyabigel.bankingapplication.data.model

import androidx.annotation.DrawableRes
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import java.util.UUID

data class Account(
    val id: UUID = UUID.randomUUID(),
    val number: String,
    val walletID: String,
    val ownerName: String,
    @DrawableRes
    val cover: Int,
)
internal fun Account.toEntity() = AccountEntity(
    id = id,
    number = number,
    walletID = walletID,
    ownerName = ownerName,
    coverUrl = cover
)