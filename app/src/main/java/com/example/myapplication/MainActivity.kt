package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.myapplication.ui.theme.MyApplicationTheme
import java.util.Date

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Column {
                            Header()
                            ProductInfo()
                            ReviewSection()
                        }

                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp)
                                .padding(20.dp, 40.dp),
                            shape = RoundedCornerShape(6.dp),
                            onClick = { /*TODO*/ }
                        ) {
                            Text("Install")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header() {
    val overlayOffset : Float = 100f;

    Column {
        Image(
            painter = painterResource(R.drawable.header_sqr_img),
            contentDescription = "header image",
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f),
            contentScale = ContentScale.FillWidth
        )

        Row(
            modifier = Modifier
                .zIndex(2f)
                .graphicsLayer { translationY = -overlayOffset }
        ) {
            Image(
                painter = painterResource(R.drawable.product_logo_img),
                contentDescription = "logo image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(
                        3.dp,
                        MaterialTheme.colorScheme.secondary,
                        RoundedCornerShape(20.dp)
                    )
            )

            Column(modifier = Modifier.graphicsLayer { translationY = overlayOffset }) {
                Text(
                    text = "HEADER"
                )

                HeaderStats()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    Header()
}

@Composable
fun HeaderStats() {
    Text(text = "rating and amount of installations")
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
fun ReviewSection(comments : List<Comment> = listOf(Comment())) {
    LazyColumn {
        item { RatingInfo() }
        items(comments) { comment -> CommentCard(comment) }
    }
}


@Composable
fun RatingInfo() {

}

class Comment {
    var authorName : String = "Author"
    var date : Date = Date()
    var text : String = "some comment"
}

@Composable
fun CommentCard(comment : Comment = Comment()) {
    Column {
        Row {
            Box {
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
/*

@Preview(showBackground = true)
@Composable
fun CommentsPreview() {
    ReviewSection(listOf(Comment(), Comment(), Comment()))
}

@Preview(showBackground = true)
@Composable
fun CommentCardPreview() {
    CommentCard()
}

@Preview(showBackground = true)
@Composable
fun ProductDescriptionPreview() {
    ProductDescription()
}
*/