package com.bibin.books.di

import com.bibin.books.bookmanagement.presentation.BookCategoryFragment
import com.bibin.books.bookmanagement.presentation.BookListFragment
import com.bibin.books.splash.presentation.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributeBookCategoryFragment(): BookCategoryFragment

    @ContributesAndroidInjector
    abstract fun contributeBookListFragment(): BookListFragment

}