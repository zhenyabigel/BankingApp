package by.zhenyabigel.bankingapplication.domain.usecase

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.domain.repository.TransactionRepository
import by.zhenyabigel.bankingapplication.domain.utils.DateUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date

class FilterTransactionsUseCase(private val repository: TransactionRepository) {

    fun execute(startDate: Date, endDate: Date): Flow<List<TransactionDomainModel>> {
        return repository.getTransactions().map { transactions ->
            transactions.filter { transaction ->
                val transactionDate = DateUtils.parseDate(transaction.date)

                transactionDate != null && transactionDate in startDate..endDate
            }
        }
    }
}