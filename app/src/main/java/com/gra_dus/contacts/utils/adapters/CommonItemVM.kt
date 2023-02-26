package com.gra_dus.contacts.utils.adapters

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.channels.Channel

open class CommonItemVM<BINDING : ViewDataBinding>(@LayoutRes private val layoutId: Int) : ItemVM {

    var binding: BINDING? = null

    override fun getLayout() = layoutId
    override var observableEvents = Channel<Any>()

    open suspend fun emitEvent(value: Any) {
        observableEvents.send(value)
    }

    override fun getBinding(view: View): ViewDataBinding? {
        return try {
            binding = DataBindingUtil.bind(view)
            binding
        } catch (e: BindingException) {
            null
        }
    }

    override fun areItemsTheSame(oldItem: ItemVM) = this == oldItem

    override fun areContentsTheSame(oldItem: ItemVM) = this == oldItem

    class BindingException(message: String) : Exception(message)
}