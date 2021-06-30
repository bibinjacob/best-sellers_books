package com.bibin.books.bookmanagement.domain

import com.bibin.books.bookmanagement.domain.entity.BookListEntity
import com.bibin.books.base.domain.entity.ResponseEntity
import com.bibin.books.bookmanagement.data.BookRepository
import io.reactivex.Single
import javax.inject.Inject

class BookListUseCase @Inject constructor(private val bookRepository: BookRepository) {

    fun getBetSellerBooks(category: String): Single<ResponseEntity<BookListEntity>> {
        return bookRepository.getBookList(category)
    }
}