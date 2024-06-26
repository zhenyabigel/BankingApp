package by.zhenyabigel.bankingapplication.data


import by.zhenyabigel.bankingapplication.R

val transactions = listOf(
    Transaction(
        company = "OOO “Company”",
        number = "e4f8b1c4-1d5d-4b5e-9c39-dcd1e4f4dbf2",
        date = "01.06.2024",
        status = "Executed",
        amount = "$23.45"
    ),
    Transaction(
        company = "LLC “Business”",
        number = "2f9d3c8b-6d7f-4d4e-8a4c-6b9d2f3e5a7c",
        date = "01.06.2024",
        status = "Executed",
        amount = "$47.89"
    ),
    Transaction(
        company = "Inc “Enterprise”",
        number = "5e1f3d4b-9c3d-4d4f-9a2e-4b3e5d6f7a8c",
        date = "01.06.2024",
        status = "Declined",
        amount = "$12.34"
    ),
    Transaction(
        company = "GmbH “Firm”",
        number = "8f2e1d3c-4b5d-6f7a-8c9e-1d2f3g4h5i6j",
        date = "01.06.2024",
        status = "In progress",
        amount = "$56.78"
    ),
    Transaction(
        company = "Ltd “Corporation”",
        number = "1d2e3f4g-5h6i-7j8k-9l0m-1n2o3p4q5r6s",
        date = "01.06.2024",
        status = "In progress",
        amount = "$34.56"
    )
)

val cards = listOf(
    Card(
        number = "123456781234",
        walletID = "4055",
        ownerName = "Owner A",
        cover = R.drawable.card
    ),
    Card(
        number = "234567892345",
        walletID = "2099",
        ownerName = "Owner B",
        cover = R.drawable.card
    ),
    Card(
        number = "345689034567",
        walletID = "8899",
        ownerName = "Owner C",
        cover = R.drawable.card
    )
)