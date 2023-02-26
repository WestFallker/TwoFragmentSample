package com.gra_dus.contacts.ui.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gra_dus.contacts.data.Repository
import com.gra_dus.contacts.domain.model.Contact
import com.gra_dus.contacts.domain.model.toItemVM
import com.gra_dus.contacts.ui.details.DetailFragment
import com.gra_dus.contacts.utils.adapters.CommonAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : ViewModel() {

    private val screenChannel = Channel<Fragment>()
    val screenFlow = screenChannel.receiveAsFlow()

    val adapter = CommonAdapter()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val list = getList().map { it.toItemVM() }
            withContext(Dispatchers.Main) {
                adapter.submitList(list)
            }
            adapter.observableEvents.receiveAsFlow().collect {
                observeEvents(it)
            }
        }
    }

    private suspend fun getList(): List<Contact> {
        return Repository.getList()
    }

    private fun navigateToDetails(id: Int) {
        viewModelScope.launch {
            screenChannel.send(DetailFragment.newInstance(id))
        }
    }

    private fun observeEvents(event: Any) {
        if (event is ContactItemEvent.Click) {
            navigateToDetails(event.id)
        }
    }

    sealed class ContactItemEvent {
        data class Click(val id: Int) : ContactItemEvent()
    }

}