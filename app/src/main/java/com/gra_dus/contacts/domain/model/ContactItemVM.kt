package com.gra_dus.contacts.domain.model

import com.gra_dus.contacts.R
import com.gra_dus.contacts.databinding.ItemListBinding
import com.gra_dus.contacts.ui.main.MainFragment
import com.gra_dus.contacts.ui.main.MainViewModel
import com.gra_dus.contacts.utils.adapters.CommonItemVM
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

data class ContactItemVM(val contact: Contact) : CommonItemVM<ItemListBinding>(R.layout.item_list) {
    fun click() {
        CoroutineScope(Dispatchers.IO).launch {
            emitEvent(MainViewModel.ContactItemEvent.Click(contact.id()))
        }
    }
}