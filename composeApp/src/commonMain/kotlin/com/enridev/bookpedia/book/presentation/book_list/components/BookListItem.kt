package com.enridev.bookpedia.book.presentation.book_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import cmp_bookpedia.composeapp.generated.resources.Res
import cmp_bookpedia.composeapp.generated.resources.book_error_2
import coil3.compose.rememberAsyncImagePainter
import com.enridev.bookpedia.book.domain.Book
import com.enridev.bookpedia.core.presentation.LightBlue
import org.jetbrains.compose.resources.painterResource

@Composable
fun BookListItem(
    book: Book,
    onBookClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(3.dp),
        modifier = modifier
            .clickable(onClick = onBookClick),
        color = LightBlue.copy(alpha = 0.6f)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ) {
            var imageLoadResult by remember {
                mutableStateOf<Result<Painter>?>(null)
            }
            val painter = rememberAsyncImagePainter(
                model = book.imageUrl,
                onSuccess = {
                    if(it.painter.intrinsicSize.width > 1 && it.painter.intrinsicSize.height > 1) {
                        Result.success(it.painter)
                    } else {
                        Result.failure(Exception("Invalid image size"))
                    }
                },
                onError = {
                    it.result.throwable.printStackTrace()
                    imageLoadResult = Result.failure(it.result.throwable)
                }
            )

            when(val result = imageLoadResult) {
                null -> CircularProgressIndicator()
                else -> {
                    Image(
                        painter = if(result.isSuccess) painter else painterResource(Res.drawable.book_error_2),
                        contentDescription = book.title,
                        contentScale = if(result.isSuccess) {
                            ContentScale.Crop
                        } else {
                            ContentScale.Fit
                        },
                        modifier = Modifier
                            .aspectRatio(
                                ratio = 0.65f,
                                matchHeightConstraintsFirst = true
                            )
                    )
                }
            }
        }
    }
}