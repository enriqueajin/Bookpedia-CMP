package com.enridev.bookpedia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.enridev.bookpedia.book.domain.Book
import com.enridev.bookpedia.book.presentation.book_list.BookListScreen
import com.enridev.bookpedia.book.presentation.book_list.BookListState
import com.enridev.bookpedia.book.presentation.book_list.books
import com.enridev.bookpedia.book.presentation.book_list.components.BookListItem
import com.enridev.bookpedia.book.presentation.book_list.components.BookSearchBar

@Preview()
@Composable
fun BookSearchBarPreview(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        BookSearchBar(
            searchQuery = "",
            onSearchQueryChange = {},
            onImeSearch = {},
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun BookListItemPreview() {

    val book = Book(
        id = "12345",
        title = "The Great Adventure",
        imageUrl = "https://example.com/image.jpg",
        authors = listOf("John Doe", "Jane Smith"),
        description = "An exhilarating journey into the unknown.",
        languages = listOf("English", "Spanish"),
        firstPublishYear = "2001",
        averageRating = 4.5,
        ratingsCount = 1200,
        numPages = 350,
        numEditions = 5
    )
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        BookListItem(
            book = book,
            onBookClick = {  }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun BookListScreenPreview() {
    Box(
        modifier = Modifier
            .background(Color.White)
    ) {
        BookListScreen(
            state = BookListState(searchResults = books),
            onAction = {}
        )
    }
}