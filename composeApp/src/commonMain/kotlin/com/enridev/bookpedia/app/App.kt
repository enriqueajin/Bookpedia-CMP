package com.enridev.bookpedia.app

import androidx.compose.runtime.Composable
import com.enridev.bookpedia.book.presentation.book_list.BookListScreen
import com.enridev.bookpedia.book.presentation.book_list.BookListState
import com.enridev.bookpedia.book.presentation.book_list.books
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    BookListScreen(
        state = BookListState(searchResults = books),
        onAction = { }
    )
}