package by.zhenyabigel.bankingapplication.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.model.Card
import by.zhenyabigel.bankingapplication.model.Transaction
import by.zhenyabigel.bankingapplication.model.cards
import by.zhenyabigel.bankingapplication.model.transactions
import by.zhenyabigel.bankingapplication.ui.theme.Blue
import by.zhenyabigel.bankingapplication.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.ui.theme.Gray
import by.zhenyabigel.bankingapplication.ui.theme.Green
import by.zhenyabigel.bankingapplication.ui.theme.LightGray
import by.zhenyabigel.bankingapplication.ui.theme.Maroon
import by.zhenyabigel.bankingapplication.ui.theme.Yellow
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun HomeScreen() {
    val accounts = cards
    val transactions = transactions
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 16.dp)
            .padding(top = 40.dp)
    ){
        AccountSection(accounts[1])
        Spacer(modifier = Modifier.height(16.dp))
        TransactionSection(transactions)
        Spacer(modifier = Modifier.height(16.dp))
        Footer()
    }
}


@Composable
fun AccountSection(card: Card) {
    Column {
        Text(
            text = "Account",
            fontFamily = robotoFontFamily,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.height(26.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(15.dp))
                .background(DarkGray)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.45f),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(card.cover),
                        contentDescription = "card image",
                        modifier = Modifier
                            .width(40.dp)
                            .height(25.dp)
                    )
                    Column(
                        modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Saving account",
                            fontFamily = robotoFontFamily,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                        Text(
                            text = card.number,
                            fontFamily = robotoFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Gray,
                            fontSize = 13.sp
                        )
                        Text(
                            text = "•••• " + card.walletID,
                            fontFamily = robotoFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = Gray,
                            fontSize = 13.sp
                        )
                    }
                }
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow),
                    contentDescription = "image arrow forward"
                )
            }
        }
    }
}

@Composable
fun TransactionSection(transactions: List<Transaction>) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Transactions",
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White,
                fontSize = 28.sp
            )
            Text(
                text = "VIEW ALL",
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Blue,
                fontSize = 13.sp
            )
        }

        Spacer(modifier = Modifier.height(26.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(DarkGray)
        ) {
            LazyColumn(
                modifier = Modifier.padding(top = 7.dp),
                contentPadding = PaddingValues(all = 5.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                itemsIndexed(items = transactions) { index, item ->
                    TransactionItem(transaction = item)
                    if (index < transactions.lastIndex)
                        Divider(
                            color = LightGray,
                            thickness = 0.7.dp,
                            modifier = Modifier
                                .padding(horizontal = 16.dp))
                }
            }
        }
    }
}

fun getColorForStatus(status: String): Color {
    return when (status) {
        "Executed" -> Green
        "In progress" -> Yellow
        "Declined" -> Maroon
        else -> Color.Gray // Цвет по умолчанию
    }
}
@Composable
fun TransactionItem(transaction: Transaction) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier, verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = transaction.company,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Text(
                    text = transaction.date,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = Gray,
                    fontSize = 13.sp
                )
                Text(
                    text =transaction.status,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = getColorForStatus(transaction.status),
                    fontSize = 13.sp
                )
            }
            Row {
                Text(
                    text = transaction.amount,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 17.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_baseline_arrow_dark),
                    contentDescription = "image arrow forward"
                )
            }

        }
    }
}

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        contentAlignment = Alignment.BottomEnd
       ){
        Image(
            painter = painterResource(id = R.drawable.group_277133801),
            contentDescription = "")
    }
   }

