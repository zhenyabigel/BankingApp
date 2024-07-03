package by.zhenyabigel.bankingapplication.data.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface AccountDao {
    @Query("SELECT * FROM ${AccountEntity.TABLE_NAME}")
    fun getList(): List<AccountEntity>
    @Query("SELECT * FROM ${AccountEntity.TABLE_NAME}")
    fun getListAsFlow(): Flow<List<AccountEntity>>
    @Query("SELECT * FROM ${AccountEntity.TABLE_NAME} WHERE id=:id ")
    fun getItem(id: UUID): AccountEntity
    @Query("SELECT * FROM ${AccountEntity.TABLE_NAME} WHERE id=:id ")
    fun getItemAsFlow(id: UUID): Flow<AccountEntity>
    @Upsert // INSERT OR REPLACE в БД
    suspend fun save(e: AccountEntity)
    @Query("DELETE FROM ${AccountEntity.TABLE_NAME} WHERE id = :id")
    suspend fun delete(id: UUID)
}