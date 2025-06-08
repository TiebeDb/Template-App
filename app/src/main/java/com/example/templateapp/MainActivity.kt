package com.example.templateapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.templateapp.presentation.ExampleApp
import com.example.templateapp.ui.theme.TemplateAppTheme
import dagger.hilt.android.AndroidEntryPoint

// Allows Hilt to inject fields into this Activity and the Composables it hosts.
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TemplateAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ExampleApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TemplateAppTheme {
        ExampleApp()
    }
}
