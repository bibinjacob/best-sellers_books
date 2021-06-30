package com.bibin.books.bookmanagement.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bibin.books.R
import com.bibin.books.base.presentation.BaseFragment
import com.bibin.books.databinding.FragmentBookCategoryBinding

class BookCategoryFragment : BaseFragment() {

    lateinit var binding: FragmentBookCategoryBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookCategoryBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPictureBooks.setOnClickListener {
            val bundle = Bundle().apply {
                putString(
                    getString(R.string.arg_book_cat),
                    "picture-books"
                )
            }

            findNavController().navigate(R.id.action_fragmentBookCat_to_fragmentBookList, bundle)
        }
    }
}