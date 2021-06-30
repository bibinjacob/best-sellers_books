package com.bibin.books.bookmanagement.domain.entity

data class BookListEntity(
    val display_name: String? = "",
    val books: List<BooksEntity>? = listOf()
)