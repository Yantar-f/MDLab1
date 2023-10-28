package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumn {
                        item { Header() }
                        item { ProductInfo() }
                        item { Comments() }
                        item {
                            Button(onClick = { /*TODO*/ }) {

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