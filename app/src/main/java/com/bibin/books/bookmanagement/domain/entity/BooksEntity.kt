package com.bibin.books.bookmanagement.domain.entity

data class BooksEntity(
    val rank: Int? = 0,
    val publisher: String? = "",
    val author: String? = "",
    val description: String? = "",
    val title: String? = "",
    val book_image: String? = ""
)
