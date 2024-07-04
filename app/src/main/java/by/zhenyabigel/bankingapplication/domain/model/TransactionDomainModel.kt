package by.zhenyabigel.bankingapplication.domain.model

import java.util.UUID

data class TransactionDomainModel (
    val id: UUID = UUID.randomUUID(),
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)
