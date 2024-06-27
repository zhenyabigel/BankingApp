package by.zhenyabigel.bankingapplication.screen.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.model.Card
import by.zhenyabigel.bankingapplication.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.ui.theme.Gray
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@Composable
fun AccountSection(card: Card, onClickAccount: () -> Unit) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable { onClickAccount() }) {
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
}