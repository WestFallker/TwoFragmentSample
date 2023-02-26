package com.gra_dus.contacts.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.gra_dus.contacts.BR
import com.gra_dus.contacts.R
import com.gra_dus.contacts.databinding.FragmentMainBinding
import com.gra_dus.contacts.ui.details.DetailFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.fragment_main, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            setVariable(BR.vm, viewModel)
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.screenFlow.collect { fragment ->
                activity?.supportFragmentManager?.beginTransaction()?.run {
                    setReorderingAllowed(true)
                    replace(R.id.container, fragment, fragment.tag)
                    addToBackStack(fragment.tag)
                    commit()
                }
            }
        }

    }

}