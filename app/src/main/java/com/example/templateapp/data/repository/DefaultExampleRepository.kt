package com.example.templateapp.data.repository

import com.example.templateapp.data.remote.ApiService
import com.example.templateapp.model.ExampleItem
import com.example.templateapp.domain.repository.ExampleRepository
import javax.inject.Inject

class DefaultExampleRepository @Inject constructor(
    private val apiService: ApiService
) : ExampleRepository {
    override suspend fun getItems(): List<ExampleItem> =
        apiService.fetchItems().map { ExampleItem(it) }
}
