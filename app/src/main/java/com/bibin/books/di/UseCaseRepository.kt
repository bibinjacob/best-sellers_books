package com.bibin.books.di

import com.bibin.books.base.data.network.RepoService
import com.bibin.books.bookmanagement.data.BookRepository
import com.bibin.books.bookmanagement.domain.BookListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseRepository {

    @Singleton
    @Provides
    fun provideBookRepository(bookRepository: BookRepository): BookListUseCase {
        return BookListUseCase(bookRepository)
    }
}