package by.zhenyabigel.bankingapplication.data.storage.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.model.Transaction
import java.util.UUID

@Entity(tableName = TransactionEntity.TABLE_NAME)
data class TransactionEntity(
    @PrimaryKey val id: UUID,
    @ColumnInfo(name = "company") val company: String,
    @ColumnInfo(name = "transaction_number") val transactionNumber: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "amount") val amount: Int
) {
    internal companion object {
        const val TABLE_NAME = "transaction_table" // <- удобно потом ссылаться будет
    }

    fun toTransaction(): Transaction {
        return Transaction(
            id = id,
            company = company,
            status=status,
            transactionNumber = transactionNumber,
            date = date,
            amount = amount.toString()
        )
    }

}
