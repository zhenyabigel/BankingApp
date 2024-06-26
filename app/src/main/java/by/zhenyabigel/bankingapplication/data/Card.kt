package by.zhenyabigel.bankingapplication.data

import androidx.annotation.DrawableRes
import java.util.UUID

data class Card(
    val id: UUID = UUID.randomUUID(),
    val number: String,
    val walletID: String,
    val ownerName: String,
    @DrawableRes
    val cover: Int,
)