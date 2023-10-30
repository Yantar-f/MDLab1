package com.example.myapplication

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.time.Instant
import java.time.LocalDateTime


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


@Composable
fun Comments(/*commentCards : List<CommentCard> = listOf()*/) {

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CommentCard(
    authorName : String = "Author",
    date : LocalDateTime = LocalDateTime.now(),
    text : String = "some comment"
) {
    Column {
        Row {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = "header image"
            )

            Column {
                Text(text = authorName)
                Text(text = date.toString())
            }
        }

        Text(text = text)
    }

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