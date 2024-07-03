package by.zhenyabigel.bankingapplication.domain.model

import by.zhenyabigel.bankingapplication.data.model.Transaction
import java.util.UUID

data class TransactionDomainModel(
    val id: UUID = UUID.randomUUID(),
    val company: String,
    val transactionNumber: String,
    val date: String,
    val status: String,
    val amount: String
)

internal fun Transaction.toDomain() = TransactionDomainModel(
    id = id,
    company = company,
    transactionNumber = transactionNumber,
    date = date,
    status = status,
    amount = amount
)

internal fun TransactionDomainModel.toData() = Transaction(
    id = id,
    company = company,
    transactionNumber = transactionNumber,
    date = date,
    status = status,
    amount = amount
)