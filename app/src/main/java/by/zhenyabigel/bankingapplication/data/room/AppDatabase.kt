package by.zhenyabigel.bankingapplication.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.zhenyabigel.bankingapplication.data.dao.AccountDao
import by.zhenyabigel.bankingapplication.data.dao.TransactionDao
import by.zhenyabigel.bankingapplication.data.entities.AccountEntity
import by.zhenyabigel.bankingapplication.data.entities.TransactionEntity

@Database(entities = [AccountEntity::class, TransactionEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun accountDao(): AccountDao

    abstract fun transactionDao(): TransactionDao
}

fun AppDatabase(context: Context) = Room.databaseBuilder( // Builder pattern
    context, AppDatabase::class.java, "banking_database"
).fallbackToDestructiveMigration().build()