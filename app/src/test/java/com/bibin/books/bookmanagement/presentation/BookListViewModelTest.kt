package com.bibin.books.bookmanagement.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.bibin.books.base.domain.entity.ResponseEntity
import com.bibin.books.bookmanagement.domain.BookListUseCase
import com.bibin.books.bookmanagement.domain.entity.BookListEntity
import com.bibin.books.bookmanagement.domain.entity.BooksEntity
import com.bibin.books.bookmanagement.presentation.entity.Book
import io.reactivex.Single
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import javax.inject.Inject

@RunWith(MockitoJUnitRunner::class)
class BookListViewModelTest : TestCase() {
    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @Inject
    lateinit var bookListUseCase: BookListUseCase

    private lateinit var viewModel: BookListViewModel

    @Before
    public override fun setUp() {
        viewModel = BookListViewModel(bookListUseCase)
    }

    @Test
    fun ` verify BookList size is 1 when GetBestSellerBooks`() {
        //given
        val category = "book"
        val responseEntityMock =
            ResponseEntity(results = BookListEntity(books = createBookList()), status = "OK")
        val bookEntityMock = Single.just(responseEntityMock)
        `when`(bookListUseCase.getBetSellerBooks(category)).thenReturn(bookEntityMock)

        //when
        viewModel.getBestSellerBooks(category)

        //then
        viewModel.bookListObservable.observeForever {
            Assert.assertTrue(viewModel.bookListObservable.value?.size == 1)
        }
    }

    private fun createBookList(): List<BooksEntity> {

        val books: MutableList<BooksEntity> = mutableListOf()
        books.add(
            BooksEntity(
                rank = 1,
                author = "Sam",
                title = "Title",
                publisher = "ABC",
                description = ""
            )
        )
        return books
    }
}