package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column {
                        LazyColumn {
                            item { Header() }
                            item { ProductInfo() }
                            item { Comments() }
                        }
                        Button(onClick = { /*TODO*/ }) {

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    Column {
        Image(
            painter = painterResource(R.drawable.header_img),
            contentDescription = "header image"
        )

        Row {
            Text(text = "HEADER")
        }
    }
}

@Composable
fun ProductInfo() {
    ProductTags()
    ProductDescription()
    VideoList()
}

@Composable
fun ProductTags() {
    
}

@Composable
fun VideoList() {
    
}


@Composable
fun ProductDescription(text : String = "Dota 2 description text") {
    Text(text = text)
}


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Comments(comments : List<Comment> = listOf(Comment())) {
    LazyColumn {
        items(comments) { comment -> CommentCard(comment) }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
class Comment {
    var authorName : String = "Author"
    var date : LocalDateTime = LocalDateTime.now()
    var text : String = "some comment"
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CommentCard(comment : Comment = Comment()) {
    Column {
        Row {
            Box() {
                Image(
                    painter = painterResource(R.drawable.header_img),
                    contentDescription = "header image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(4.dp)
                        .clip(CircleShape)
                )
            }

            Column {
                Text(text = comment.authorName)
                Text(text = comment.date.toString())
            }
        }

        Text(text = comment.text)
    }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CommentsPreview() {
    Comments(listOf(Comment(), Comment(), Comment()))
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun CommentCardPreview() {
    CommentCard()
}

@Preview(showBackground = true)
@Composable
fun ProductDescriptionPreview() {
    ProductDescription();
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header();
}