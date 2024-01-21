package jp.kaleidot725.ndkdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import jp.kaleidot725.nativelib.NativeLib
import jp.kaleidot725.ndkdemo.ui.theme.AndroidNdkDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidNdkDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var text by remember { mutableStateOf("INIT") }
                    val nativeLib by remember { mutableStateOf(NativeLib()) }
                    Button(onClick = { text = nativeLib.stringFromJNI() }) {
                        Text(text = text)
                    }
                }
            }
        }
    }
}
