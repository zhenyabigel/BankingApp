package by.zhenyabigel.bankingapplication.data.model

import java.util.UUID

data class Transaction (
    val id: UUID = UUID.randomUUID(),
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)