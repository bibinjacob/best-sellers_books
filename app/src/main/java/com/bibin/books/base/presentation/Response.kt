package com.bibin.books.base.presentation

data class Response (
    val message: String? = "",
    val status: String? = "",
    val statusCode: Int? = 0,
    val errors: List<String>? = null
)