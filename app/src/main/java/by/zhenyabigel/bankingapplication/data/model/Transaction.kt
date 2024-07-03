package by.zhenyabigel.bankingapplication.data.model

import by.zhenyabigel.bankingapplication.data.entities.TransactionEntity
import java.util.UUID

data class Transaction (
    val id: UUID = UUID.randomUUID(),
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)

internal fun Transaction.toData() = TransactionEntity(
    id = id,
    company = company,
    transactionNumber = transactionNumber,
    date = date,
    status = status,
    amount = amount.toInt()
)