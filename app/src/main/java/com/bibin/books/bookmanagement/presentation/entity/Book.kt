package com.bibin.books.bookmanagement.presentation.entity

data class Book(
    val rank: Int? = 0,
    val publisher: String? = "",
    val author: String? = "",
    val description: String? = "",
    val title: String? = "",
    val book_image: String? = ""
)