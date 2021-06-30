package com.bibin.books.base.data.network.entity

import com.bibin.books.base.domain.entity.ResponseEntity
import com.bibin.books.bookmanagement.data.entity.BooksData
import com.bibin.books.bookmanagement.data.entity.BooksListData
import com.bibin.books.bookmanagement.domain.entity.BookListEntity
import com.bibin.books.bookmanagement.domain.entity.BooksEntity

fun ResponseData<BooksListData>.mapToBookListEntity(): ResponseEntity<BookListEntity> {
    return ResponseEntity(
        results = this.results?.mapToResultEntity(),
        message = this.message,
        statusCode = this.statusCode,
        status = this.status,
        errors = this.errors
    )
}

fun BooksListData.mapToResultEntity(): BookListEntity {
    return BookListEntity(
        display_name = this.display_name,
        books = this.books.map {
            it.mapToEntityData()
        }
    )
}

private fun BooksData.mapToEntityData(): BooksEntity {
    return BooksEntity(
        rank = this.rank ?: 0,
        publisher = this.publisher ?: "",
        author = this.author ?: "",
        description = this.description ?: "",
        title = this.title,
        book_image = this.book_image
    )
}