package com.bibin.books.bookmanagement.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bibin.books.bookmanagement.presentation.entity.Book
import com.bibin.books.databinding.ListItemBookBinding


internal class BookListAdapter(private var list: List<Book>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return BookItemViewHolder(
            ListItemBookBinding.inflate(inflater, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as BookItemViewHolder
        viewHolder.bind(list[position])
    }

    class BookItemViewHolder(private val binding: ListItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.book = book
            binding.executePendingBindings()
        }
    }

    fun updateList(newList: List<Book>) {
        this.list = newList
        notifyDataSetChanged()
    }
}