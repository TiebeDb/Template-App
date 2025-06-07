package com.example.templateapp.data.repository

import com.example.templateapp.data.remote.ApiService
import com.example.templateapp.model.ExampleItem
import com.example.templateapp.model.GetItems
import javax.inject.Inject

interface ExampleRepository {
    suspend fun getItems(): List<ExampleItem>
}

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