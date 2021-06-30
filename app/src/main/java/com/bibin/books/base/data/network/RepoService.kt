package com.bibin.books.base.data.network

import com.bibin.books.base.data.network.entity.ResponseData
import com.bibin.books.bookmanagement.data.entity.BooksListData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit class for apis
 * */
interface RepoService {

    @GET("lists/current/{category}.json")
    fun getBookList(
        @Path(value = "category", encoded = true) category: String,
        @Query(value = "api-key", encoded = true) apiKey: String
    ): Single<ResponseData<BooksListData>>
}