package com.bibin.books.base.domain.entity

import com.bibin.books.bookmanagement.domain.entity.BookListEntity
import com.bibin.books.bookmanagement.domain.entity.BooksEntity
import com.bibin.books.bookmanagement.presentation.entity.Book

fun BookListEntity.mapToPresentationBooks(): List<Book> {
    val books: MutableList<Book> = mutableListOf()
    this.books?.map {
        books.add(it.mapToBook())
    }
    return books
}

private fun BooksEntity.mapToBook(): Book {
    return Book(
        rank = this.rank ?: 0,
        publisher = this.publisher ?: "",
        author = this.author ?: "",
        description = this.description ?: "",
        title = this.title,
        book_image = this.book_image
    )
}