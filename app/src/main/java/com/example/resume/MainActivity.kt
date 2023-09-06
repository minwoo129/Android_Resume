package com.example.resume

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.resume.ui.theme.ResumeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ResumeTheme {
                // A surface container using the 'background' color from the theme
                MyResume()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyResume() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Android Dev Resume") }
            )
        }
    ) {paddingValues ->
        MyResumeContent(paddingValues)
    }
}

@Composable
fun MyResumeContent(paddingValues: PaddingValues) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ResumeTheme {
        MyResume()
    }
}