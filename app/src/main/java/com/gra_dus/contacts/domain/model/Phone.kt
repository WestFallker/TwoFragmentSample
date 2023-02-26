package com.gra_dus.contacts.domain.model

data class Phone(
    val assignment: String,
    val numbers: String
)

fun Phone.toItemVm(): PhoneItemVM {
    return PhoneItemVM(this)
}