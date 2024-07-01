package by.zhenyabigel.bankingapplication.data

import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.data.model.Account
import by.zhenyabigel.bankingapplication.data.model.Transaction

val accounts = listOf(
    Account(
        number = "123456781234",
        walletID = "4055",
        ownerName = "Owner A",
        cover = R.drawable.card
    ),
    Account(
        number = "234567892345",
        walletID = "2099",
        ownerName = "Owner B",
        cover = R.drawable.card
    ),
    Account(
        number = "345689034567",
        walletID = "8899",
        ownerName = "Owner C",
        cover = R.drawable.card
    )
)