package com.bibin.books.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bibin.books.bookmanagement.presentation.BookListViewModel
import com.bibin.books.splash.presentation.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookListViewModel::class)
    abstract fun bindBookListViewModel(bookListViewModel: BookListViewModel): ViewModel
}