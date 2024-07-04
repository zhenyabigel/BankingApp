package by.zhenyabigel.bankingapplication.presentation.screens.transaction_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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

import by.zhenyabigel.bankingapplication.domain.model.TransactionDomainModel
import by.zhenyabigel.bankingapplication.presentation.ui.theme.robotoFontFamily

@Composable
fun TransactionInputField(transactionDomainModel: TransactionDomainModel, onClickOkayBtn: () -> Unit) {
    var transactionCompany by remember { mutableStateOf(transactionDomainModel.company) }
    var transactionNumber by remember { mutableStateOf(transactionDomainModel.transactionNumber) }
    var transactionStatus by remember { mutableStateOf(transactionDomainModel.status) }
    var transactionAmount by remember { mutableStateOf(transactionDomainModel.amount) }
    var transactionDate by remember { mutableStateOf(transactionDomainModel.date) }

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {

            Column {
                Text(
                    "Transaction was applied in",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )
                OutlinedTextField(
                    value = transactionCompany,
                    onValueChange = { transactionCompany = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 8.dp),
                )
            }

            Column {
                Text(
                    "Transaction number",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )
                OutlinedTextField(
                    value = transactionNumber,
                    onValueChange = { transactionNumber = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 8.dp),
                )
            }
            Column {

                Text(
                    "Date",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )
                OutlinedTextField(
                    value = transactionDate,
                    onValueChange = { transactionDate = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 8.dp),
                )
            }
            Column {

                Text(
                    "Transaction status",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )
                OutlinedTextField(
                    value = transactionStatus,
                    onValueChange = { transactionStatus = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp, top = 8.dp)
                )
            }
            Column {
                Text(
                    text = "Amount",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Light,
                    fontSize = 17.sp
                )

                OutlinedTextField(
                    value = transactionAmount,
                    onValueChange = { transactionAmount = it },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedTextColor = Color.White,
                        focusedTextColor = Color.White,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 30.dp, top = 8.dp),
                )
            }

            Button(
                onClick = { onClickOkayBtn() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5)),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Okay",
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )
            }
        }
    }
}