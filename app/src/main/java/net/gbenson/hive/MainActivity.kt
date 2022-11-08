package net.gbenson.hive

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.gbenson.hive.ui.theme.HiveTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var shareText = ""

        // https://developer.android.com/training/sharing/receive#kotlin
        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        shareText = it
                    }
                }
            }
        }

        setContent {
            HiveTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting(shareText)
                }
            }
        }
    }
}

@Composable
fun Greeting(shareText: String) {
    Text(text = shareText)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HiveTheme {
        Greeting("Android")
    }
}