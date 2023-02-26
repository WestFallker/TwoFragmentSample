package com.gra_dus.contacts.domain.model

import com.gra_dus.contacts.R
import com.gra_dus.contacts.databinding.ItemListBinding
import com.gra_dus.contacts.utils.adapters.CommonItemVM

data class PhoneItemVM(val phone: Phone) : CommonItemVM<ItemListBinding>(R.layout.item_phone)