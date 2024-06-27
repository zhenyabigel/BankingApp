package by.zhenyabigel.bankingapplication.screen.view_all_transactions_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import by.zhenyabigel.bankingapplication.model.Transaction
import by.zhenyabigel.bankingapplication.screen.home_screen.TransactionItem
import by.zhenyabigel.bankingapplication.ui.theme.LightGray

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewAllTransactionList(transactions: List<Transaction>) {
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(listState)

    LazyColumn(
        state = listState,
        flingBehavior = flingBehavior,
        modifier = Modifier.padding(top = 7.dp),
        contentPadding = PaddingValues(all = 5.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        itemsIndexed(items = transactions) { index, item ->
            TransactionItem(transaction = item, {})
            if (index < transactions.lastIndex) Divider(
                color = LightGray,
                thickness = 0.7.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}