package by.zhenyabigel.bankingapplication.screens.transaction_screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import by.zhenyabigel.bankingapplication.data.Transaction
import by.zhenyabigel.bankingapplication.ui.theme.robotoFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransactionInputField(transaction: Transaction){
    var transactionCompany by remember { mutableStateOf(transaction.company) }
    var transactionNumber by remember { mutableStateOf(transaction.number) }
    var transactionStatus by remember { mutableStateOf(transaction.status) }
    var transactionAmount by remember { mutableStateOf(transaction.amount) }
    var transactionDate by remember { mutableStateOf(transaction.date) }
    OutlinedTextField(
        value = transactionCompany,
        onValueChange = { transactionCompany = it },
        label = {
            Text(
                "Transaction was applied in",
                color = Color.White,
                fontFamily = robotoFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            ) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.Gray,
        )
    )

    OutlinedTextField(
        value = transactionNumber,
        onValueChange = { transactionNumber = it },
        label = {
            Text(
                "Transaction number",
                color = Color.White) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    )

    OutlinedTextField(
        value = transactionDate,
        onValueChange = { transactionDate = it },
        label = { Text("Date", color = Color.White) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    )

    OutlinedTextField(
        value = transactionStatus,
        onValueChange = { transactionStatus = it },
        label = { Text("Transaction status", color = Color.White) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
    )

    OutlinedTextField(
        value = transactionAmount,
        onValueChange = { transactionAmount = it },
        label = { Text("Amount", color = Color.White) },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
    )

    Button(
        onClick = { /* Handle click */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(text = "Okay", color = Color.White, fontSize = 16.sp)
    }
}