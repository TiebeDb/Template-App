package com.example.templateapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExampleScreen(modifier: Modifier, viewModel: ExampleViewModel = hiltViewModel()) {
    // Obtain state from the ViewModel. collectAsState() keeps the UI in sync.
    val items = viewModel.items.collectAsState()

    // Trigger the initial load when the composable is first shown.
    LaunchedEffect(Unit) { viewModel.loadItems() }

    Column(modifier = Modifier.fillMaxSize()) {
        items.value.forEach { Text(text = it.name) }
    }
}
