package by.zhenyabigel.bankingapplication.presentation.screens.view_all_transactions_screen

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Blue
import by.zhenyabigel.bankingapplication.presentation.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.presentation.ui.theme.Gray
import by.zhenyabigel.bankingapplication.presentation.ui.theme.robotoFontFamily
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Composable
fun ViewAllTransactionsBottomSheet() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp), verticalArrangement = Arrangement.Top
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), verticalArrangement = Arrangement.Top
        ) {

            var startDateValue = remember { mutableStateOf("") }
            var endDateValue = remember { mutableStateOf("") }
            Text(
                text = "Start date",
                fontSize = 15.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            Calendar(startDateValue.value, onValueChange = { startDateValue.value = it },placeholderForInput = "Select start date")

            Text(
                text = "End date",
                fontSize = 15.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                )

            Calendar(endDateValue.value, onValueChange = { endDateValue.value = it },placeholderForInput = "Select end date")

            if(startDateValue.value.isNotBlank() && endDateValue.value.isNotBlank()){
                Button(modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(horizontal = 10.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Blue
                    ),
                    onClick = {}
                    ) {
                    Text("Submit")
                }
            }
        }


        }
    }



