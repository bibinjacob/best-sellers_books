package com.bibin.books.di

import com.bibin.books.base.data.network.RepoService
import com.bibin.books.bookmanagement.data.BookRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideBookRepository(repoService: RepoService): BookRepository {
        return BookRepository(repoService)
    }
}