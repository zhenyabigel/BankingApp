package by.zhenyabigel.bankingapplication.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = AccountEntity.TABLE_NAME)
data class AccountEntity(
    @PrimaryKey val id: UUID,
    @ColumnInfo(name = "number") val number: String,
    @ColumnInfo(name = "wallet_id") val walletID: String,
    @ColumnInfo(name = "owner_name") val ownerName: String,
    @ColumnInfo(name = "cover_url") val coverUrl: Int
) {
    internal companion object {
        const val TABLE_NAME = "account_table"
    }
}
