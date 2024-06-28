package by.zhenyabigel.bankingapplication.screens.view_all_transactions_screen

import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.ui.theme.DarkGray
import by.zhenyabigel.bankingapplication.ui.theme.Gray
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderForInput: String
) {
    var showDialog = remember { mutableStateOf(false) }
    var selectedDate = remember { mutableStateOf(LocalDate.now()) }

    OutlinedTextField(
        value = value,
        onValueChange = { showDialog.value = true },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color.White,
            focusedTextColor = Color.White,
            errorBorderColor = Color.Red,
            focusedBorderColor = Color.Gray
        ),
        placeholder = {
            Text(
                placeholderForInput, fontSize = 15.sp,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        },
        isError = value.isBlank(),
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable { showDialog.value = true },
                painter = painterResource(id = R.drawable.ic_calendar),
                tint = Color.White,
                contentDescription = "Back button"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp, top = 8.dp)
            .clickable { showDialog.value = true  },
    )
    if (showDialog.value) {
        val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")

        DatePickerDialog(
            onDismissRequest = { showDialog.value = false },
            onDateSelected = { date ->
                selectedDate.value = date
                val formattedDate = date.format(dateFormatter)
                onValueChange(formattedDate)
            }
        )
    }
}