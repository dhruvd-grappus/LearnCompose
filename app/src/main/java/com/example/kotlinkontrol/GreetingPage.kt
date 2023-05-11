package com.example.kotlinkontrol

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kotlinkontrol.ui.theme.KotlinKontrolTheme

class GreetingPage : ComponentActivity() {

    @Composable
    fun GreetingText(
        message: String, from: String, modifier: Modifier = Modifier, viewModel: RandomViewModel
    ) {

        val gameUiState by viewModel.state.collectAsState()

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = gameUiState.num.toString(),
                fontSize = 100.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 16.dp)
            )
            Button(onClick = { viewModel.genRandom() }) {
                Text(stringResource(R.string.roll))

            }

        }
    }

    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        // Create a box to overlap image and texts
        Box(modifier) {
            Image(
                painter = painterResource(id = R.drawable.background),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,

                modifier = Modifier.fillMaxSize()

            )
            GreetingText(
                message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                viewModel = viewModel()
            )
        }
    }


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            KotlinKontrolTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        "helkoo", from = "hiweif"

                    )
                }
            }
        }
    }

}