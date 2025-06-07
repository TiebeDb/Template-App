package com.example.templateapp.data.repository

import com.example.templateapp.data.remote.ApiService
import com.example.templateapp.model.ExampleItem
import com.example.templateapp.model.GetItems
import javax.inject.Inject

// Repository abstraction used by the ViewModel. Makes it easy to swap
// data sources or mock results in tests.
interface ExampleRepository {
    suspend fun getItems(): List<ExampleItem>
}

// Default implementation that currently returns some static data.
// The constructor is annotated with @Inject so Hilt can create an instance.
class DefaultExampleRepository @Inject constructor() : ExampleRepository {
    override suspend fun getItems(): List<ExampleItem> = GetItems()
}

/*
class DefaultExampleRepository @Inject constructor(
    private val apiService: ApiService
) : ExampleRepository {
    override suspend fun getItems(): List<ExampleItem> =
        apiService.fetchItems().map { ExampleItem(it) }
}
*/