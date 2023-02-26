package com.gra_dus.contacts.domain.model

data class PersonName(
    val fistName: String,
    val secondName: String
) {
    val fullName = "$fistName $secondName"
}