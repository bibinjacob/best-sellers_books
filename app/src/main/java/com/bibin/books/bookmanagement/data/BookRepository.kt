package com.bibin.books.bookmanagement.data

import com.bibin.books.BuildConfig
import com.bibin.books.base.data.network.RepoService
import com.bibin.books.base.data.network.entity.mapToBookListEntity
import com.bibin.books.bookmanagement.domain.entity.BookListEntity
import com.bibin.books.base.domain.entity.ResponseEntity
import io.reactivex.Single
import javax.inject.Inject

class BookRepository @Inject constructor(private var repoService: RepoService) {

    fun getBookList(category: String): Single<ResponseEntity<BookListEntity>> {

        return repoService.getBookList(category, BuildConfig.API_KEY).map {
            it.mapToBookListEntity()
        }
    }
}