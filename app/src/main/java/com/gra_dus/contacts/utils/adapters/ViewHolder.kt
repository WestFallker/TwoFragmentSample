package com.gra_dus.contacts.utils.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.gra_dus.contacts.BR

class ViewHolder(root: View) : RecyclerView.ViewHolder(root) {
    fun bind(vm: ItemVM) {
        vm.getBinding(itemView)?.setVariable(BR.vm, vm)
    }
}