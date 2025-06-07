package com.example.templateapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.templateapp.model.ExampleItem

@Composable
fun ExampleAddScreen(modifier: Modifier, viewModel: ExampleViewModel = hiltViewModel(), onAdded: () -> Unit) {
    val nameState = remember { mutableStateOf("") }
    val descriptionState = remember { mutableStateOf("") }

    LaunchedEffect(Unit) { viewModel.loadItems() }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(value = nameState.value, onValueChange = { nameState.value = it }, label = { Text("Name") })
        OutlinedTextField(value = descriptionState.value, onValueChange = { descriptionState.value = it }, label = { Text("Description") })
        Button(onClick = {
            viewModel.addItem(ExampleItem(nameState.value, descriptionState.value))
            onAdded()
        }) {
            Text("Add")
        }
    }
}
