package by.zhenyabigel.bankingapplication.data

import by.zhenyabigel.bankingapplication.R
import by.zhenyabigel.bankingapplication.domain.model.AccountDomainModel

val accountDomainModels = listOf(
    AccountDomainModel(
        number = "123456781234",
        walletID = "4055",
        ownerName = "Owner A",
        cover = R.drawable.card
    ),
    AccountDomainModel(
        number = "234567892345",
        walletID = "2099",
        ownerName = "Owner B",
        cover = R.drawable.card
    ),
    AccountDomainModel(
        number = "345689034567",
        walletID = "8899",
        ownerName = "Owner C",
        cover = R.drawable.card
    )
)