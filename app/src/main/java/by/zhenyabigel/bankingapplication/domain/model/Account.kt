package by.zhenyabigel.bankingapplication.domain.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Account(
    val id: UUID = UUID.randomUUID(),
    val number: String,
    val walletID: String,
    val ownerName: String,
    @DrawableRes
    val cover: Int,
)