package com.bibin.books.base.presentation

sealed class Status {
    object Successful : Status()
    object Failure : Status()
    object Loading : Status()
}