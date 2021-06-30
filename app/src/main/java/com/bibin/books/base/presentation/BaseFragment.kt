package com.bibin.books.base.presentation

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bibin.books.di.Injectable
import javax.inject.Inject

open class BaseFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

}