package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myapplication.entity.Comment
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
                        val horizontalSidePadding = 15.dp
                        Column {
                            Header(horizontalSidePadding)

                            Box(
                                Modifier.padding(horizontalSidePadding, 0.dp)
                            ) {
                                Column {
                                    ProductInfo()
                                    ReviewSection()
                                    InstallButton()
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Header(horizontalSidePadding : Dp = 10.dp) {
    val overlayOffset : Float = 100f

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
                .wrapContentSize(unbounded = true)
        ) {
            Image(
                painter = painterResource(R.drawable.product_logo_img),
                contentDescription = "logo image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(horizontalSidePadding)
                    .clip(RoundedCornerShape(20.dp))
                    .border(
                        3.dp,
                        MaterialTheme.colorScheme.secondary,
                        RoundedCornerShape(20.dp)
                    )
            )

            Column (
                Modifier
                    .zIndex(2f)
                    .graphicsLayer { translationY = overlayOffset }
            ) {
                Text(
                    text = "DoTA 2"
                )

                HeaderStats()
            }
        }
    }
}

@Composable
fun HeaderPicture() {

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


@Preview(showBackground = true)
@Composable
fun ProductDescriptionPreview() {
    ProductDescription()
}

@Composable
fun ReviewSection(comments : List<Comment> = listOf(Comment(), Comment(), Comment())) {
    Column {
        RatingInfo()
        Box {
            LazyColumn {
                items(comments) { comment -> CommentCard(comment) }
            }
        }
    }
}


@Composable
fun RatingInfo() {
    Text("Rating info")
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


@Preview(showBackground = true)
@Composable
fun CommentCardPreview() {
    CommentCard()
}

@Preview(showBackground = true)
@Composable
fun ReviewSectionPreview() {
    ReviewSection(listOf(Comment(), Comment(), Comment()))
}

@Composable
fun InstallButton() {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),

        shape = RoundedCornerShape(10.dp),
        onClick = { /*TODO*/ }
    ) {
        Text(
            text = "Install",
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstallButtonPreview() {
    InstallButton()
}

