package com.gra_dus.contacts.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gra_dus.contacts.data.Repository
import com.gra_dus.contacts.domain.model.Contact
import com.gra_dus.contacts.domain.model.toItemVm
import com.gra_dus.contacts.utils.adapters.CommonAdapter
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    val item: MutableLiveData<Contact> = MutableLiveData()

    val adapter = CommonAdapter()

    fun setItem(id: Int) {
        viewModelScope.launch {
            item.value = Repository.getItem(id)
            adapter.submitList(item.value?.phones?.map { it.toItemVm() })
        }
    }
}