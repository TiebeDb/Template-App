package com.example.templateapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExampleDetailScreen(modifier: Modifier, viewModel: ExampleViewModel = hiltViewModel()) {
    // observe the current item
    val item = viewModel.currentItem()

    // ensure items are loaded
    LaunchedEffect(Unit) { viewModel.loadItems() }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = item?.name ?: "")
        Text(text = item?.description ?: "")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { viewModel.previousItem() }) { Text("Previous") }
            Button(onClick = { viewModel.nextItem() }) { Text("Next") }
        }
    }
}
