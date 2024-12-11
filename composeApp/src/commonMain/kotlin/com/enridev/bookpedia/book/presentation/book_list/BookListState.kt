package com.enridev.bookpedia.book.presentation.book_list

import com.enridev.bookpedia.book.domain.Book
import com.enridev.bookpedia.core.presentation.UiText

data class BookListState(
    val searchQuery: String = "",
    val searchResults: List<Book> = books,
    val favoriteBooks: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage: UiText? = null
)

val books = (0..20).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        imageUrl = "https://example.com/$it",
        authors = listOf("Enrique Ajin"),
        description = "An amazing description of book $it",
        languages = listOf("English", "Spanish"),
        firstPublishYear = "19$it",
        averageRating = 5.2,
        ratingsCount = 1200,
        numPages = 234,
        numEditions = 43
    )
}