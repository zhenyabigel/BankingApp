package by.zhenyabigel.bankingapplication.presentation.screens.view_all_transactions_screen

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
import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.presentation.screens.home_screen.TransactionItem
import by.zhenyabigel.bankingapplication.presentation.ui.theme.LightGray

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewAllTransactionList(transactionDomainModels: List<TransactionDomainModel>) {
    val listState = rememberLazyListState()
    val flingBehavior = rememberSnapFlingBehavior(listState)

    LazyColumn(
        state = listState,
        flingBehavior = flingBehavior,
        modifier = Modifier.padding(top = 7.dp),
        contentPadding = PaddingValues(all = 5.dp),
        verticalArrangement = Arrangement.spacedBy(1.dp)
    ) {
        itemsIndexed(items = transactionDomainModels) { index, item ->
            TransactionItem(transactionDomainModel = item, {})
            if (index < transactionDomainModels.lastIndex) Divider(
                color = LightGray,
                thickness = 0.7.dp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}