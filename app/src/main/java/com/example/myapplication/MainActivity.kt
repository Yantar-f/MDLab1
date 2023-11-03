package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.entity.Comment
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(R.color.d_surface)
                ) {
                    Column {
                        Column {
                            Header()

                            Box(
                                Modifier.padding(20.dp, 20.dp)
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
fun Header() {
    val overlayOffset = 100f

    ConstraintLayout {
        val (headerImg, headerLogo, title, stats) = createRefs()
        Image(
            painter = painterResource(R.drawable.header_sqr_img),
            contentDescription = "header image",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(headerImg) {}
        )

        Surface(
            modifier = Modifier
                .size(120.dp, 120.dp - 40.dp)
                .padding(20.dp, 0.dp)
                .clip(RoundedCornerShape(15.dp))
                .border(
                    2.dp,
                    color = colorResource(R.color.d_logo_border),
                    RoundedCornerShape(15.dp)
                )
                .constrainAs(headerLogo) {
                    top.linkTo(headerImg.bottom, margin = (-20).dp)
                },
            color = colorResource(R.color.black),
        ) {
            Image(
                painter = painterResource(R.drawable.header_logo),
                contentDescription = "logo image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.padding(15.dp, 15.dp)
            )
        }

        Column (
            Modifier
                .constrainAs(title) {
                    bottom.linkTo(headerLogo.bottom, margin = (10).dp)
                    start.linkTo(headerLogo.end)
                }
        ){
            Text(
                text = "DoTA 2",
                color = colorResource(R.color.white),
                fontWeight = FontWeight.Bold
            )
            HeaderStats()
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x050b18)
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
    Column {
        ProductTags()
        ProductDescription()
        VideoList()
    }
}

@Composable
fun ProductTags(
    tags : List<String> = listOf(
        "MMO",
        "STRATEGY",
        "MULTIPLAYER",
        "LIFEKILLER",
        "OMG",
        "WTF"
    )
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(tags) {tag ->
            Surface(
                color = colorResource(R.color.d_tag_background).copy(alpha = 0.24f),
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ){
                Text(
                    modifier = Modifier.padding(15.dp, 6.dp),
                    text = tag,
                    color = colorResource(R.color.d_tag_text_color)
                )
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x050b18)
@Composable
fun ProductTagPreview() {
    ProductTags()
}

@Composable
fun VideoList(
    videos : List<Int> = listOf(
        R.drawable.video_preview_2,
        R.drawable.header_img,
        R.drawable.video_preview_1
    )
) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
        items(videos) { videoPreviewID ->
            Image(
                painter = painterResource(id = videoPreviewID),
                contentDescription = "preview $videoPreviewID",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(220.dp, 120.dp)
                    .clip(RoundedCornerShape(15.dp))
            )
        }
    }
}

@Preview(showBackground = true,  backgroundColor = 0x050b18)
@Composable
fun VideoListPreview() {
    VideoList()
}

@Composable
fun ProductDescription(text : String = "Dota 2 description text") {
    Text(text = text)
}


@Preview(showBackground = true,  backgroundColor = 0x050b18)
@Composable
fun ProductDescriptionPreview() {
    ProductDescription()
}

@Composable
fun ReviewSection(comments : List<Comment> = listOf(Comment(), Comment(), Comment(), Comment(), Comment(), Comment(), Comment(), Comment(), Comment(), Comment())) {
    Column {
        RatingInfo()
        LazyColumn {
            items(comments) { comment -> CommentCard(comment) }
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


@Preview(showBackground = true,  backgroundColor = 0x050b18)
@Composable
fun CommentCardPreview() {
    CommentCard()
}

@Preview(showBackground = true,  backgroundColor = 0x050b18)
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

@Preview(showBackground = true,  backgroundColor = 0x050b18)
@Composable
fun InstallButtonPreview() {
    InstallButton()
}

