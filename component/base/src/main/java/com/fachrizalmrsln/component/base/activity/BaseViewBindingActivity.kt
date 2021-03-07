@file:Suppress("unused")

package com.fachrizalmrsln.component.base.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingActivity<VB : ViewBinding> : BaseActivity() {

    private var _binding: VB? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    protected val binding: VB
        get() = requireNotNull(_binding)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(requireNotNull(_binding).root)
        setupComponent()
    }

}