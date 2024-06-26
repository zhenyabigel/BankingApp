package by.zhenyabigel.bankingapplication.screen.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import by.zhenyabigel.bankingapplication.R

@Composable
fun HomeFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }, contentAlignment = Alignment.BottomEnd
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_277133801), contentDescription = ""
        )
    }
}
