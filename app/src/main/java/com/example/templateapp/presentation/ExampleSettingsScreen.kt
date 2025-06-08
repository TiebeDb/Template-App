package com.example.templateapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ExampleSettingsScreen(modifier: Modifier, viewModel: ExampleViewModel = hiltViewModel()) {
    // Placeholder settings screen
    Column(modifier = modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Settings")
        // Switch would normally toggle a value stored in DataStore
        Switch(checked = false, onCheckedChange = { /* handle change */ })
    }
}
