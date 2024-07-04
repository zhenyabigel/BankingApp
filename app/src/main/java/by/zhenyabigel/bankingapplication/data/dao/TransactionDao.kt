package by.zhenyabigel.bankingapplication.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import by.zhenyabigel.bankingapplication.data.entities.TransactionEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface TransactionDao {

    @Query("SELECT * FROM ${TransactionEntity.TABLE_NAME}")
    fun getListAsFlow(): Flow<List<TransactionEntity>>

    @Query("SELECT * FROM ${TransactionEntity.TABLE_NAME}")
    fun getList(): List<TransactionEntity>

    @Query("SELECT * FROM ${TransactionEntity.TABLE_NAME} WHERE id=:id ")
    fun getItemAsFlow(id: UUID): Flow<TransactionEntity>

    @Query("SELECT * FROM ${TransactionEntity.TABLE_NAME} WHERE id=:id ")
    fun getItem(id: UUID): TransactionEntity

    @Upsert
    suspend fun save(e: TransactionEntity)

    @Query("DELETE FROM ${TransactionEntity.TABLE_NAME} WHERE id = :id")
    suspend fun delete(id: UUID)
}