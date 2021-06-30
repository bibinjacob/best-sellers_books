package com.bibin.books.base.domain.entity

data class ResponseEntity<T>(
    val results: T? = null,
    val message: String? = "",
    val status: String? = "",
    val statusCode: Int? = 0,
    val errors: List<String>? = null
)