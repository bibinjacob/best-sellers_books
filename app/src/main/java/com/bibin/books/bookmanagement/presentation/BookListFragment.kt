package com.bibin.books.bookmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bibin.books.R
import com.bibin.books.base.presentation.BaseFragment
import com.bibin.books.bookmanagement.presentation.entity.Book
import com.bibin.books.databinding.FragmentBookListBinding

class BookListFragment : BaseFragment() {
    lateinit var binding: FragmentBookListBinding
    private lateinit var bookListViewModel: BookListViewModel
    private lateinit var bookListAdapter: BookListAdapter
    private var bookList = mutableListOf<Book>()
    private var bookCategory: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookListBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        bookListViewModel =
            ViewModelProvider(this, viewModelFactory).get(BookListViewModel::class.java)
        binding.bookListViewModel = bookListViewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        initViews()
    }

    private fun initViews() {
        fetchArguments()
        bookListAdapter = BookListAdapter(bookList)
        binding.recyclerViewBookList.adapter = bookListAdapter
        bookListViewModel.getBestSellerBooks(category = bookCategory)
    }

    private fun setObservers() {
        bookListViewModel.bookListObservable.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updateList(it)
        })
    }

    private fun fetchArguments() {
        arguments?.let {
            bookCategory = it.getString(getString(R.string.arg_book_cat)) ?: ""
        }
    }
}