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
fun ExampleScreen(viewModel: ExampleViewModel = hiltViewModel()) {
    val items = viewModel.items.collectAsState()

    LaunchedEffect(Unit) { viewModel.loadItems() }

    Column(modifier = Modifier.fillMaxSize()) {
        items.value.forEach { Text(text = it.name) }
    }
}
