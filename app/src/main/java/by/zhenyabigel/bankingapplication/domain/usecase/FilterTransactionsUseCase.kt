package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.data.model.Transaction
import by.zhenyabigel.bankingapplication.domain.TransactionRepository
import by.zhenyabigel.bankingapplication.domain.model.DateRange
import by.zhenyabigel.bankingapplication.domain.utils.DateUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FilterTransactionsUseCase(private val repository: TransactionRepository) {
    fun execute(dateRange: DateRange): Flow<List<Transaction>> {
        return repository.getTransactions().map { transactions ->
            transactions.filter { transaction ->
                val transactionDate = DateUtils.parseDate(transaction.date)
                transactionDate != null && transactionDate in dateRange.startDate..dateRange.endDate
            }
        }
    }
}