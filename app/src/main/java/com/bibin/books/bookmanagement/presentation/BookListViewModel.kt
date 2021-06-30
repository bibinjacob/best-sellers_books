package com.bibin.books.bookmanagement.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.bibin.books.base.domain.entity.mapToPresentationBooks
import com.bibin.books.base.presentation.BaseViewModel
import com.bibin.books.base.presentation.Status
import com.bibin.books.base.presentation.responseEntityToResponse
import com.bibin.books.bookmanagement.domain.BookListUseCase
import com.bibin.books.bookmanagement.presentation.entity.Book
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BookListViewModel @Inject constructor(private val bookListUseCase: BookListUseCase) :
    BaseViewModel() {
    private var disposable: Disposable? = null
    val bookListObservable = MutableLiveData<List<Book>>()

    fun getBestSellerBooks(category: String) {
        if (responseStatusLiveData.value != Status.Loading) {
            disposable?.dispose()
            responseStatusLiveData.postValue(Status.Loading)
            disposable =
                bookListUseCase.getBetSellerBooks(category).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread()).map {
                        //api call is success when status = OK
                        if (it.status == "OK") {
                            bookListObservable.value = it.results?.mapToPresentationBooks()
                        }
                        //Handle loading and api error cases if any
                        handleApiResponse(it.responseEntityToResponse())
                    }.onErrorReturn {
                        Log.d("HttpError :", "$it")
                    }.subscribe()

            disposable?.let { addDisposable(it) }
        }
    }
}