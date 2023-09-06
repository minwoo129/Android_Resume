package com.example.resume

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    val context = LocalContext.current;

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        shape = RoundedCornerShape(30.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile2),
                contentDescription = "profile",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "자기소개",
                fontSize = 20.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "안녕하십니까. 저는 모바일 개발자입니다. 지금은 React Native를 사용하고 있지만, 안드로이드로 모바일에 입문하였습니다. JetPack Compose 너무 놀랍습니다.",
                fontSize = 15.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "어느 누구와 달리 위의 자기소개는 진심입니다.",
                fontSize = 10.sp,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(10.dp))

            Divider(color = Color.Gray, thickness = 1.dp)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "휴대폰 번호 : 010-1234-5678",
                modifier = Modifier.padding(5.dp)
            )

            Text(
                text = "이메일 : example@gmail.com",
                modifier = Modifier.padding(5.dp)
            )

            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"));
                    context.startActivity(intent);
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "전화걸기")
            }
            Button(
                onClick = {
                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                        data = Uri.parse("mailto:example@gmail.com")
                    }
                    context.startActivity(intent);
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "이메일 보내기")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ResumeTheme {
        MyResume()
    }
}