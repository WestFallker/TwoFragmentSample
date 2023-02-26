package com.gra_dus.contacts.domain.model

data class Contact(
    val name: PersonName,
    val avatarUrl: String,
    val phones: List<Phone>
) {
    fun id(): Int {
        return hashCode()
    }
}

fun Contact.toItemVM(): ContactItemVM {
    return ContactItemVM(this)
}