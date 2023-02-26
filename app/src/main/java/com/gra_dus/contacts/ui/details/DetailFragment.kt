package com.gra_dus.contacts.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gra_dus.contacts.BR
import com.gra_dus.contacts.R
import com.gra_dus.contacts.databinding.FragmentDetailsBinding
import com.gra_dus.contacts.ui.main.MainFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {
    companion object {
        fun newInstance(id: Int): Fragment = DetailFragment().apply {
            arguments = bundleOf("id" to id)
        }
    }

    private lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_details, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.vm, viewModel)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setItem(arguments?.get("id") as Int)
    }

}