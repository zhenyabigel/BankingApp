package by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import by.zhenyabigel.bankingapplication.ui.theme.Blue
import by.zhenyabigel.bankingapplication.ui.theme.DarkGray
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerDialog(
    onDismissRequest: () -> Unit, onDateSelected: (LocalDate) -> Unit
) {
    val datePickerState = rememberDatePickerState()
    val datePickerColors = DatePickerDefaults.colors(
        containerColor = DarkGray,
        titleContentColor = Color.White,
        headlineContentColor = Color.White,
        weekdayContentColor = Color.LightGray.copy(alpha = 0.38f),
        subheadContentColor = Color.White,
        yearContentColor = Color.White,
        currentYearContentColor = Color.White,
        selectedYearContentColor = Color.White,
        selectedYearContainerColor = DarkGray,
        dayContentColor = Color.White,
        disabledDayContentColor = Color.White.copy(alpha = 0.38f),
        selectedDayContentColor = Color.Blue,
        disabledSelectedDayContentColor = Color.White.copy(alpha = 0.38f),
        selectedDayContainerColor = DarkGray,
        disabledSelectedDayContainerColor = DarkGray.copy(alpha = 0.38f),
        todayContentColor = Color.White,
        todayDateBorderColor = Color.White,
        dayInSelectionRangeContentColor = Color.White,
        dayInSelectionRangeContainerColor = DarkGray
    )
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray)
                .fillMaxWidth()// Add a white background
        ) {
            DatePicker(
                state = datePickerState, showModeToggle = true, colors = datePickerColors
            )
            Button(modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Blue
                ),
                onClick = {
                    val selectedDate = datePickerState.selectedDateMillis?.let {
                        val instant = Instant.ofEpochMilli(it)
                        val zoneId = ZoneId.systemDefault()
                        val localDate = LocalDateTime.ofInstant(instant, zoneId).toLocalDate()
                        onDateSelected(localDate)
                    }
                    onDismissRequest()
                }) {
                Text("Submit")
            }
        }
    }

}

@Composable
@Preview
fun d() {
    DatePickerDialog({}, {})
}