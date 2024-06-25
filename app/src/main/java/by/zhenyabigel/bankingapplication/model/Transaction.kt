package by.zhenyabigel.bankingapplication.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Transaction (
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)