package com.example.templateapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExampleListScreen(
    modifier: Modifier,
    viewModel: ExampleViewModel = hiltViewModel(),
    onItemSelected: (Int) -> Unit = {}
) {
    // Obtain state from the ViewModel. collectAsState() keeps the UI in sync.
    val items = viewModel.items.collectAsState()

    // Trigger the initial load when the composable is first shown.
    LaunchedEffect(Unit) { viewModel.loadItems() }

    // Simple vertical list of items in cards
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items.value.indices.toList()) { index ->
            val item = items.value[index]
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { onItemSelected(index) },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = item.name)
                    Text(text = item.description)
                }
            }
        }
    }

    // To show these cards horizontally replace LazyColumn with LazyRow
    // LazyRow(modifier = Modifier.fillMaxWidth()) { ... }
}
